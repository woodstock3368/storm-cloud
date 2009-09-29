package au.id.wolfe.stormcloud.core.interceptor;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * This component is used to log method execution times for the data access layer objects.
 *
 * TODO Need to investigate how enabling this could be configurable at the application level. 
 */
@Component
@Aspect
public class DAOInterceptor {

    private Log log = LogFactory.getLog(DAOInterceptor.class);  
    
    @Around("execution(* au.id.wolfe.stormcloud.core.dao..*.*(..))")
    public Object logHibernateQueryTimes(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        
        final String targetClass = ClassUtils.getShortClassName(proceedingJoinPoint.getTarget().getClass().getName()); 
        final String methodName = proceedingJoinPoint.getSignature().getName();         
        
        StopWatch stopWatch = new StopWatch();  

        stopWatch.start();  
        Object retVal = proceedingJoinPoint.proceed();  
        stopWatch.stop();  

        StringBuilder sb = new StringBuilder();
        sb.append(targetClass).append(" - ").append(methodName).append(": ").append(stopWatch.getTime()).append(" ms");

        log.debug(sb.toString());  
        
        return retVal;  
    }
    
}
