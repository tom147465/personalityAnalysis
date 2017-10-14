package com.zz.web310.Service;

import com.zz.web310.entity.PengYouQuan;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service(value = "pyq") // create bean pengyouquanserviceImpl name pyq
//@Component
public class PengYouQuanServiceImpl implements IPengYouQuanService {
    private Map<String, PengYouQuan> pengYouQuanHolder;

    @PostConstruct// 1.create bean 2.invoke postconstruct method // 3. input container
    // construct() then PostConstruct()
    private void init(){
        pengYouQuanHolder = new HashMap<String, PengYouQuan>();
    }


    @Override
    public PengYouQuan savePengYouQuan(PengYouQuan pengYouQuan) {
        if(pengYouQuan == null || pengYouQuan.getUser() == null){
            return null;
        }

        String user = pengYouQuan.getUser();
        pengYouQuanHolder.put(user, pengYouQuan);
        for(Map.Entry<String, PengYouQuan> ppp : pengYouQuanHolder.entrySet()){
            System.out.println(ppp.getKey()+ "=====" + ppp.getValue());
        }
        return pengYouQuan;
    }

    @Override
    public PengYouQuan getPengYouQuan(String userName) {
        return pengYouQuanHolder.get(userName);
    }

    @Override
    public Boolean deletePengYouQuan(String userName) {
        if (pengYouQuanHolder.containsKey(userName)) {
            pengYouQuanHolder.remove(userName);
            return true;
        }
        return false;
    }
}
