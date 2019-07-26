/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: BindingResultAspect
 * Author:   YuSong
 * Date:     2019/7/26 19:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.component;

import com.raven.mall.tiny.common.api.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * <<HibernateValidator错误结果处理切面>>
 *
 * @author Raven
 * @version 1.0
 * @Description:HibernateValidator错误结果处理切面
 * @date 2019/7/26 19:14
 */
@Aspect
@Component
@Order(2)
public class BindingResultAspect {

    @Pointcut("execution(public * com.raven.mall.tiny.controller.*.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult){
                BindingResult result = (BindingResult) arg;
              if (result.hasErrors()){
                  FieldError fieldError = result.getFieldError();
                  if (fieldError != null){
                      return CommonResult.validateFailed(fieldError.getDefaultMessage());
                  }else {
                      return CommonResult.validateFailed();
                  }
              }
            }
        }
        return joinPoint.proceed();
    }
}