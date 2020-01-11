package se.avelon.edge.formulas;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import junit.framework.TestCase;
import se.avelon.edge.omx.datafeed.CandleFeedData;

@SuppressWarnings("deprecation")
public class FormulasTestcase extends TestCase {

	private static Vector<CandleFeedData> data = new Vector<CandleFeedData>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	static {
		//                              Date,                    op,  cp,  hp,  lp,  tv,      id,   name
		try {
			data.add(new CandleFeedData(sdf.parse("2012-01-01"), 1.0, 2.0, 2.5, 0.8, 100000, "ID", "NAME"));
			data.add(new CandleFeedData(sdf.parse("2012-01-02"), 1.2, 2.1, 2.8, 0.8, 100000, "ID", "NAME"));
			data.add(new CandleFeedData(sdf.parse("2012-01-03"), 1.5, 2.2, 2.9, 0.8, 100000, "ID", "NAME"));
			data.add(new CandleFeedData(sdf.parse("2012-01-04"), 1.8, 2.6, 2.7, 0.8, 100000, "ID", "NAME"));
			data.add(new CandleFeedData(sdf.parse("2012-01-05"), 1.6, 2.0, 2.2, 0.8, 100000, "ID", "NAME"));
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//public ExpectedException exception = ExpectedException.none();


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

	public void testMean() {
		assertEquals(2.18, Formulas.mean(data,  5), 0.01);
		
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Formulas.mean(data, 10);
		});
	}
	
	public void testDonchianHigh() {
		assertEquals(2.9, Formulas.donchianHigh(data,  5), 0.01);

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Formulas.donchianHigh(data, 10);
		});
	}		

	public void testDonchianLow() {
		assertEquals(0.8, Formulas.donchianLow(data,  5), 0.01);

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Formulas.donchianLow(data, 10);
		});
	}

	public void testFibonacci() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Formulas.fibonacci(data, 10);
		});
	}

	public void testRichochelette() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Formulas.richochette(data,  5);
		});
	}
}
