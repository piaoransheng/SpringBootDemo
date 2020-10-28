package com.lhc.exception;

import com.alibaba.fastjson.JSONObject;
import com.lhc.web.service.ExceptionMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@ControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(CommonControllerAdvice.class);

    private final ExceptionMessageService exceptionMessageService;

    public CommonControllerAdvice(ExceptionMessageService exceptionMessageService) {
        this.exceptionMessageService = exceptionMessageService;
    }


    @ExceptionHandler
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        String message;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            status = getStatus(request);
            String moduleName = "";
            String code = "";
            Object[] args = {};
            if (ex instanceof BasicRuntimeException) {
                BasicRuntimeException basicRuntimeException = (BasicRuntimeException) ex;
                moduleName = basicRuntimeException.getModuleName();
                code = basicRuntimeException.getCode();
                args = basicRuntimeException.getArgs();
                message = exceptionMessageService.getMessage(moduleName, code, args);
                if ("UNAUTHORIZED".equals(code)) {
                    status = HttpStatus.UNAUTHORIZED;
                } else {
                    args = basicRuntimeException.getArgs();
                    message = exceptionMessageService.getMessage(moduleName, code, args);
                }
            } else {
                message = exceptionMessageService.getMessage(moduleName, code, args);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            message = "error";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", message);
        return new ResponseEntity<>(jsonObject, status);
    }

    /**
     * Customize the response for MethodArgumentNotValidException.
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "";
        try {
            String defaultMessage;
            String moduleName = "";
            String code = "";
            defaultMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
            if (!StringUtils.isEmpty(defaultMessage)) {
                if (defaultMessage.contains("_")) {
                    String[] strs = defaultMessage.split("_");
                    if (strs.length == 2) {
                        moduleName = strs[0];
                        code = strs[1];
                    }
                } else {
                    message = defaultMessage;
                }
            }
            if (StringUtils.isEmpty(message) && !StringUtils.isEmpty(moduleName) && !StringUtils.isEmpty(code)) {
                message = exceptionMessageService.getMessage(moduleName, code, null);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            message = "error";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", message);
        return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Customize the response for BindException.
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance
     */
    @Override
    protected ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, null, headers, status, request);
    }

    /**
     * 获取http状态码
     *
     * @param request HttpServletRequest
     * @return HttpStatus
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}