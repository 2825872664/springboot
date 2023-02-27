package com.example.cpabe_api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cpabe_api.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    //查询所有用户
//    @Select("select * from user")//里面写sql语句
//    public List<User> find();
//
//    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
//    public int insert(User user);//int表示插入了几条数据

    //查询用户及其所有订单
    //复杂的还是要自己写sql语句

    @Select("select * from t_user where id = #{id}")
    User selectById(int id);

    @Select("select * from t_user")
    @Results(
        {
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id",property = "orders",javaType = List.class,
                    many = @Many(select = "com.example.cpabe_api.mapper.OrderMapper.selectByUid")
            )

        }
    )
    List<User> selectAllUserAndOrders();
}
