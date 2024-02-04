package com.rmsoft.codingtest.mapper;

import com.rmsoft.codingtest.model.Subscription;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubscriptionMapper {

    @Select("SELECT * FROM subscription")
    List<Subscription> findAll();

    @Select("SELECT * FROM subscription WHERE username = #{username}")
    Subscription findByUsername(String username);

    @Insert("INSERT INTO subscription (username, serviceType, storageCapacity, remainStorageCapacity, subscriptionPeriod, useStorageCapacity , numberOfUsers , companyName , address , email ,  phoneNumber) " +
            "VALUES (#{username}, #{serviceType}, #{storageCapacity}, #{remainStorageCapacity}, #{subscriptionPeriod}, #{useStorageCapacity} , #{numberOfUsers} , #{companyName}, #{address},#{email},#{phoneNumber})")
    void save(Subscription subscription);

    @Update("UPDATE subscription SET " +
            "username = #{username}, " +
            "serviceType = #{serviceType}, " +
            "storageCapacity = #{storageCapacity}, " +
            "remainStorageCapacity = #{remainStorageCapacity}, " +
            "subscriptionPeriod = #{subscriptionPeriod}, " +
            "useStorageCapacity = #{useStorageCapacity} " +
            "WHERE username = #{username}")
    void update(Subscription subscription);

    @Update("UPDATE subscription SET " +
            "username = #{username}, " +
            "serviceType = #{serviceType}, " +
            "storageCapacity = #{storageCapacity}, " +
            "remainStorageCapacity = #{remainStorageCapacity}, " +
            "subscriptionPeriod = #{subscriptionPeriod}, " +
            "useStorageCapacity = #{useStorageCapacity} " +
            "WHERE username = #{username}")
    void useStorage(Subscription subscription);
}
