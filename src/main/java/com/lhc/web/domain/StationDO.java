package com.lhc.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author lhc
 * @Date 2020-10-27 20:35
 **/
@Data
public class StationDO {
    private String id;
    private String name;
    private String code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}