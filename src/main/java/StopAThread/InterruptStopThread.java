package StopAThread;// Java program to illustrate
// stopping a thread
// using the interrupt() method

class ThreadWrapper implements Runnable {

  Thread t;

  ThreadWrapper()
  {
    t = new Thread(this);
    System.out.println("New thread: " + t);
    t.start(); // Starting the thread
  }

  // execution of thread starts from run() method
  public void run()
  {
    while (!Thread.interrupted()) {
      System.out.println("Thread is running");
    }
    System.out.println("Thread has stopped.");
  }
}

// Main class
public class InterruptStopThread {
  public static void main(String args[])
  {
    // creating objects threadWrapper of MyThread
    ThreadWrapper threadWrapper = new ThreadWrapper();

    try {
      Thread.sleep(1);

      // threadWrapper is an object of StopAThread.ThreadWrapper
      // which has an object t
      // which is of type Thread
      threadWrapper.t.interrupt();

      Thread.sleep(5);
    }
    catch (InterruptedException e) {
      System.out.println("Caught:" + e);
    }
    System.out.println("Exiting the main Thread");
  }
}
