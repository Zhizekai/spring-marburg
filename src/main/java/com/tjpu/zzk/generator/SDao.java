package com.tjpu.zzk.generator;

import com.tjpu.zzk.model.SVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 持久层接口
 */
public interface SDao {
    long countByExample(SExample example);

    int deleteByExample(SExample example);

    int deleteByPrimaryKey(Integer sno);

    int insert(SVO record);

    int insertSelective(SVO record);

    List<SVO> selectByExample(SExample example);

    SVO selectByPrimaryKey(Integer sno);

    int updateByExampleSelective(@Param("record") SVO record, @Param("example") SExample example);

    int updateByExample(@Param("record") SVO record, @Param("example") SExample example);

    int updateByPrimaryKeySelective(SVO record);

    int updateByPrimaryKey(SVO record);
}