package eu.wecanconsulting.spring.demo.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injection")
public class InjectionController {

	private static final String SETTER = "Setter";
	private static final String FIELD = "Field";
	private static final String CONSTRUCTOR = "Constructor";
	private static final String LINE_BREAK = "<br/>";

	@Autowired
	@Qualifier("anotherDependency")
	private Dependency fieldInjectedDependency;

	private final Dependency constructorInjectedDependency;

	private MyDependency setterInjectedDependency;

	@Autowired
	public InjectionController(@Qualifier("myDependency") final Dependency constructorInjectedDependency) {
		this.constructorInjectedDependency = constructorInjectedDependency;
	}

	@Autowired
	public void setSetterInjectedDependency(final MyDependency setterInjectedDependency) {
		this.setterInjectedDependency = setterInjectedDependency;
	}

	@GetMapping("/")
	public String demoInjection() {
		return constructorInjectedDependency.reply(CONSTRUCTOR) + LINE_BREAK + fieldInjectedDependency.reply(FIELD)
				+ LINE_BREAK + setterInjectedDependency.reply(SETTER);

	}
}
