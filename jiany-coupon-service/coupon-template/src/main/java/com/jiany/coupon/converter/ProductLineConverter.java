package com.jiany.coupon.converter;

import com.jiany.conpon.constant.ProductLine;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 产品线枚举转化器
 * @author lenovo
 */
@Converter
public class ProductLineConverter
        implements AttributeConverter<ProductLine, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductLine productLine) {
        return productLine.getCode();
    }

    @Override
    public ProductLine convertToEntityAttribute(Integer code) {
        return ProductLine.of(code);
    }
}
