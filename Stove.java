public class Stove{

  private ArrayList<Action> stove = new ArrayList<Action>();
  
  public Stove(){}
  
  public void add(Action a){
    this.stove.add(a);
  }
  
  public void startCoocking(){
    
    //Evaluate all tasks in need of assistants
    for(int i = 0; i < stove.size(); i++){
      
      Action a = new Action();
      a = stove.get(i);
      for(int j = 0; j < a.getTime(); j++){
        
        //Iterate until the time expires
      }
    }
  }
}
