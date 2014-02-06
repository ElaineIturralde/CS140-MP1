public class Task{

	private String name;
	private int start_time;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setStartTime(int start_time){
		this.start_time = start_time;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getStartTime(){
		return this.start_time;
	}
	
	public String toString(){
		return this.name + " " +  this.start_time;
	}

}