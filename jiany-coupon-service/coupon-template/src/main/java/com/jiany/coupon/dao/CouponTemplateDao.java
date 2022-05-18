package com.jiany.coupon.dao;

import com.jiany.coupon.entity.CouponTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * CouponTemplate Dao 接口定义
 * @author lenovo
 */
public interface CouponTemplateDao
        extends JpaRepository<CouponTemplate, Integer> {

    /**
     * 根据模板名称查询模板
     * where name = ...
     * */
    CouponTemplate findByName(String name);

    /**
     * 根据 available 和 expired 标记查找模板记录
     * where available = ... and expired = ...
     * */
    List<CouponTemplate> findAllByAvailableAndExpired(
            Boolean available, Boolean expired
    );

    /**
     * 根据 expired 标记查找模板记录
     * where expired = ...
     * */
    List<CouponTemplate> findAllByExpired(Boolean expired);
}