package com.jiany.coupon.service;


import com.alibaba.fastjson.JSON;
import com.jiany.conpon.constant.CouponCategory;
import com.jiany.conpon.constant.DistributeTarget;
import com.jiany.conpon.constant.PeriodType;
import com.jiany.conpon.constant.ProductLine;
import com.jiany.conpon.vo.TemplateRule;
import com.jiany.coupon.vo.TemplateRequest;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Producer;

import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static java.lang.Thread.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BuildTemplateTest {
    @Autowired
    private IBuildTemplateService buildTemplateService;

    @Test
    public void testBuildTemplate() throws Exception {
        System.out.println(JSON.toJSONString(
                buildTemplateService.buildTemplate(fakeTemplateRequest())
        ));
        sleep(5000);
    }

    private TemplateRequest fakeTemplateRequest() {
        TemplateRequest request =new TemplateRequest();
        request.setName("优惠券模板-"+new Date().getTime());
        request.setLogo("www.jiany.com");
        request.setDesc("这是一张优惠券模板");
        request.setCategory(CouponCategory.MANJIAN.getCode());
        request.setProductLine(ProductLine.MOUBAO.getCode());
        request.setCount(10000);
        request.setUserId(1000001L);
        request.setTarget(DistributeTarget.SINGLE.getCode());

        TemplateRule rule = new TemplateRule();
        rule.setExpiration(new TemplateRule.Expiration(
                PeriodType.SHIFT.getCode(),
                1, DateUtils.addDays(new Date(),60).getTime()
        ));
        rule.setDiscount(new TemplateRule.Discount(100,400));
        rule.setLimitation(1);
        rule.setUsage(new TemplateRule.Usage(
                "山西省","太原市",
                JSON.toJSONString(Arrays.asList("玩具","模型"))
        ));
        rule.setWeight(JSON.toJSONString(Collections.EMPTY_LIST));

        request.setRule(rule);
        return request;
    }
}
