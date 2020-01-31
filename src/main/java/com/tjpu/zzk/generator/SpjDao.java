package com.tjpu.zzk.generator;

import com.tjpu.zzk.model.S;
import com.tjpu.zzk.model.Spj;
import com.tjpu.zzk.model.SpjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpjDao {
    long countByExample(SpjExample example);

    int deleteByExample(SpjExample example);

    int deleteByPrimaryKey(Integer qty);

    int insert(Spj record);

    int insertSelective(Spj record);

    List<Spj> selectByExample(SpjExample example);

    Spj selectByPrimaryKey(Integer qty);

    int updateByExampleSelective(@Param("record") Spj record, @Param("example") SpjExample example);

    int updateByExample(@Param("record") Spj record, @Param("example") SpjExample example);

    int updateByPrimaryKeySelective(Spj record);

    int updateByPrimaryKey(Spj record);

    List<Spj> findSPJSAll();


}