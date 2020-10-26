package eu.wecanconsulting.spring.demo.injection.value;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injection/value")
public class MorseController {

	@Value("#{${alphabet}}")
	private Map<String, String> morseAlphabet;

	@GetMapping("/morse/{message}")
	public String morse(@PathVariable("message") final String message) {
		return message.
				chars().
				boxed().
				map(c -> morseAlphabet.get(Character.toString(c).toUpperCase())).
				collect(Collectors.joining(" "));
	}
}
