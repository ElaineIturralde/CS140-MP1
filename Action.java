public class Action{
	
	private String recipe;
	private String name;
	private int time;
	private boolean isDone = false;
	private boolean isCookingStep;
	private boolean isExecuting = false;
	private int priority;

	public Action(String recipe, String name, int time){
		this.recipe = recipe;
		this.name = name;
		this.time = time;
		isCookingStep = (name.toLowerCase().compareTo("cook") == 0);
	}
	
	public void execute(){
		this.isExecuting = true;
	}
	
	public void setTime(int time){
		this.time = time;
	}

	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public void setIsDone(){
		this.isDone = true;
	}
	
	public String getRecipe(){
		return this.recipe;
	}

	public String getName(){
		return this.name;
	}
	
	public boolean getIsCookingStep(){
		return this.isCookingStep;
	}

	public int getTime(){
		return this.time;
	}

	public int getPriority(){
		return this.priority;
	}
	
	public boolean getIsExecuting(){
		return this.isExecuting;
	}

	public boolean isDone(){
		return isDone;
	}

	public String toString(){
		return "Recipe: " + this.recipe + "Action: " + this.name + " Time: " + this.time + " isDone: " + this.isDone;
	}

}
