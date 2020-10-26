package eu.wecanconsulting.spring.demo.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPersonConverter implements Converter<String, Person> {

	@Override
	public Person convert(final String source) {
		final String[] data = source.split(";");
		return Person.builder()
				.name(data[0])
				.age(Integer.parseInt(data[1])).build();
	}

}
