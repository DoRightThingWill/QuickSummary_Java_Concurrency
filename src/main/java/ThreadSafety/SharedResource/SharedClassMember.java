package ThreadSafety.SharedResource;

public class SharedClassMember {

  public static void main(String[] args) {
    LocalVariableRunnable localVariableRunnable = new LocalVariableRunnable();

    Thread threadOne = new Thread(localVariableRunnable);
    Thread threadTwo = new Thread(localVariableRunnable);

    threadOne.setName("ThreadOne");
    threadTwo.setName("ThreadTwo");

    threadOne.start();
    threadTwo.start();


    System.out.println("Main thread is terminated");

  }


  private static class LocalVariableRunnable extends ParentClass implements Runnable {


    @Override
    public void run(){
      for (int starter = 1; starter <= 5; starter++) {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.printf("%s is printing %d\n", Thread.currentThread().getName(), starter);
      }
    }


//    @Override
//    public void run(){
//      for (starter = 1; starter <= 5; starter++) {
//        try {
//          Thread.sleep(500);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        System.out.printf("%s is printing %d\n", Thread.currentThread().getName(), starter);
//      }
//    }

  }

}
