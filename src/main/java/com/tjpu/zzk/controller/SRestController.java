package com.tjpu.zzk.controller;


import com.tjpu.zzk.generator.SDao;
import com.tjpu.zzk.model.AjaxResponse;
import com.tjpu.zzk.model.SVO;
import com.tjpu.zzk.generator.SExample;
import com.tjpu.zzk.service.SImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController  //返回json格式
@RequestMapping("/rest")
public class SRestController {

    @Resource
    SImpl sImpl;


    @Resource
    SDao sDao;


    @Resource
    SExample sExample;

    /**
     * 添加商店
//     * @param s 商店对象
     * @return 商店
     */
    @ApiOperation(value = "添加S",notes = "添加新的商店",httpMethod = "POST")
    @PostMapping("/s_post")
    public AjaxResponse saveS(
//            @RequestBody S s,
                              @RequestParam String cityName,
                              @RequestParam String sName,
                              @RequestParam String status) {

        SVO SVO1 = new SVO();
        SVO1.setCity(cityName);
        SVO1.setSname(sName);
        SVO1.setStatus(status);
        int count = sDao.insertSelective(SVO1);

//        sImpl.saveS(s);

        return AjaxResponse.success(count);
    }

    /**
     * 删除
     * @param sno 主键
     * @return 商店
     */
    @ApiOperation(value = "删除商店",httpMethod = "DELETE")
    @DeleteMapping("/s_delete/{sno}")
    public AjaxResponse deleteS(@PathVariable Integer sno){
        sImpl.deleteS(sno);

        return AjaxResponse.success(sno);
    }


    /**
     * 修改上带你
     * @param sno 商店对象
     * @param SVO 商店编号
     * @return 状态
     */
    @ApiOperation(value = "修改商店",httpMethod = "PUT")
    @PutMapping("/s_put/{sno}")
    public AjaxResponse updateS(@PathVariable Integer sno,
                                @RequestBody SVO SVO) {

        SVO.setSno(sno);
        sImpl.updateS(SVO);
        return AjaxResponse.success(sno);
    }

    /**
     *
//     * @param sno 商店
     * @return 上带你
     */
    @ApiOperation(value = "获取一个商店",httpMethod = "GET")
    @GetMapping("/s_one")
    public AjaxResponse getS(@RequestParam String sCity) {

        sExample.createCriteria().andCityEqualTo(sCity);


        List<SVO> myself = sDao.selectByExample(sExample);
        return AjaxResponse.success(myself );
    }




    @ApiOperation(value = "获取所有商店",httpMethod = "GET")
    @GetMapping("/s")
    public AjaxResponse getAllS() {
        return AjaxResponse.success(sImpl.getSpj());

    }


    }
