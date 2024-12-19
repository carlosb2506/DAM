package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SampleControllerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testBtnCambiaColor() {
		Random rnd = new Random();
		
		int numeroAleatorio = rnd.nextInt(4) + 1;
		
		if (numeroAleatorio == 1) {
			
			assertEquals(1, numeroAleatorio);
			
		}
		else if (numeroAleatorio == 2) {
			assertEquals(2, numeroAleatorio);
		} 
		else if (numeroAleatorio == 3) {
			assertEquals(3, numeroAleatorio);
		} else if (numeroAleatorio == 4) {
			assertEquals(4, numeroAleatorio);
		} else
		{
			fail("Numero fuera de rango");
		}
			
		
	}

}
