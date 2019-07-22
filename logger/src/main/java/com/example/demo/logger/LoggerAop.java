package com.example.demo.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author Beerus
 * @Description 日志AOP
 * @Date 2019-07-01
 **/
@Component
@Aspect
public class LoggerAop {

    private Logger logger = LoggerFactory.getLogger(LoggerAop.class);

    // TODO 改这里(更换此签名为你的包名)
    private final String POINT_CUT = "execution(* com.example.demo.controller..*(..))";


    @Pointcut(POINT_CUT)
    private void pointcut() {}

    @After("pointcut()")
    public void doAfterAdvice(JoinPoint pjp) throws Throwable {
        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();

        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Method method = target.getClass().getMethod(methodName, parameterTypes);
        if (null != method) {
            // 获取方法（此为自定义注解）
            AddLogger addLogger = method.getAnnotation(AddLogger.class);
            if (addLogger != null) {
                logger.info("describe" + addLogger.describe());
                logger.info("context" + addLogger.context());


                //TODO (改这里) 自定义的方法保存到数据库


            }
        }
    }

}
