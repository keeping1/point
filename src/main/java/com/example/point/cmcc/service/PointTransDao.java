package com.example.point.cmcc.service;

import com.example.point.cmcc.service.PointTrans;
import com.example.point.cmcc.service.PointTransExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PointTransDao {
    long countByExample(PointTransExample example);

    int deleteByExample(PointTransExample example);

    int insert(PointTrans record);

    int insertSelective(PointTrans record);

    List<PointTrans> selectByExample(PointTransExample example);

    int updateByExampleSelective(@Param("record") PointTrans record, @Param("example") PointTransExample example);

    int updateByExample(@Param("record") PointTrans record, @Param("example") PointTransExample example);
}