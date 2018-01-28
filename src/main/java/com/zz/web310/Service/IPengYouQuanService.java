package com.zz.web310.Service;

import com.zz.web310.entity.PengYouQuan;

public interface IPengYouQuanService {
    PengYouQuan savePengYouQuan(PengYouQuan pengYouQuan);
    PengYouQuan getPengYouQuan(String userName);
    Boolean deletePengYouQuan(String userName);
}
