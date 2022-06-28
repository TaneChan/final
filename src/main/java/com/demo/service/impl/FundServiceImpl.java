package com.demo.service.impl;

import com.demo.entity.Funds;
import com.demo.mapper.FundMapper;
import com.demo.service.FundService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/4/9 18:52
 */
@Service
public class FundServiceImpl implements FundService {
    @Autowired
    FundMapper fundMapper;

    @Override
    public void add(String uname, String fdetail, float fnumber) {
        fundMapper.addFund(uname, fdetail, fnumber);
    }

    @Override
    public void delete(int fid) {
        fundMapper.delete(fid);
    }

    @Override
    public List<Funds> all(int start, int size) {
        PageHelper.startPage(start,size);
        return fundMapper.allFunds();
    }

    @Override
    public Funds fundsById(int fid) {
        return fundMapper.fundById(fid);
    }

    @Override
    public String total() {
        return fundMapper.total();
    }
}
