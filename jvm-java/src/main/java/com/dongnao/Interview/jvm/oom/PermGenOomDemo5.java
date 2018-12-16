package com.dongnao.Interview.jvm.oom;

import com.dongnao.Interview.jvm.model.TicketRunnable1;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PermGenOomDemo5 {

    public static void main(String[] args) {

        while (true) {
            // 通过　cglig　产生很多个类
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TicketRunnable1.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {

                @Override
                public Object intercept(Object obj, Method method, Object[] args,
                                        MethodProxy proxy) throws Throwable {
                    // TODO Auto-generated method stub
                    return proxy.invokeSuper(obj, args);
                    // 永久区存放 class 对象，当有很多class 对象产生时，就会占满空间，产生oom 异常
                }
            });
            enhancer.create();
        }

    }

}
