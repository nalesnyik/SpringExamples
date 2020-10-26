package eu.wecanconsulting.spring.demo.conversion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
	private String name;
	private int age;
}
