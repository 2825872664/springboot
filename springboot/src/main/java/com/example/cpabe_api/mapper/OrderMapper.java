package com.example.cpabe_api.mapper;

import com.example.cpabe_api.entity.Order;
import com.example.cpabe_api.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from t_order where uid = #{uid}")
    List<Order> selectByUid(int uid);

    //查询所有订单，同时查询订单用户
    @Select("select * from t_order")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "order_time",property = "order_time"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user",javaType = User.class,
                    one=@One(select = "com.example.cpabe_api.mapper.UserMapper.selectById")
            )
    })
    List<Order> selectAllOrdersAndUser();
}
