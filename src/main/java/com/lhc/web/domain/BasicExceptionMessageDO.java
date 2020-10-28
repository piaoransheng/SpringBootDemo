package com.lhc.web.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @Author lhc
 * @Date 2020-10-28 10:49
 **/
@Data
@Table(name = "basic_exception_message")
public class BasicExceptionMessageDO {
    @Id
    @Column(name = "exm_id")
    private String id;
    @Column(name = "exm_module_name")
    private String moduleName;
    @Column(name = "exm_code")
    private Integer code;
    @Column(name = "exm_message")
    private String message;
    @Column(name = "exm_language_id")
    private String languageId;
    @Column(name = "exm_is_default")
    private Boolean isDefault;
    @Column(name = "exm_create_time")
    private LocalDateTime createTime;
    @Column(name = "exm_update_time")
    private LocalDateTime updateTime;
    @Column(name = "exm_creator_id")
    private String creatorId;
    @Column(name = "exm_update_operator_id")
    private String updateOperatorId;
    @Column(name = "exm_is_available")
    private Boolean isAvailable;
}