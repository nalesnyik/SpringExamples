package eu.wecanconsulting.spring.demo.injection.prototype;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyLoggingService {

	private static final String SOMETHING = "SOMETHING";

	@Autowired
	private Logger logger;

	public void logSomething() {
		logger.info(SOMETHING);
	}

}
