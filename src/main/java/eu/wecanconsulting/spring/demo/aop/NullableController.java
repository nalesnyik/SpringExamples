package eu.wecanconsulting.spring.demo.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop/optional")
public class NullableController {

	@GetMapping
	public String sayHi(@RequestParam(name = "name", required = false) final String name) {
		if (name == null) {
			return "Hi Sanyi!";
		}
		return "Hi " + name + "!" ;
	}
}
