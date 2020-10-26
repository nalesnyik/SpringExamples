package eu.wecanconsulting.spring.demo.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class NullableControllerTest {

	private static final String NAME = "name";

	private static final String NAMED_RESPONSE = "Hi Eszter Gal!";

	private static final String ESZTER_GAL = "Eszter Gal";

	private static final String UNDEFINED_RESPONSE = "Hi UNDEFINED!";

	private static final String PATH = "/aop/optional";

	private static final String LOCALHOST = "http://localhost:";

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testNullPropertyIsReplacedByUNDEFINED() {
		assertEquals(UNDEFINED_RESPONSE, restTemplate.getForObject(getUrl(), String.class));
	}

	@Test
	void testNonNullPropertyIsNotReplaced() {
		assertEquals(NAMED_RESPONSE,
				restTemplate.getForObject(getUrl() + "?name={name}", String.class, Map.of(NAME, ESZTER_GAL)));
	}

	private String getUrl() {
		return new StringBuilder().append(LOCALHOST).append(port).append(PATH).toString();
	}

}
