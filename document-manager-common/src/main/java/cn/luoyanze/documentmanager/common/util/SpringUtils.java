package cn.luoyanze.documentmanager.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 9:32 PM
 */


@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    public static void setContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> t) {
        return context.getBean(t);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }
}
