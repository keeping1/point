package com.example.point.cmcc.service;

import com.example.point.cmcc.service.BindingInfo;
import com.example.point.cmcc.service.BindingInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
@Mapper
@Component
public interface BindingInfoDao {
    long countByExample(BindingInfoExample example);

    int deleteByExample(BindingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BindingInfo record);

    int insertSelective(BindingInfo record);

    List<BindingInfo> selectByExample(BindingInfoExample example);

    BindingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BindingInfo record, @Param("example") BindingInfoExample example);

    int updateByExample(@Param("record") BindingInfo record, @Param("example") BindingInfoExample example);

    int updateByPrimaryKeySelective(BindingInfo record);

    int updateByPrimaryKey(BindingInfo record);
}