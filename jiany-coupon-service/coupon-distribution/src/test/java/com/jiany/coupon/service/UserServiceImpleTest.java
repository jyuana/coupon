package com.jiany.coupon.service;

import com.alibaba.fastjson.JSON;

import com.jiany.conpon.exception.CouponException;
import com.jiany.coupon.constant.CouponStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImpleTest {


    private Long fakeUserId=20001L;

    @Autowired
    private IUserService userService;

    /**
     * 根据用户 id 和状态查询优惠券记录
     */
    @Test
    public void findCouponsByStatus()throws CouponException {

        System.out.println(JSON.toJSONString("===>"+
                userService.findCouponsByStatus(
                fakeUserId, CouponStatus.USABLE.getCode())));
    }

    /**
     * 根据用户id 查找当前可以领取的优惠券模板
     */
    @Test
    public void findAvailableTemplate() throws CouponException {
        System.out.println(JSON.toJSONString(
                userService.findAvailableTemplate(fakeUserId)
        ));
    }

    /**
     * 用户领取优惠券
     */
    @Test
    public void acquireTemplate() {
//        System.out.println(JSON.toJSONString(
//                userService.acquireTemplate()
//        ));
    }

    @Test
    public void settlement() {
    }
}