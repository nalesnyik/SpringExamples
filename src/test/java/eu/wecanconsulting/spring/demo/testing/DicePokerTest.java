package eu.wecanconsulting.spring.demo.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DicePokerTest {

	@InjectMocks
	DicePoker dicePoker;

	@Mock
	Random random;

	@Test
	void test() {
		Mockito.doReturn(0).when(random).nextInt(6);
		assertEquals(List.of(1, 1, 1, 1, 1), dicePoker.throwDice());
	}

}
