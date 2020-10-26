package eu.wecanconsulting.spring.demo.conversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversion/implicit")
public class ImplicitConverterController {
	private static final String INTRODUCTION_TEMPLATE = "Hello, my name is %s and I'm %d years old.";
	private static final String PERSON_PARAM = "person";

	@GetMapping
	public String introduce(@RequestParam(PERSON_PARAM) final Person person) {
		return String.format(INTRODUCTION_TEMPLATE,
				person.getName(),
				person.getAge());
	}
}
