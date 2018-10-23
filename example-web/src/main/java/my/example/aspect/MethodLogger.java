package my.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MethodLogger {
    private static final Logger logger = LoggerFactory.getLogger(MethodLogger.class);

    @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.trace("Entering " + joinPoint.getSignature());
        joinPoint.proceed();
        logger.trace("Finished " + joinPoint.getSignature());
        return null;
    }
}
