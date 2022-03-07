package ThreadSafety;

public class SolutionOneSynchronizedBlock {

  public static void main(String[] args) {
    BankAccount myAccount = new BankAccount(100, 123);
    Withdraw willWithdraw = new Withdraw(myAccount, 50);
    Withdraw marthaWithdraw = new Withdraw(myAccount, 100);

    willWithdraw.setName("Will");
    marthaWithdraw.setName("Martha");

    willWithdraw.start();
    marthaWithdraw.start();

  }


  static class BankAccount {
    public double balance;
    public long accountID;

    public BankAccount(double balance, long accountID) {
      this.balance = balance;
      this.accountID = accountID;
    }
  }


  static class Withdraw extends Thread{
    private BankAccount myAccount;
    private double withdrawAmount;
    private double amountInYourPocket;

    public Withdraw(BankAccount bankAccount, double withdrawAmount){
      this.myAccount = bankAccount;
      this.withdrawAmount = withdrawAmount;
      this.amountInYourPocket = 0;
    }

    @Override
    public  void run(){

      synchronized(myAccount){
        if(myAccount.balance < withdrawAmount){
          System.out.println(this.getName() + ": \n \tnot enough balance");
          return;
        }

//        try {
//          Thread.sleep(1000);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }

        myAccount.balance -= withdrawAmount;
        amountInYourPocket += withdrawAmount;

        System.out.printf("%s :\n \tWithdraw amount: %.2f\n \tAccount Balance: %.2f\n \tMoney in hand: %.2f\n",
            this.getName(),
            withdrawAmount,
            myAccount.balance,
            amountInYourPocket);
      }

    }

  }

}
