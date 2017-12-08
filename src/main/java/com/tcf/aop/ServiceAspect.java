package com.tcf.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.tcf.annotation.Transfuse;
import com.tcf.basebean.Info;
import com.tcf.util.Convert;

@Component
@Aspect
public class ServiceAspect {
	/**
	 * 日志记录
	 */
	private static final Logger logger = Logger.getLogger(ServiceAspect.class);
	
	/*@Before("aPointcut()")
	public void before(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		Object[] args = jp.getArgs();
		logger.debug(String.format("【注解】前置通知：正在调用%s类的%s方法，传入的参数为：%s", className,methodName,Arrays.toString(args)));
	}*/
	/*@AfterReturning(pointcut="aPointcut()",returning="returnVal")
	public void afterReturning(JoinPoint jp,Object returnVal){
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		Object[] args = jp.getArgs();
		logger.debug(String.format("【注解】后置通知：正在调用%s类的%s方法，传入的参数为：%s，返回值 ：%s", className,methodName,Arrays.toString(args),returnVal));
	}*/
	@Around("aPointcut()")
	public Object around(ProceedingJoinPoint jp){
		//信息收集
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		Object[] args = jp.getArgs();
		Object target = jp.getTarget();
		logger.debug(String.format("【注解】前置通知：正在调用%s类的%s方法，传入的参数为：%s", className,methodName,Arrays.toString(args)));
		//收集对象和分页信息
		if("search".equals(methodName)){
			infoCollection(target,(Map<String,Object>)args[0]);
		}
		//执行方法
		try {
			//如果服务层没有报错，就返回结果
			return jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//如果服务层报错就，返回错误信息
			return new Info(null, e.getMessage());
		}
	}
	
	public void infoCollection(Object target,Map<String,Object> map){
		Convert convert = Convert.getConvert(map);
		Field[] fields = target.getClass().getDeclaredFields();
		for(Field field:fields){
			field.setAccessible(true);//无视修饰符
			String fieldName = field.getName();
			//如果字段被Transfuse注解修饰就进行注入
			if(field.getAnnotation(Transfuse.class) != null){
				try {
					field.set(target, convert.getObject(field.getType(),fieldName));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*@AfterThrowing(pointcut="aPointcut()",throwing="ex")
	public void throwing(JoinPoint jp,Throwable ex){
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		Object[] args = jp.getArgs();
		logger.debug(String.format("【注解】异常通知：正在调用%s类的%s方法，传入的参数为：%s，异常信息 ：%s", className,methodName,Arrays.toString(args),ex.getMessage()));
	}*/
	
	/*@After("aPointcut()")
	public void after(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		Object[] args = jp.getArgs();
		logger.debug(String.format("【注解】最终通知：正在调用%s类的%s方法，传入的参数为：%s", className,methodName,Arrays.toString(args)));
	}*/
	
	/**
	 * 为所有通知生成一个切点，引用时只需要使用方法的签名（aPointcut()）
	 */
	@Pointcut("execution(* com.tcf.service.impl.*.*(..))")
	private  void aPointcut(){
	}
}
