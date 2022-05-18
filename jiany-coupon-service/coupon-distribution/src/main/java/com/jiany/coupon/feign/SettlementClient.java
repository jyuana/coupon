package com.jiany.coupon.feign;

import com.jiany.conpon.exception.CouponException;
import com.jiany.conpon.vo.CommonResponse;
import com.jiany.conpon.vo.SettlementInfo;
import com.jiany.coupon.feign.hystrix.SettlementClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 优惠券结算微服务 Feign 接口定义
 * @author lenovo
 */
@FeignClient(value = "eureka-client-coupon-settlement",
        fallback = SettlementClientHystrix.class)
public interface SettlementClient {

    @RequestMapping(value = "coupon-settlement/settlement/compute",
            method = RequestMethod.POST)
    CommonResponse<SettlementInfo> computeRule(
            @RequestBody SettlementInfo settlementInfo) throws CouponException;
}
