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
        
        public int getNewPriority(){
        	int result = //formula ni Genesis
        	return this.result;
        }
        
        public ArrayList<String> getActions(){
                return this.actions;
        }
        
        public ArrayList<Integer> getActionTimes(){
                return this.actionTimes;
        }
		
		//Creates a copy of this recipe.
        public void copyRecipe(Recipe r){
                r.setName(this.getName());
                r.setPriority(this.getPriority());
                r.setActions(this.getActions());
                r.setActionTimes(this.getActionTimes());
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
