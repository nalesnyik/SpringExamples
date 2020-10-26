package eu.wecanconsulting.spring.demo.injection.prototype;

import java.lang.reflect.Field;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

@Configuration
public class LoggerConfig {

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public Logger logger(final InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(getClassNameOfInjectionPoint(injectionPoint));
	}

	private Class<?> getClassNameOfInjectionPoint(final InjectionPoint injectionPoint) {
		return getClassNameByMethodInjection(injectionPoint)
				.orElseGet(() -> getClassNameByFieldInjection(injectionPoint)
						.orElseThrow(IllegalArgumentException::new)
						);
	}

	private Optional<Class<?>> getClassNameByFieldInjection(final InjectionPoint injectionPoint) {
		return Optional.ofNullable(injectionPoint.getField())
				.map(Field::getDeclaringClass);
	}

	private Optional<Class<?>> getClassNameByMethodInjection(final InjectionPoint injectionPoint) {
		return Optional.ofNullable(injectionPoint.getMethodParameter())
				.map(MethodParameter::getContainingClass);
	}
}