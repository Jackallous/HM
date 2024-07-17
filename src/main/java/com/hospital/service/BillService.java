package com.hospital.service;

import com.github.pagehelper.PageInfo;

public interface BillService {
    PageInfo getMyBill(String page, String patid);

    boolean createBill(String patid, Integer docid, String billdate, Integer price,String type);

    Integer getPriceById(String billid);

    boolean payBill(String billid);
}
