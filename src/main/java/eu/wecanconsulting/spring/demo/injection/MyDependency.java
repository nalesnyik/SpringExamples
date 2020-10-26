package eu.wecanconsulting.spring.demo.injection;

import org.springframework.stereotype.Component;

@Component
public class MyDependency implements Dependency{

	private static final String MY_DEPENDENCY_IS_CALLED = "My dependency is called: ";

	@Override
	public String reply(final String message) {
		return MY_DEPENDENCY_IS_CALLED + message;
	}

}
