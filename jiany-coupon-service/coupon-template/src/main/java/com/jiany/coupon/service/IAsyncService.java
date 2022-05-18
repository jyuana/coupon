package com.jiany.coupon.service;
import com.jiany.coupon.entity.CouponTemplate;

/**
 * 异步服务接口
 * @author lenovo
 */
public interface IAsyncService {

    /**
     * 根据模板异步的创建优惠券码 直接返回 调用方法不会阻塞
     * @param template {@link CouponTemplate} 优惠券模板实体
     * */
    void asyncConstructCouponByTemplate(CouponTemplate template);
}
