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
    
	/**   
    public int getNewPriority(){
    	//int result = //formula ni Genesis
        //return result;
    }
	**/
        
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
