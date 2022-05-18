package com.jiany.coupon.feign.hystrix;

import com.jiany.conpon.vo.CommonResponse;
import com.jiany.conpon.vo.CouponTemplateSDK;
import com.jiany.coupon.feign.TemplateClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author lenovo
 */
@Slf4j
@Component

public class TemplateClientHystrix implements TemplateClient {

    /**
     * 查找所有可用的优惠券模板
     */
    @Override
    public CommonResponse<List<CouponTemplateSDK>> findAllUsableTemplate() {

        log.error("[eureka-client-coupon-template] findAllUsableTemplate " +
                "request error");
        return new CommonResponse<>(
                -1,
                "[eureka-client-coupon-template] request error",
                Collections.emptyList()
        );
    }

    /**
     * 获取模板 ids 到 CouponTemplateSDK 的映射
     * @param ids 优惠券模板 id
     */
    @Override
    public CommonResponse<Map<Integer, CouponTemplateSDK>>
    findIds2TemplateSDK(Collection<Integer> ids) {

        log.error("[eureka-client-coupon-template] findIds2TemplateSDK" +
                "request error");

        return new CommonResponse<>(
                -1,
                "[eureka-client-coupon-template] request error",
                new HashMap<>()
        );
    }
}
