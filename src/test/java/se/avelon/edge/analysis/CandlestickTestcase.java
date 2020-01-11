package se.avelon.edge.analysis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import se.avelon.edge.analysis.Candlestick.CandlestickEnum;

public class CandlestickTestcase extends TestCase {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("=> " + Candlestick.lookup(CandlestickEnum.DragonflyDoji));
		System.out.println("=> " + Candlestick.lookup(Candlestick.analyze(2.0, 1.0, 3.0, 2.0)));
		
		for(double i = 1.0; i <= 2.0; i += +.01) {
			for(double j = 1.0; j <= 2.0; j += +.01) {
				System.out.println("=> op=" + i + ":cp=" + j + " = " + Candlestick.lookup(Candlestick.analyze(i, 1.0, 2.0, j)));
			}
		}
	}
}
