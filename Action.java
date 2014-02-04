public class Action{
	
	private String name;
	private int time;
	private boolean isDone = false;
	private boolean isCookingStep;
	private String recipe;

	public Action(String name, int time){
		this.name = name;
		this.time = time;
		isCookingStep = (name.toLowerCase.compareTo("cook") == 0);
	}

	public void switchDone(){
		this.isDone = !(this.isDone);
	}

	public void switchDone(boolean isDone){
		this.isDone = isDone;
	}

	public String getName(){
		return this.name;
	}

	public int getTime(){
		return this.time;
	}

	public boolean isDone(){
		return isDone;
	}

	public void setRecipe(String name){
		this.recipe = name;
	}

	public String toString(){
		return "Action: " + this.name + " Time: " + this.time + " isDone: " + this.isDone;
	}

}