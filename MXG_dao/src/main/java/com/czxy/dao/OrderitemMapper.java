package com.czxy.dao;

import com.czxy.domain.Orderitem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/2
 */

@org.apache.ibatis.annotations.Mapper
public interface OrderitemMapper extends Mapper<Orderitem> {
    @Select("INSERT INTO `order` (`oid`, `userid`,`pname`, `price`, `number`, `sumprice`,`orderStatus`,`orderTime`) VALUES(null,#{userid},#{pname},#{price},#{number},#{sumprice},#{orderStatus},#{orderTime});")
    void add(Orderitem orderitem);

    @Select("SELECT * FROM `order` WHERE orderTime=#{orderTime}")
    public Orderitem findOrderitem(@Param("orderTime") String orderTime);

    @Select("SELECT * FROM `order` WHERE userid=#{userid}")
    public List<Orderitem> findall(@Param("userid") Integer id);

    @Delete("DELETE FROM  `order` WHERE oid=#{oid}")
    void deloid(@Param("oid") Integer  oid);
}
