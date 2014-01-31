public class Food extends Thread{

  //layout for thread
  
  Preparation p = new Preparation();
  
  public Food(Preparation p){
    this.p = p;
  }
  
  public void run(){
    //hindi ko lam lalagay for iteration :))
    while(){
      try{
        Thread.sleep(500);
      }
      catch (InterruptedException e) {}
    }
  }
}
