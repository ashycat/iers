package com.samsung.iers.common.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service("springContextUtil")
public class SpringContextUtil implements ApplicationContextAware {

	Logger log = Logger.getLogger(this.getClass());
    
	private static ApplicationContext ctx;
 
    public SpringContextUtil() {
    	log.info("init SpringApplicationContext");
    }
 
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        ctx = context;
    }
 
    /**
     * 스프링 빈 조회
     * 
     * @param beanName 스프링빈 이름
     * @return
     */
    public static Object getBean(String beanName) {
        return ctx.getBean(beanName);
    }
 
    /**
     * 스프링 빈 조회
     * 
     * @param beanName 스프링빈 이름
     * @param requiredType 클래스 타입
     * @return
     */
    public static <T> T getBean(String beanName, Class<T> requiredType) {
        return ctx.getBean(beanName, requiredType);
    }
}
