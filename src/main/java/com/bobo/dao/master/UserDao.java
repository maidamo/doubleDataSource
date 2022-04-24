package com.bobo.dao.master;

import com.bobo.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select count(1) from formtable_main_370 ")
    int getData();
}
