import java.util.ArrayList;
import "Action.java";

public class Recipe{

        private String name;
        private int start;
        private int priority;
        private ArrayList<Action> actions;

        public Recipe(){
        }
        
        public Recipe(String name, int priority, ArrayList<Action> actions,  int start){
                this.name = name;
                this.priority = priority;
                this.actions = actions;
                this.start = start;
        }
        
        public void setName(String name){
                this.name = name;
        }
        
        public void setStart(int start){
        	this.start = start;
        }
        
        public void setPriority(int priority){
            this.priority = priority;
        }
        
        public void setActions(ArrayList<Action> actions){
            for(int i = 0; i < actions.size(); i++){
                actions.get(i).setRecipe(this.name);
            }
            this.actions = actions;
        }
        
        
        public String getName(){
                return this.name;
        }
        
        public int getStart(){
        	return this.start;
        }
        
        public int getPriority(){
                return this.priority;
        }
        
        public int getNewPriority(){
        	int result = //formula ni Genesis
        	return this.result;
        }
        
        public ArrayList<Action> getActions(){
                return this.actions;
        }
        
		
		//Creates a copy of this recipe.
        public void copyRecipe(Recipe r){
                r.setName(this.getName());
                r.setPriority(this.getPriority());
                r.setActions(this.getActions());
                r.setActionTimes(this.getActionTimes());
                r.setStart(this.start);
        }

        //Method to produce how the object will be printed
        public String toString(){
            
			String ret = "Name: " + this.name + "\nPriority: " + this.priority + "\nActions and ActionTimes:";

            for(int i = 0; i < actions.size(); i++){
				ret += "\n" + actions.get(i) + " - " + actionTimes.get(i);
			} 
			return ret;
        }
}
