package com.aura.qa.factorial;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aura.qa.Factorial;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
* Factorial tests.
*
* @author Juan Carlos Ballesteros Hermida - QALovers
*/

public class FactorialTest extends TestCase {
	
	private static final Logger log = LoggerFactory.getLogger(FactorialTest.class);
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public FactorialTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(FactorialTest.class);
	}

	
	public void testFactorialZero() {
		log.info("testFactorialZero");
		BigInteger calculateFactorial = Factorial.calculateFactorial(BigInteger.ZERO);
		assertTrue("Check if factorial of 0 is 1", calculateFactorial.toString().equals("1"));
	}
	
	public void testFactorialNegative() {
		log.info("testFactorialNegative");
		BigInteger calculateFactorial = Factorial.calculateFactorial(new BigInteger("-1"));
		assertTrue("Check if factorial of a negative integer is null", calculateFactorial==null);
	}
	
	public void testFactorial5() {
		log.info("testFactorial5");
		BigInteger calculateFactorial = Factorial.calculateFactorial(new BigInteger("5"));
		log.info("\t"+calculateFactorial.toString());
		assertTrue("Check if factorial of 5 is 120", calculateFactorial.toString().equals("120"));
	}
	
	public void testFactorialBig() {
		log.info("testFactorial5");
		BigInteger calculateFactorial = Factorial.calculateFactorial(new BigInteger("999999999"));
		log.info("\tIs null: "+(calculateFactorial==null));
		assertTrue("Check if factorial of a big number is null", calculateFactorial==null);
	}
	
	
	//
}
