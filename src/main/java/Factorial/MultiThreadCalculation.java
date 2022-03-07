package Factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadCalculation {

  private static BigInteger result = BigInteger.ONE;
  private static List<CalculateFacThread> threadList = new ArrayList<>();
  private long END_NUMBER;

  public MultiThreadCalculation(long END) {
    this.END_NUMBER = END;
  }

  public BigInteger getFactorial(Integer numberOfThreads) {

    if (numberOfThreads.equals(null)) {
      numberOfThreads = 8;
    }


    long increment = END_NUMBER >> 3;
    long starter = 1;

    for (int j = 1; j <= numberOfThreads; j++) {
      var end = Math.min(END_NUMBER, starter + increment);
//      System.out.printf("(start, end) -->(%d, %d) \n", starter, end);
      threadList.add(new CalculateFacThread(starter,  end));
      starter += (increment + 1);
    }

    List<BigInteger> temResult = new ArrayList<>();
    for(CalculateFacThread thread: threadList){
      thread.start();
    }

    for(CalculateFacThread thread: threadList){
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      temResult.add(thread.getResult());
    }

    for(BigInteger partialResult : temResult){
      result = result.multiply(partialResult);
    }
    return result;
  }


  private class CalculateFacThread extends Thread {
    private BigInteger factorial;
    private long start;
    private long end;
    private boolean isDone;

    public CalculateFacThread(long start, long end) {
      this.factorial = BigInteger.ONE;
      this.start = start;
      this.end = end;
      this.isDone = false;
    }

    @Override
    public void run() {
      System.out.printf("Thread %s: is calculating (%d --> %d)\n", this.getName(), start, end);
      for (long i = start; i <= end; i++) {
//        System.out.println(factorial);
        factorial = factorial.multiply(BigInteger.valueOf(i));
      }
      isDone = true;
    }

    public BigInteger getResult() {
      return this.factorial;
    }

  }

}
