package com.zz.web310.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/calculate")
public class CalculateController {

    @RequestMapping(value = "/add")
    public Integer add(Integer v1, Integer v2){
        if(v1==null||v1==null)
            return 0;
        return v1+v2;
    }

    // host:port/path/param

    @RequestMapping(value = "/add/{v1}-{v2}")
    // PathVariable 利用url 来传参
    public Integer add2(@PathVariable Integer v1,
                       @PathVariable Integer v2){
        if(v1==null||v1==null)
            return 0;
        System.out.println("==========");
        return v1+v2;
    }
    //param -> sumList
    // 1,2,3,4,5 List<Integer>
    // 1,2,3,4,5.split(",") foreach -> Integer.valueOf("1")
    // -> list.add(1)
    // param 名字 要一直 sumList, 可以传 由，分割的字符串
    @RequestMapping(value = "/sum")
    public Integer sum(@RequestParam List<Integer> sumList) {
        if (sumList == null || sumList.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int value : sumList) {
            sum = sum + value;
        }
        return sum;
    }




//    @RequestMapping(value = "/sub")
//    public Integer sub(Integer v1, Integer v2){
//        if(v1==null||v1==null)
//            return 0;
//        return v1-v2;
//    }
//    @RequestMapping(value = "/mutiple")
//    public Integer mutiple(Integer v1, Integer v2){
//        if(v1==null||v1==null)
//            return 0;
//        return v1*v2;
//    }
//    @RequestMapping(value = "/divide")
//    public Integer divide(Integer v1, Integer v2){
//        if(v1==null||v1==null)
//            return 0;
//        return v1/v2;
//    }

}
