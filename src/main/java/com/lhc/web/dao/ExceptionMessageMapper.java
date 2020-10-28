package com.lhc.web.dao;

import com.lhc.web.domain.ExceptionMessageDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface ExceptionMessageMapper extends BaseMapper<ExceptionMessageDO>, Mapper<ExceptionMessageDO>, InsertListMapper<ExceptionMessageDO> {
}
