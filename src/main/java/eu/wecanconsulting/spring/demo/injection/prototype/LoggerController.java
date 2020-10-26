package eu.wecanconsulting.spring.demo.injection.prototype;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injection/log")
public class LoggerController {

	private static final String I_M_THE_CONTROLLER = "I'm the controller";
	private static final String CHECK_YOUR_LOGS = "Check your logs";

	@Autowired
	private MyLoggingService service;

	@Autowired
	private Logger logger;

	@GetMapping()
	public String logging() {
		logger.info(I_M_THE_CONTROLLER);
		service.logSomething();
		return CHECK_YOUR_LOGS;
	}
}
