package eu.wecanconsulting.spring.demo.injection;

import org.springframework.stereotype.Component;

@Component
public class AnotherDependency implements Dependency {

	private static final String ANOTHER_DEPENCENCY_IS_CALLED = "Another depencency is called: ";

	@Override
	public String reply(final String message) {
		return ANOTHER_DEPENCENCY_IS_CALLED + message;
	}
}
