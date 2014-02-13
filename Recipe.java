import java.util.*;

public class Recipe{

    private String name;
    private int priority;
    private LinkedList<Action> actions;
	private boolean isExecuting = false;
	private int cookPriority; //Computed priority

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

    	return ( (10-this.priority * 5 ) + (averageTimes[1] * 3) + averageTimes[0] * 2);

    }

    //Returns the computed average preparation time and average time
    public int[] getAveTime(){

    	int[] ret = new int[2];
        int cookNum = 0;
    	//Iterate each element of actions as cur <foreach loop for actions>
    	for(Action cur: this.actions){

            //Get the total time for each cook and prep ACTION
    		if(cur.getName().equalsIgnoreCase("cook")){
    			ret[1]+=cur.getTime() * 100; //Multiplied by 100 to increase precision
                cookNum++;
            }
			else    		
				ret[0]+=cur.getTime() * 100; //Multiplied by 100 to increase precision
    	}

        ret[1] /= cookNum;
        ret[0] /= this.actions.size() - cookNum;

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
