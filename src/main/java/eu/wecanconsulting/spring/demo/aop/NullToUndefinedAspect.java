package eu.wecanconsulting.spring.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NullToUndefinedAspect {

	private static final String UNDEFINED = "UNDEFINED";

	@Pointcut("execution(* *..*(java.lang.String,..))")
	public void stringFirstArgument() {}

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void restControllerMethod() {}

	@Around("stringFirstArgument() && restControllerMethod()")
	public Object changeNullToUndefined(final ProceedingJoinPoint joinPoint) throws Throwable {
		final Object[] args = joinPoint.getArgs();
		if (args[0] == null) {
			args[0] = UNDEFINED;
		}
		return joinPoint.proceed(args);
	}

}
