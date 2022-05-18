package com.jiany.coupon.service;

import com.jiany.conpon.exception.CouponException;
import com.jiany.coupon.entity.CouponTemplate;
import com.jiany.coupon.vo.TemplateRequest;

/**
 * 构建优惠券模板接口定义
 * @author lenovo
 */
public interface IBuildTemplateService {

    /**
     * 创建优惠券模板
     * @param request {@link TemplateRequest} 模板信息请求对象
     * @return {@link CouponTemplate} 优惠券模板实体
     * */
    CouponTemplate buildTemplate(TemplateRequest request)
            throws CouponException;
}
