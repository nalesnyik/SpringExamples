package eu.wecanconsulting.spring.demo.conversion;

import java.util.Calendar;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToUserConverter implements Converter<Person, User> {

	@Override
	public User convert(final Person source) {
		return new User(source.getName(), Calendar.getInstance().get(Calendar.YEAR) - source.getAge());
	}

}
