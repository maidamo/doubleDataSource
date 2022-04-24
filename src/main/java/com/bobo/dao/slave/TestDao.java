package com.bobo.dao.slave;

import com.bobo.domain.ProductOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestDao {

    @Select("SELECT count(1) FROM MDM_CUST_ACCOUNT_SITES_ALL")
    int getData();
}
