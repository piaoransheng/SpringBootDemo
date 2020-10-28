package com.lhc.web.controller;

import com.lhc.exception.BasicRuntimeException;
import com.lhc.util.dozer.DozerUtils;
import com.lhc.web.controller.dto.StationDTO;
import com.lhc.web.dao.BasicExceptionMapper;
import com.lhc.web.domain.BasicExceptionMessageDO;
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
    private final BasicExceptionMapper basicExceptionMapper;

    public TestController(BasicExceptionMapper basicExceptionMapper) {
        this.basicExceptionMapper = basicExceptionMapper;
    }

    @ResponseBody
    @RequestMapping("/test1")
    public int test1() {
        try {
            BasicExceptionMessageDO basicExceptionMessageDO = basicExceptionMapper.selectByPrimaryKey("09beecd2ac4711e9a36038d5470ea105");
            System.out.println(basicExceptionMessageDO);
            return 1 / 0;
        } catch (Exception e) {
            throw new BasicRuntimeException("price", "10001");
        }
    }


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