package com.itsolution.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Log logger=LogFactory.getLog(LoggingAspect.class);
	
	@AfterThrowing(pointcut = "execution(* com.reservation.service.*Impl.*(..))",throwing = "exception")
	public void logExceptionFromService(Exception exception) {
		logger.error(exception.getMessage(),exception);
	}
}
