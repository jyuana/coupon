package com.jiany.conpon.vo;

import com.jiany.conpon.constant.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lenovo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRule {

    /** 优惠券过期规则 */
    private Expiration expiration;
    /** 折扣 */
    private Discount discount;
    /** 领取数量 */
    private Integer limitation;
    /** 适用类型 地域加商品类型 */
    private Usage usage;
    /** 权重 （可以和哪些优惠券叠加使用，同一类的优惠券一定不能叠加）：List[],优惠券的唯一编码  */
    private String weight;

    /**
     * 校验功能
     * @return 是否有效
     */
    public boolean validate() {

        return expiration.validate() && discount.validate()
                && limitation > 0 && usage.validate()
                && StringUtils.isNotEmpty(weight);
    }

    /**
     * 有效期规则
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Expiration{
        //有效期规则
        private Integer period;
        //有效间隔
        private Integer gap;
        //失效日期
        private Long deadline;

        boolean validate() {
            return null != PeriodType.of(period) && gap>0 && deadline >0;
        }
    }

    /**
     * 折扣，需要配合类型决定
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Discount{

        private Integer quota;
        //需要满多少才可以，只适用满减券
        private Integer base;

        boolean validate() {
            return quota>0 && base >0;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usage {

        //省份
        private String province;
        //城市
        private String city;
        //商品类型
        private String goodsType;

        boolean validate() {

            return StringUtils.isNotEmpty(province)
                    && StringUtils.isNotEmpty(city)
                    && StringUtils.isNotEmpty(goodsType);
        }
    }

}
