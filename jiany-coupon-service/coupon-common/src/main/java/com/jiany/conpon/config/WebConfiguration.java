package com.jiany.conpon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 定制HTTP消息转化器
 * @author lenovo
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        //将java对象的实体转化为HTTP数据的输出流(JSON) spring会从多个转化器中挑选一个合适的转化器
        converters.clear();
        //定制消息转化器
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
