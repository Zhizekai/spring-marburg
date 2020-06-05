package com.tjpu.zzk.service;

import com.tjpu.zzk.model.SVO;

import java.util.List;

public interface SRestService  {

    SVO saveS(SVO SVO);
    void deleteS(Integer sno);
    void updateS(SVO SVO);

    /**
     * 获取一个S
     * @param sno s的主键
     * @return 一个S对象
     */
    SVO getS(Integer sno);
    List<SVO> getAll();




}
