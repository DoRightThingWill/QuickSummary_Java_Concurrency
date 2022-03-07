package Factorial;

import java.math.BigInteger;

public class Result {

  public static void main(String[] args) {

    // for number = 100, 0000
    // it takes 3201 milliseconds


    long LARGE_NUMBER = 100000;
//    runSingleThread(LARGE_NUMBER);
//    runMultiThread(LARGE_NUMBER);
    Thread singleThread = new Thread(()->runSingleThread(LARGE_NUMBER));
    Thread multiThread = new Thread(()->runMultiThread(LARGE_NUMBER));

    singleThread.start();
    multiThread.start();


  }

  public static void runSingleThread(long number ){

    long startTime = System.currentTimeMillis();

    BigInteger factorialSequential = SequentialCalculation.getFactorial(number);
    long endTime = System.currentTimeMillis();
    System.out.println("+++++++++++++++++SINGLE THREAD+++++++++++++++++++++");
//    System.out.println("final result is \n" + factorialSequential);
    System.out.println("Take time \n" + (endTime - startTime) + "ms");
  }

  public static void runMultiThread(long number){
    long startTime = System.currentTimeMillis();
    MultiThreadCalculation multiThreadCalculation = new MultiThreadCalculation(number);
    BigInteger factorialMultiThread = multiThreadCalculation.getFactorial( 8);
    long endTime = System.currentTimeMillis();
    System.out.println("+++++++++++++++++MULTI THREAD+++++++++++++++++++++");
//    System.out.println("final result is \n" + factorialMultiThread);
    System.out.println("Take time \n" + (endTime - startTime) + "ms");
  }


}
