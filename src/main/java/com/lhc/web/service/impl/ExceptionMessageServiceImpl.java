package com.lhc.web.service.impl;

import com.lhc.web.dao.ExceptionMessageMapper;
import com.lhc.web.domain.ExceptionMessageDO;
import com.lhc.web.service.ExceptionMessageService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author lhc
 * @Date 2020-10-28 11:18
 **/
@Service
public class ExceptionMessageServiceImpl implements ExceptionMessageService {
    private final ExceptionMessageMapper exceptionMessageMapper;

    public ExceptionMessageServiceImpl(ExceptionMessageMapper exceptionMessageMapper) {
        this.exceptionMessageMapper = exceptionMessageMapper;
    }

    /**
     * 获取异常提示消息
     *
     * @param moduleName 模块名称
     * @param code       异常编码
     * @param args       参数变量
     * @return 提示消息
     */
    @Override
    public String getMessage(String moduleName, String code, Object[] args) {
        String message = "";
        ExceptionMessageDO exceptionMessageDO = new ExceptionMessageDO();
        if (!StringUtils.isEmpty(moduleName)) {
            exceptionMessageDO.setModuleName(moduleName);
        }
        if (!StringUtils.isEmpty(code)) {
            exceptionMessageDO.setCode(code);
        }
        List<ExceptionMessageDO> exceptionMessageDOList = exceptionMessageMapper.select(exceptionMessageDO);
        if (!CollectionUtils.isEmpty(exceptionMessageDOList)) {
            message = exceptionMessageDOList.get(0).getMessage();
        }
        return message;
    }
}