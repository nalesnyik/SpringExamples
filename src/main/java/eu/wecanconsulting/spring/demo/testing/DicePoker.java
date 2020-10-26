package eu.wecanconsulting.spring.demo.testing;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicePoker {

	@Autowired
	private Random random;

	public List<Integer> throwDice() {
		return IntStream.range(0, 5).boxed().map(this::throwDie).collect(toList());
	}

	private int throwDie(int idx) {
		return random.nextInt(6) + 1;
	}

}
