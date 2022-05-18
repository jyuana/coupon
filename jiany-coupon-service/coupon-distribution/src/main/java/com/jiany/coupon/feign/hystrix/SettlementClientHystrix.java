package com.jiany.coupon.feign.hystrix;

import com.jiany.conpon.exception.CouponException;
import com.jiany.conpon.vo.CommonResponse;
import com.jiany.conpon.vo.SettlementInfo;
import com.jiany.coupon.feign.SettlementClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 结算微服务熔断策略实现
 * @author lenovo
 */
@Slf4j
@Component
public class SettlementClientHystrix implements SettlementClient {

    /**
     * 优惠券规则计算
     * @param settlement {@link SettlementInfo}
     */
    @Override
    public CommonResponse<SettlementInfo> computeRule(SettlementInfo settlement)
            throws CouponException {

        log.error("[eureka-client-coupon-settlement] computeRule" +
                "request error");

        settlement.setEmploy(false);
        settlement.setCost(-1.0);

        return new CommonResponse<>(
                -1,
                "[eureka-client-coupon-settlement] request error",
                settlement
        );
    }
}

