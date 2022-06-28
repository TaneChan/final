package com.demo.mapper;

import com.demo.entity.Funds;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/4/9 18:37
 */
@Component
public interface FundMapper {
    @Insert("insert into funds (uname,fdetail,fnumber,fdate) values(#{uname},#{fdetail},#{fnumber},now())")
    void addFund(@Param("uname") String uname,
                 @Param("fdetail") String fdetail,
                 @Param("fnumber") float fnumber);

    @Delete("delete from funds where fid=#{fid}")
    void delete(@Param("fid")int fid);

    @Select("select * from funds order by fdate desc")
    List<Funds> allFunds();

    @Select("select * from funds where fid=#{fid}")
    Funds fundById(@Param("fid")int fid);

    @Select("select sum(binary(fnumber)) from funds")
    String total();

}
