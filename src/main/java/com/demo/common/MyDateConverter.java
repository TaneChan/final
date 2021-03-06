package com.demo.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gangamtou
 * @date 2020/2/25 17:22
 */
public class MyDateConverter{
    public static Date convert(String s) {
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            return format.parse(s);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
