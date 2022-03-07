package Factorial;

import java.math.BigInteger;

public class SequentialCalculation {

  private static BigInteger result = BigInteger.ONE;


  public static BigInteger getFactorial(long number){
    for(long i=1; i <= number ; i++){
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }
}
