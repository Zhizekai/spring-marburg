package com.tjpu.zzk.service;

import com.tjpu.zzk.generator.SDao;
import com.tjpu.zzk.generator.SpjDao;
import com.tjpu.zzk.model.S;
import com.tjpu.zzk.model.Spj;
import com.tjpu.zzk.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 实现类，把Dao的方法都实现出来
 */
@Slf4j
@Service
public class SImpl implements SRestService {

    @Resource
    protected Mapper dozerMapper;


    @Resource
    protected SpjDao spjDao;
    @Resource
    private SDao sDao;

    /**
     * 保存S
     * @param s S对象
     * @return null
     */
    @Override
    public S saveS(S s) {

        S SPO = dozerMapper.map(s,S.class);

        sDao.insert(SPO);
        return null;
    }

    @Override
    public void deleteS(Integer sno) {

        sDao.deleteByPrimaryKey(sno);
    }

    @Override
    public void updateS(S s) {

        S SPO = dozerMapper.map(s,S.class);

        sDao.updateByPrimaryKeySelective(SPO);
    }

    @Override
    public S getS(Integer sno) {


        return dozerMapper.map(sDao.selectByPrimaryKey(sno),S.class);
    }

    public List<Spj> getSpj() {
        List<Spj> spjs = spjDao.findSPJSAll();
        return spjs;
    }

    @Override
    public List<S> getAll() {
        List<S> ss = sDao.selectByExample(null);
        return DozerUtils.mapList(ss,S.class);
    }



}
