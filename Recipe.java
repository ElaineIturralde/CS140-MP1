import java.util.*;

public class Recipe{

    private String name;
    private int priority;
    private LinkedList<Action> actions;

    public Recipe(){}

    public Recipe(String name, int priority, LinkedList<Action> actions){
        this.name = name;
        this.priority = priority;
        this.actions = actions;
    }
        
    public void setName(String name){
        this.name = name;
    }

    public void setPriority(int priority){
       this.priority = priority;
    }
	
	public void setActions(LinkedList<Action> actions){
		this.actions = new LinkedList<Action>();
		for(int ac = 0; ac < actions.size(); ac++){
			this.actions.add(actions.get(ac));
		}
	}
 
    public String getName(){
       return this.name;
    }
        
    public int getPriority(){
        return this.priority;
    }
    
	/**   
    public int getNewPriority(){
    	//int result = //formula ni Genesis
        //return result;
    }
	**/
        
    public LinkedList<Action> getActions(){
        return this.actions;
    }
 
	//Creates a copy of this recipe.
    public void copyRecipe(Recipe r){
        r.setName(this.getName());
		r.setPriority(this.getPriority());
		
		for(int ac = 0; ac < actions.size(); ac++){
			r.getActions().add(actions.get(ac));
		}
    }

    //Method to produce how the object will be printed
    public String toString(){
		return "Name: " + this.name + "\nPriority: " + this.priority;
    }
}
