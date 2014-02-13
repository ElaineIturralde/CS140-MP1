import java.util.*;

public class Recipe{

    private String name;
    private int priority;
    private LinkedList<Action> actions;
	private boolean isExecuting = false;
	private int cookPriority;

    public Recipe(){}

    public Recipe(String name, int priority, LinkedList<Action> actions){
        this.name = name;
        this.priority = priority;
        this.actions = actions;
        this.cookPriority = computeCookPriority();
    }

    //Computes the cook priority based on actual priority, average preparation time and average cooking time
    public int computeCookPriority(){

    	int[] averageTimes = getAveTime();

    	return ( (10-this.priority * 50 ) + (averageTimes[1] * 30) + averageTimes[0] * 20);

    }

    //Returns the computed average preparation time and average time
    public int[] getAveTime(){

    	int[] ret = new int[2];
    	//Iterate each element of actions as cur <foreach loop for actions>
    	for(Action cur: this.actions){

    		if(cur.getName().equalsIgnoreCase("cook"))
    			ret[1]+=cur.getTime();
			else    		
				ret[0]+=cur.getTime();
    	}

    	return ret;

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
    

    public int getNewPriority(){
    	return this.cookPriority;
    }

	
	public boolean isExecuting(){
		return this.isExecuting;
	}
	
	public void execute(){
		this.isExecuting = true;
	}
	
	public void stopExecute(){
		this.isExecuting = false;
	}
	
	public boolean isDone(){
		return this.actions.size() == 0;
	}
        
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
