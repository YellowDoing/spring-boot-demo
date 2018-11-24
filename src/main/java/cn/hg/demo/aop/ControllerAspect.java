package cn.hg.demo.aop;

import cn.hg.demo.dao.TokenMapper;
import cn.hg.demo.entity.BaseBean;
import cn.hg.demo.exception.TokenException;
import cn.hg.demo.exception.ValidateException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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

            /*
             * 参数校验
             */
            if (o instanceof BeanPropertyBindingResult){
                BeanPropertyBindingResult beanPropertyBindingResult = (BeanPropertyBindingResult)o;
                if (beanPropertyBindingResult.hasErrors()){
                    throw new ValidateException(beanPropertyBindingResult.getAllErrors().get(0));
                }
            }

            /*
             * token验证
             */
           /* if (o instanceof BaseBean){
                if (tokenMapper.checkToken(((BaseBean) o).getToken()) != 1){
                    throw  new TokenException();
                }
            }*/
        }
        return jp.proceed();
    }

}



