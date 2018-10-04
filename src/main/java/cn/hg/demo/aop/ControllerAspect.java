package cn.hg.demo.aop;

import cn.hg.demo.exception.ValidateException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;


/**
 * 控制器校验
 */
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(* cn.hg.demo.controller..*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object validateErrors(ProceedingJoinPoint jp) throws Throwable {
        Object[] objects = jp.getArgs();
        for (Object o : objects ){
            System.out.println(o.getClass().getName());
            System.out.println(o.getClass().getDe);
            if (o instanceof BeanPropertyBindingResult){
                if (((BeanPropertyBindingResult)o).hasErrors()){
                    throw new ValidateException(((BeanPropertyBindingResult)o).getAllErrors().get(0));
                }
            }
        }
        return jp.proceed();
    }



}
