package eu.wecanconsulting.spring.demo.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Component
public class LoggerAspect {

	@Autowired
	Logger logger;

	@Before("within(@org.springframework.web.bind.annotation.RestController *)")
	public void logEntryPoint(final JoinPoint joinPoint){
		logger.info("Rest end-point {} has been called.", getPath(joinPoint));
	}

	private String getPath(final JoinPoint joinPoint) {
		return getRequestMapping(joinPoint) +
				getMethodMapping(joinPoint, GetMapping.class) +
				getMethodMapping(joinPoint, PostMapping.class) +
				getMethodMapping(joinPoint, PutMapping.class) +
				getMethodMapping(joinPoint, DeleteMapping.class) +
				getMethodMapping(joinPoint, PatchMapping.class);
	}

	private String getMethodMapping(final JoinPoint joinPoint, final Class<?> annotation) {
		return Arrays.asList(
				((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(GetMapping.class).value()
				).stream()
				.findAny()
				.orElse("");
	}

	private String getRequestMapping(final JoinPoint joinPoint) {
		return joinPoint.getTarget().getClass().getAnnotation(RequestMapping.class).value()[0];
	}

}
