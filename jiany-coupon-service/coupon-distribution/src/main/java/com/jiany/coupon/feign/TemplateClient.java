package com.jiany.coupon.feign;

import com.jiany.conpon.vo.CommonResponse;
import com.jiany.conpon.vo.CouponTemplateSDK;
import com.jiany.coupon.feign.hystrix.TemplateClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 优惠券模板微服务接口 Feign 接口定义
 * @author lenovo
 */
@FeignClient(value = "eureka-client-coupon-template",
        fallback = TemplateClientHystrix.class)
public interface TemplateClient {

    /**
     * 查找所有可用的优惠券模板
     * @return {@link CommonResponse}
     */
    @RequestMapping("/coupon-template/template/sdk/all")
    CommonResponse<List<CouponTemplateSDK>> findAllUsableTemplate();

    /**
     * 获取模板 Ids 到 CouponTemplateSDK 的映射
     * @return {@link CommonResponse}
     */
    @RequestMapping("/coupon-template/template/sdk/infos")
    CommonResponse<Map<Integer, CouponTemplateSDK>> findIds2TemplateSDK(
            @RequestParam("ids") Collection<Integer> ids
    );
}
