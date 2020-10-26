package eu.wecanconsulting.spring.demo.injection.value;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injection/values")
public class ValueController {


	@GetMapping("/1")
	public String hello(@Value("${name}") final String name) {
		return "Hello " + name;
	}

	@GetMapping("/2")
	public String title(@Value("${title:No title found}") final String title) {
		return title;
	}

	@GetMapping("/3")
	public String person(
			@Value("#{${person}.name}") final String name,
			@Value("#{${person}.age}") final int age) {
		return String.format("%s is %d years old.", name, age);
	}

	@GetMapping("/4")
	public String people(@Value("#{'${people}'.split(',')}") final List<String> names) {
		return names.stream().collect(Collectors.joining("<br/>"));
	}
}
