package com.demo.service;

import com.demo.entity.Funds;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/4/9 18:49
 */
public interface FundService {
    void add(String uname,String fdetail, float fnumber);
    void delete(int fid);
    List<Funds> all(int start,int size);
    Funds fundsById(int fid);
    String total();
}
