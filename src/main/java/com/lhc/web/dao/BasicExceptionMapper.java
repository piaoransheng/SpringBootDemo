package com.lhc.web.dao;

import com.lhc.web.domain.BasicExceptionMessageDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface BasicExceptionMapper extends BaseMapper<BasicExceptionMessageDO>, Mapper<BasicExceptionMessageDO>, InsertListMapper<BasicExceptionMessageDO> {
}
