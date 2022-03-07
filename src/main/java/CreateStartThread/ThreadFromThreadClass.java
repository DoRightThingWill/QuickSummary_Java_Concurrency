package CreateStartThread;

import java.security.Principal;

public class ThreadFromThreadClass {

  public static void main(String[] args) {

    MyThread myThread = new MyThread();
    myThread.setName("Will Thread");
    myThread.start();

  }


  private static class MyThread extends Thread{
    @Override
    public void run(){
      System.out.println("running thread-->" + Thread.currentThread().getName());
    }
  }

}
