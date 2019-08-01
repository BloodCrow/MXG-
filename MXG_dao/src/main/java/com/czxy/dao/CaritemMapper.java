package com.czxy.dao;

import com.czxy.domain.Caritem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/1
 */
@org.apache.ibatis.annotations.Mapper
public interface CaritemMapper extends Mapper<Caritem> {

    @Select("INSERT INTO shoppingcart VALUES (null,#{userid},#{proid},#{number})")
    public void addCart(Caritem caritem);


    @Select("SELECT * FROM shoppingcart WHERE userid=#{userid} AND proid=#{proid}")
    public Caritem find(Caritem caritem);

    @Select("UPDATE shoppingcart SET number=#{number}  WHERE userid=#{userid} AND proid=#{proid}")
    public void update(Caritem caritem);

    @Select("SELECT * FROM shoppingcart WHERE userid=#{userid}")
    public List<Caritem> findall(@Param("userid") Integer id);

    @Delete("DELETE FROM shoppingcart WHERE upid=#{upid}")
    public void delupid(@Param("upid")Integer upid);

    @Delete("DELETE FROM shoppingcart WHERE userid=#{userid}")
    public void Cleanall(@Param("userid")Integer userid);
}
