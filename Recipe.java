import java.util.ArrayList;

public class Recipe{

    private String name;
    private int priority;
    private ArrayList<Action> actions;

    public Recipe(){}

    public Recipe(String name, int priority, ArrayList<Action> actions){
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
	
	public void setActions(ArrayList<Action> actions){
		this.actions = new ArrayList<Action>();
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
    	//Cjay, gawa ka ng isCookingStep method sa Action
    	int cooking_time = 0, noncooking_time = 0, no_of_cookingActions = 0, no_of_noncookingActions = 0;
    	
    	for(int ac = 0; ac < actions.size(); ac++){
    		if(actions.get(ac).isCookingStep){
    			no_of_cookingActions++;
    			cooking_time += actions.get(ac).getTime();
    		}
    		else{
    			no_of_noncookingActions++;
    			noncooking_time += actions.get(ac).getTime();
    		}
    	}
    	return (((50 *  (10-this.priority)) + (30 * (cooking_time / no_of_cookingActions))) + (20 * noncooking_time / no_of_noncookingActions));
	}
        
    public ArrayList<Action> getActions(){
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
