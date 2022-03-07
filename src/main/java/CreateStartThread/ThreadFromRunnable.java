package CreateStartThread;

public class ThreadFromRunnable {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread( ()->
        System.out.println("we are running thread: -- "+ Thread.currentThread().getName()));

    Runnable myRunnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("this is a runnable");
      }
    };

    Thread threadFromRunnable = new Thread(myRunnable);

    threadFromRunnable.setName("threadFromRunnable");
    threadFromRunnable.start();

    thread.setName("thread-111");
    thread.setPriority(Thread.MAX_PRIORITY);
    System.out.println("we are running thread: -- "+ Thread.currentThread().getName());

    thread.start();
    System.out.println("we are running thread: -- "+ Thread.currentThread().getName());

    Thread.sleep(1000);
  }
}
