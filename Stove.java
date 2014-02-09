public class Stove{

  private ArrayList<Action> stove = new ArrayList<Action>();
  
  public Stove(){}
  
  public void add(Action a){
    this.stove.add(a);
  }
  
  public void startCooking(){
    
    //Evaluate all tasks in need of assistants
    for(int i = 0; i < stove.size(); i++){
      
      Action a = new Action();
      a = stove.get(i);
      
      if(a.getTime > 0){
        
        //If we will use RoundRobin, we can change a.getTime to the no. of s we will use and decrement the used ones.
        //1st choice
        for(int j = 0; j < a.getTime(); j++){
          //Iterate until the time expires
        }
        
        //2nd choice
        /*
        for(int j = 0; j < roundRobin_Time; j++){
          //Iterate until the time expires
          a.setTime(a.getTime()--);
          if(a.getTime() == 0){
            
            break;
          }
        }
        */
      }
    }
  }
}
