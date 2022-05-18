package com.jiany.coupon.executor;


import com.jiany.conpon.vo.SettlementInfo;
import com.jiany.coupon.constant.RuleFlag;

/**
 * 优惠券模板规则处理器接口定义
 * Created by Qinyi.
 * @author lenovo
 */
public interface RuleExecutor {

    /**
     * 规则类型标记
     * @return {@link RuleFlag}
     * */
    RuleFlag ruleConfig();

    /**
     * 优惠券规则的计算
     * @param settlement {@link SettlementInfo} 包含了选择的优惠券
     * @return {@link SettlementInfo} 修正过的结算信息
     * */
    SettlementInfo computeRule(SettlementInfo settlement);
}
