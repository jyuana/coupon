package com.jiany.coupon.dao;

import com.jiany.coupon.constant.CouponStatus;
import com.jiany.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * CouponDao接口
 * @author lenovo
 */
public interface CouponDao extends JpaRepository<Coupon, Integer> {

    /**
     * 根据 userId + 状态寻找优惠券记录
     * where userId = ... and status = ...
     * */
    List<Coupon> findAllByUserIdAndStatus(Long userId, CouponStatus status);
}

