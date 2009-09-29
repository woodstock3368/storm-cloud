/**
 * Copyright (C) 2009 Mark Wolfe <mark@wolfe.id.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
