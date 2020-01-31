package com.tjpu.zzk.service;

import com.tjpu.zzk.generator.SDao;
import com.tjpu.zzk.model.S;

import java.util.List;

public interface SRestService  {

    S saveS(S s);
    void deleteS(Integer sno);
    void updateS(S s);

    /**
     * 获取一个S
     * @param sno s的主键
     * @return 一个S对象
     */
    S getS(Integer sno);
    List<S> getAll();




}
