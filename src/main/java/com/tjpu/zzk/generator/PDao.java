package com.tjpu.zzk.generator;

import com.tjpu.zzk.model.P;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Data Access Objects（DAO）
 */
public interface PDao {
    long countByExample(PExample example);

    int deleteByExample(PExample example);

    int deleteByPrimaryKey(Integer PNO);

    int insert(P record);

    int insertSelective(P record);

    List<P> selectByExample(PExample example);

    P selectByPrimaryKey(Integer PNO);

    int updateByExampleSelective(@Param("record") P record, @Param("example") PExample example);

    int updateByExample(@Param("record") P record, @Param("example") PExample example);

    int updateByPrimaryKeySelective(P record);

    int updateByPrimaryKey(P record);
}