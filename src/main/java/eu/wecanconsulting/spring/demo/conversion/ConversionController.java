package eu.wecanconsulting.spring.demo.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversion")
public class ConversionController {

	@Autowired
	private ConversionService conversionService;

	@GetMapping
	public User convert(@RequestParam("person") final String person) {
		final Person parsedPerson = conversionService.convert(person, Person.class);
		return conversionService.convert(parsedPerson, User.class);
	}
}
