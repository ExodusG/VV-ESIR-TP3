package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class DateTest {

	@Test
	public void testIsLeapYearCorrect() {
		assertTrue(Date.isLeapYear(0));
	}

	@Test
	public void testIsLeapYearWithYearUnder0() {
		assertFalse(Date.isLeapYear(-100));
	}

	@Test
	public void testIsLeapYearCorrectDividedBy4() {
		assertTrue(Date.isLeapYear(2028));
	}


	@Test
	public void testIsLeapYearCorrectDividedBy400() {
		assertTrue(Date.isLeapYear(2400));
	}


	@Test
	public void testIsLeapYearCorrectDividedBy400_2() {
		assertTrue(Date.isLeapYear(2020));
	}


	@Test
	public void testIsLeapYearWrong() {
		assertFalse(Date.isLeapYear(2022));
	}


	@Test
	public void testIsLeapYearWrong1900() {
		assertFalse(Date.isLeapYear(1900));
	}


	@Test
	public void testIsLeapYearCorrect0() {
		assertTrue(Date.isLeapYear(0));
	}

	@Test
	public void testIsValidDateCorrect() {
		assertTrue(Date.isValidDate(5, 12, 2022));
	}

	@Test
	public void testIsValidDate31December() {
		assertTrue(Date.isValidDate(31, 12, 2022));
	}

	@Test
	public void testIsValidDate31October() {
		assertTrue(Date.isValidDate(31, 10, 2022));
	}

	@Test
	public void testIsValidDateCorrectLeapYear() {
		assertTrue(Date.isValidDate(29, 2, 2024));
	}


	@Test
	public void testIsValidDateWrongLeapYear() {
		assertFalse(Date.isValidDate(29, 02, 2022));
	}

	@Test
	public void testIsValidDate31November() {
		assertFalse(Date.isValidDate(31, 11, 2022));
	}

	@Test
	public void testIsValidDate31September() {
		assertFalse(Date.isValidDate(31, 9, 2022));
	}

	@Test
	public void testIsValidDateWrongDay() {
		assertFalse(Date.isValidDate(52, 03, 2022));
	}

	@Test
	public void testIsValidDateWrongMonthe() {
		assertFalse(Date.isValidDate(29, 15, 2022));
	}

	@Test
	public void testIsValidDateWithDayUnder0() {
		assertFalse(Date.isValidDate(-5, 02, 2022));
	}

	@Test
	public void testIsValidDateWithMonthUnder0() {
		assertFalse(Date.isValidDate(29, -5, 2022));
	}

	@Test
	public void testIsValidDateWithYearUnder0() {
		assertFalse(Date.isValidDate(29, 5, -15));
	}

	@Test
	public void testIsValidDateWith0() {
		assertFalse(Date.isValidDate(0, 0, 0));
	}

	@Test
	public void testIsValidDateWithLeapYear() {
		assertTrue(Date.isValidDate(29, 2, 2400));
	}


	@Test
	public void testIsValidDateWithNoLeapYear() {
		assertFalse(Date.isValidDate(29, 2, 2300));
	}

	@Test
	public void testIsValidDateWrongWithYearUnder0() {
		assertFalse(Date.isValidDate(29, 2, -3));
	}

	@Test
	public void testConstructorCorrect() {
		Date d=new Date(5,10,2022);

		assertEquals(d.toString(),"5/10/2022");
	}

	@Test()
	public void testConstructorWrong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date d=new Date(-1,10,2022);
		});
	}


	@Test
	public void testnextDateCorrect() {
		Date d=new Date(5, 12, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"6/12/2022");
	}

	@Test
	public void testnextDate31December() {
		Date d=new Date(31, 12, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"1/1/2023");
	}

	@Test
	public void testnextDate31October() {
		Date d=new Date(30, 10, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"31/10/2022");
	}

	@Test
	public void testnextDateLeapYear() {
		Date d=new Date(28, 2, 2024);
		d=d.nextDate();
		assertEquals(d.toString(),"29/2/2024");
	}


	@Test
	public void testnextDateNotLeapYear() {
		Date d=new Date(28, 2, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"1/3/2022");
	}

	@Test
	public void testnextDate31November() {
		Date d=new Date(30, 11, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"1/12/2022");
	}

	@Test
	public void testnextDate31September() {
		Date d=new Date(30, 9, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"1/10/2022");
	}


	@Test
	public void testnextDate31() {
		Date d=new Date(31, 10, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"1/11/2022");
	}

	@Test
	public void testnextDate28JanNotLeapYear() {
		Date d=new Date(28, 1, 2022);
		d=d.nextDate();
		System.out.println(d);
		assertEquals(d.toString(),"29/1/2022");
	}

	@Test
	public void testnextDate25FebNotLeapYear() {
		Date d=new Date(25, 2, 2022);
		d=d.nextDate();
		assertEquals(d.toString(),"26/2/2022");
	}


	@Test
	public void testpreviousDateCorrect() {
		Date d=new Date(5, 12, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"4/12/2022");
	}

	@Test
	public void testpreviousDate31December() {
		Date d=new Date(1, 1, 2023);
		d=d.previousDate();
		assertEquals(d.toString(),"31/12/2022");
	}

	@Test
	public void testPreviousDate31October() {
		Date d=new Date(31, 10, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"30/10/2022");
	}

	@Test
	public void testPreviousDateLeapYear() {
		Date d=new Date(1, 3, 2024);
		d=d.previousDate();
		assertEquals(d.toString(),"29/2/2024");
	}


	@Test
	public void testPreviousDateNotLeapYear() {
		Date d=new Date(1, 3, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"28/2/2022");
	}

	@Test
	public void testPreviousDate31November() {
		Date d=new Date(1, 12, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"30/11/2022");
	}

	@Test
	public void testPreviousDate31September() {
		Date d=new Date(1, 10, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"30/9/2022");
	}


	@Test
	public void testpreviousDate31() {
		Date d=new Date(1, 11, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"31/10/2022");
	}

	@Test
	public void testPreviousDate28JanNotLeapYear() {
		Date d=new Date(29, 1, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"28/1/2022");
	}

	@Test
	public void testPreviousDate25FebNotLeapYear() {
		Date d=new Date(26, 2, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"25/2/2022");
	}

	@Test
	public void testPreviousDate1Jan() {
		Date d=new Date(1, 1, 2022);
		d=d.previousDate();
		assertEquals(d.toString(),"31/12/2021");
	}


	@Test
	public void testCompareToDSupDOneDay() {
		Date d=new Date(25,2,2022);
		Date d2=new Date(24,2,2022);

		assertEquals(1,d.compareTo(d2));
	}

	@Test
	public void testCompareToDSupDSameDayOneMonth() {
		Date d=new Date(25,3,2022);
		Date d2=new Date(25,2,2022);

		assertEquals(1,d.compareTo(d2));
	}

	@Test
	public void testCompareToDSupDSameDaySameMonthOneYear() {
		Date d=new Date(25,2,2023);
		Date d2=new Date(25,2,2022);

		assertEquals(1,d.compareTo(d2));
	}

	@Test
	public void testCompareToEquals() {
		Date d=new Date(25,2,2022);
		Date d2=new Date(25,2,2022);

		assertEquals(0,d.compareTo(d2));
	}

	@Test
	public void testCompareToDminD() {
		Date d=new Date(23,2,2022);
		Date d2=new Date(25,2,2022);

		assertEquals(-1,d.compareTo(d2));
	}

}
