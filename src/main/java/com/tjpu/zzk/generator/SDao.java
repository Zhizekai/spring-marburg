package com.tjpu.zzk.generator;

import com.tjpu.zzk.model.S;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 持久层接口
 */
public interface SDao {
    long countByExample(SExample example);

    int deleteByExample(SExample example);

    int deleteByPrimaryKey(Integer sno);

    int insert(S record);

    int insertSelective(S record);

    List<S> selectByExample(SExample example);

    S selectByPrimaryKey(Integer sno);

    int updateByExampleSelective(@Param("record") S record, @Param("example") SExample example);

    int updateByExample(@Param("record") S record, @Param("example") SExample example);

    int updateByPrimaryKeySelective(S record);

    int updateByPrimaryKey(S record);
}