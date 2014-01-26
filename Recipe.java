import java.util.ArrayList;

public class Recipe{

	private String name;
	private int priority;
	private ArrayList<String> actions;
	private ArrayList<Integer> actionTimes;
	
	public Recipe(){
	}
	
	public Recipe(String name, int priority, ArrayList<String> actions, ArrayList<Integer> actionTimes){
		this.name = name;
		this.priority = priority;
		this.actions = actions;
		this.actionTimes = actionTimes;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public void setActions(ArrayList<String> actions){
		this.actions = actions;
	}
	
	public void setActionTimes(ArrayList<Integer> actionTimes){
		this.actionTimes = actionTimes;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public ArrayList<String> getActions(){
		return this.actions;
	}
	
	public ArrayList<Integer> getActionTimes(){
		return this.actionTimes;
	}

	public void copyRecipe(Recipe r){
		r.setName(this.getName());
		r.setPriority(this.getPriority());
		r.setActions(this.getActions());
		r.setActionTimes(this.getActionTimes());
	}
}
