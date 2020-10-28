package com.lhc.web.controller;

import com.lhc.util.dozer.DozerUtils;
import com.lhc.web.controller.dto.StationDTO;
import com.lhc.web.domain.StationDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * @Author lhc
 * @Date 2020-10-27 20:06
 **/
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test2")
    public StationDTO test2() {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setCode("站点编码");
        stationDTO.setName("站点名称");
        stationDTO.setCreateTime(LocalDateTime.now());
        StationDO stationDO = DozerUtils.map(stationDTO, StationDO.class);
        System.out.println(stationDTO);
        System.out.println(stationDO);

        return stationDTO;
    }
}