package com.nmincuzzi.ipweather.infrastructure

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.ShallowEtagHeaderFilter

@Configuration
class WebConfig {
    //Server-side Cache Validation -- ETag
    @Bean
    fun shallowEtagHeaderFilter(): FilterRegistrationBean<ShallowEtagHeaderFilter> {
        val filterRegistrationBean = FilterRegistrationBean(ShallowEtagHeaderFilter())
        filterRegistrationBean.addUrlPatterns("/*")
        filterRegistrationBean.setName("etagFilter")
        return filterRegistrationBean
    }
}