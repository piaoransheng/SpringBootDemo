package com.lhc.exception;

import lombok.Getter;

import java.util.Arrays;

/**
 * @Author lhc
 * @Date 2020-10-28 10:31
 **/
public class BasicRuntimeException extends RuntimeException  {
    @Getter
    private String moduleName;
    @Getter
    private String code;
    @Getter
    private Object[] args;

    public BasicRuntimeException(String moduleName, String code) {
        super(moduleName + "_" + code);
        this.moduleName = moduleName;
        this.code = code;
    }

    public BasicRuntimeException(String moduleName, String code, Object[] args) {
        super(moduleName + "_" + code + "_" + Arrays.toString(args));
        this.moduleName = moduleName;
        this.code = code;
        this.args = args;
    }
}