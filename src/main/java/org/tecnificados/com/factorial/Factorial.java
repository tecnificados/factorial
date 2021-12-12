package org.tecnificados.com.factorial;

import java.math.BigInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* Factorial used to generate a factorial of an integer.
*
* @author Juan Carlos Ballesteros Hermida - Tecnificados
*/
public class Factorial {
	
	private static final Logger log = LoggerFactory.getLogger(Factorial.class);

	public static void main(String[] args) {
		BigInteger numberToGenerateFactorial;
		BigInteger factorial;

		if (args.length != 1) {
			log.error("We need only one argument to generate the factorial. Example: 6");
			return;
		}

		try {
			numberToGenerateFactorial = new BigInteger(args[0]);
		} catch (Exception e) {
			log.error("We need a integer greater than 0 to generate the factorial.");
			return;
		}

		if (numberToGenerateFactorial.signum()<0) {
			log.error("We need a positive integer to generate the factorial.");
			return;
		}		
		factorial = calculateFactorial(new BigInteger(numberToGenerateFactorial + ""));
		if (factorial!=null)
		{
			log.info("The factorial of "+numberToGenerateFactorial+" is: "+factorial.toString());
		}
	}

	public static BigInteger calculateFactorial(BigInteger integerF) {

		try
		{
			//int a=23/0;
			if (integerF==null)
				return integerF;
			else if (integerF.equals(BigInteger.ZERO))
				return BigInteger.ONE;
			else if (integerF.signum()<0)
				return null;
			else
			{
				BigInteger calc = calculateFactorial(integerF.subtract(BigInteger.ONE));
				if (calc==null)
				{
					return null;
				}
				return integerF.multiply(calc);
			}
		}
		catch(StackOverflowError | Exception exc){
            log.error("The number is too big. Error at "+integerF.toString());
            return null;
        }		
	}
}
