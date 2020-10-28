package com.lhc.web.service;

public interface ExceptionMessageService {

    /**
     * 获取异常提示消息
     *
     * @param moduleName 模块名称
     * @param code       异常编码
     * @param args       参数变量
     * @return 提示消息
     */
    String getMessage(String moduleName, String code, Object[] args);
}
