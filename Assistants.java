public class Assitants{

  private ArrayList<Action> ast = new ArrayList<Action>();
  
  public Assistants(){}
  
  public void add(Action a){
    
    this.stove.add(a);
  }
  
  public void startPreparing(){
    
    //Evaluate all tasks in need of assistants
    //Prob: hindi ko talaga maisip kung pano kapag maraming assistants ><
    for(int i = 0; i < ast.size(); i++){
      
      Action a = new Action();
      a = ast.get(i);
      for(int j = 0; j < a.getTime(); j++){
        
        //Iterate until the time expires
      }
    }
  }
}
