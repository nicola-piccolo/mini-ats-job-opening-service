package org.miniats.jobopeningservice.util;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
public class RetryableDatabasePostProcessor implements BeanPostProcessor {
	@Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DataSource) {
            return new RetryableDataSource((DataSource) bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}