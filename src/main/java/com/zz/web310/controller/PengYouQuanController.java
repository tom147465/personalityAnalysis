package com.zz.web310.controller;

import com.zz.web310.Service.IPengYouQuanService;
import com.zz.web310.entity.PengYouQuan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pyq")
public class PengYouQuanController {
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    //method determine url post
    // RequestBody    request -> Json -> java instance
    // RequestMethod  using for a Object
    private PengYouQuan postPengYouQuan(@RequestBody PengYouQuan pyq){
        if(pyq == null){
            PengYouQuan pengYouQuan = new PengYouQuan();
            pengYouQuan.setUser("NoBody");
            return pengYouQuan;
        }
        return pyq;
    }

    @Autowired
    // == applicationContext.getBean(IPengYouQuanService)
    @Qualifier(value = "pyq")
    // spring help to bind DI
    private IPengYouQuanService pengYouQuanService;

    //controller -> handle request
    // request -> dispatch requestParam to service
    // 1.controller
    // 2.service
    // 3.repo


    // http 规范中 delete option  no params
    // url 来描述资源
    // 1.Get  获取数据
    // 2.Post 上传或更新
    // 3.Delete 删除
    // 4.Put  更新,必须是幂等  幂等(无论操作多少次, )
    // 5.Option -> get mothod list (GET/POST) 配置前端框架 才会碰到
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    //upload or reload
    public PengYouQuan savePengYouQuan(@RequestBody PengYouQuan pengYouQuan){
        if(pengYouQuan!=null){
            System.out.println(pengYouQuan.getUser());
           return pengYouQuanService.savePengYouQuan(pengYouQuan);
        }
        return null;
    }
}
