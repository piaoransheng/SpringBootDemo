package com.lhc.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author lhc
 * @Date 2020-10-27 20:35
 **/
@Data
public class StationDTO {
    private String name;
    private String code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}