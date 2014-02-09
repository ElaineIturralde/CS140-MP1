import java.io.*;
import java.util.*;

public class Restaurant{

	public static void main(String args[]){
		
		RecipeBook rb = new RecipeBook();
		ArrayList<Task> tasklist = new ArrayList<Task>();

		try{
			
			// Reads the tasklist.txt.
			BufferedReader br = new BufferedReader(new FileReader("tasklist.txt"));
			
			while(br.ready()){
				
				// Extracts the recipes from the tasklist.txt that are to be cooked.
				String read = br.readLine();
				
				Task t = new Task();
				t.setName(read.substring(0, splitString(read)));
				t.setStartTime(Integer.parseInt(read.substring(splitString(read) + 1, read.length())));
				tasklist.add(t);
				
				if(rb.getSize() == 0 || !(rb.searchRecipe(t.getName()))){
					
					// Reads the recipe.txt.
					BufferedReader br2 = new BufferedReader(new FileReader(t.getName() + ".txt"));
					
					// Extracts the name and priority of the recipe.
					String read2 = br2.readLine();
					String name = read2.substring(0, splitString(read2));
					int priority = Integer.parseInt(read2.substring(splitString(read2) + 1, read2.length()));
					ArrayList<Action> actions = new ArrayList<Action>();
					
					// Extracts the actions needed to be done in preparing the particular recipe.
					while(br2.ready()){
						String read3 = br2.readLine();
						Action a = new Action(read3.substring(0, splitString(read3)), Integer.parseInt(read3.substring(splitString(read3) + 1, read3.length())));
						actions.add(a);
					}
					Recipe r = new Recipe(name, priority, actions);
					rb.addRecipe(r);
				}
			}
			// Just prints the recipes in the recipe book.
			/**
			for(int ac = 0; ac < rb.getSize(); ac++){
				Recipe r = rb.getRecipe(ac);
				System.out.println(r.getName() + " " +  r.getPriority());
				ArrayList<Action> a = r.getActions();
				for(int bc = 0; bc < a.size(); bc++){
					System.out.println(a.get(bc).getName() + " " + a.get(bc).getTime());
				}
			}
			**/
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		//I made 2 Kinds of Evaluate methods. Pacheck na lang
		evaluate(tasklist, rb);
	}
	
	//Evaluates each task if the food is to be cooked in the stove or to be handled by the assistants
	//Evaluate 1
	public static void evaluate(ArrayList<Task> tasklist, RecipeBook rb){
		
		ArrayList<Action> cookActions = new ArrayList<Action>();
		ArrayList<Action> prepActions = new ArrayList<Action>();
		
		int total_time = 0;
		//Iterate to traverse all the tasks in the tasklist
		for(int i = 0; i < tasklist.size(); i++){
			
			Recipe r = new Recipe();
			total_time += tasklist.get(i).getStartTime();
			
			//Finds the recipe to be evaluated
			for(int j = 0; j < rb.size(); j++){
			
				r = rb.get(j);
				if(r.getName().equals(tasklist.getName())){
					break;	
				}
				j++;
			}
			
			//Breaks down the recipe - stove and assistants
			for(int j = 0; j < r.getActions().size(); j++){
				
				Action a = new Action();
				a = r.getActions().get(j);
				if(a.isCookingStep){
					
					cookActions.add(a);
				}
				else{
					
					prepActions.add(a);
				}
			}
		}
		
		for(int i = 0; i < total_time; i++){
			
			//Handles time of cooking and preparing. 
			//But, since all cooking actions and preparing actions are together, 
			//there should be some way to know which recipe is the action for
		}
	}
	
	//Evaluates each task if the food is to be cooked in the stove or to be handled by the assistants
	//Evaluate2
	public static void evaluate(ArrayList<Task> tasklist, RecipeBook rb){
		
		Stove st = new Stove();
		Assistants ast = new Assistants();
		
		//Iterate to traverse all the tasks in the tasklist
		for(int i = 0; i < tasklist.size(); i++){
			
			Recipe r = new Recipe();
			int j = 0;
			
			//Finds the recipe to be evaluated
			while(j < rb.size()){
			
				r = rb.get(j);
				if(r.getName().equals(tasklist.getName())){
					break;	
				}
				j++;
			}
			
			//Breaks down the recipe - stove and assistants
			for(j = 0; j < r.getActions().size(); j++){
				
				Action a = new Action();
				a = r.getActions().get(j);
				if(a.isCookingStep){
					
					st.add(a);
				}
				else{
					
					ast.add(a);
				}
			}
		}
	}
	
	// Created own splitString function. Basically it, it returns the position of the character before the occurence of the first digit.
	// That position serves as the place where the string would be splitted.
	public static int splitString(String s){
		
		for(int ac = 0; ac < s.length(); ac++){
			if(Character.isDigit(s.charAt(ac))) return ac - 1;
		}
		return -1;
	}

}
