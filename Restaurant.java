import java.io.*;
import java.util.*;

public class Restaurant{

	public static void main(String args[]){
		
		RecipeBook rb = new RecipeBook();
		LinkedList<Task> tasklist = new LinkedList<Task>();

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
					LinkedList<Action> actions = new LinkedList<Action>();
					
					// Extracts the actions needed to be done in preparing the particular recipe.
					while(br2.ready()){
						String read3 = br2.readLine();
						Action a = new Action(read.substring(0, splitString(read)), read3.substring(0, splitString(read3)), Integer.parseInt(read3.substring(splitString(read3) + 1, read3.length())));
						actions.add(a);
					}
					Recipe r = new Recipe(name, priority, actions);

                                        for(Action cur: r.getActions()){
                                                cur.setPriority(r.getNewPriority());
                                        }

					rb.addRecipe(r);
				}
			}
			
			// Execution Process
			LinkedList<Recipe> orders = new LinkedList<Recipe>();
			LinkedList<Action> cookActions = new LinkedList<Action>();
			LinkedList<Action> prepActions = new LinkedList<Action>();
                        Action currentCooking;
			PrintStream ps = new PrintStream("output.txt");
			ps.println("Time, Stove, Ready, Assistants, Remarks");
			int time = 1;
			int count = 0;
                        int stoveUtil = 0;
			Action inStove = null;
			

			while(true){
				
				Task t;
				Recipe r;
				String stove = "", ready = "", assistants = "", remarks = "", remove = "";
				
				if(tasklist.size() != 0 && time == tasklist.get(0).getStartTime()){
					t = tasklist.remove();
					r = rb.getRecipe(rb.getIndex(t.getName()));
					orders.add(r);
					remarks = remarks + r.getName() + " arrives. ";
					
					if(orders.get(count).getActions().get(0).getName().equalsIgnoreCase("prep")){
						prepActions.add(orders.get(count).getActions().remove());
					}

                                        else if (orders.get(count).getActions().get(0).getName().equalsIgnoreCase("cook")){
                                                cookActions.add(orders.get(count).getActions().remove());

                                          
                                        }       

					count++;

				}


				//Execution Preparation Process
                                for(int ac = 0; ac < prepActions.size(); ac++){
                                        Action a = prepActions.get(ac);
                                        
                                        if(a.getTime() != 0){
                                                assistants = assistants + a.getRecipe() + "(" + a.getName() + "=" +a.getTime() + ")";
                                                a.setTime(a.getTime()-1);
                                        }
                                        else{
                                                remarks = remarks + "Done preparing " + a.getRecipe() + ". ";
                                                prepActions.remove(ac);
                                                ac--;
                                                
                                                for(int bc = 0; bc < orders.size(); bc++){
                                                        if(a.getRecipe().equals(orders.get(bc).getName()) && orders.get(bc).isDone()){
                                                                orders.remove(bc);
                                                                bc--;
                                                        }
                                                        else if(a.getRecipe().equals(orders.get(bc).getName()) && !orders.get(bc).isDone()){
                                                                if(orders.get(bc).getActions().peek().getName().equalsIgnoreCase("prep"))
                                                                        prepActions.add(orders.get(bc).getActions().remove());
                                                               else{
                                                                       cookActions.add(orders.get(bc).getActions().remove());
                                                                        Action holder = cookActions.remove();
                                                                        //Sort cookActions LinkedList by Cooking Priority                                                        
                                                                        Collections.sort(cookActions, new Comparator<Action>() {
                                                                                //Override Collections.compare with one which compares cooking priority
                                                                                @Override
                                                                                public int compare(Action a1, Action a2) {
                                                                                     return a1.getPriority() - a2.getPriority();
                                                                                }
                                                                        });
                                                                        cookActions.addFirst(holder);
                                                                }
                                                        }
                                                }
                                        }
                                }

                                //Execute Cooking Process
                                if(cookActions.size() != 0){
                                       Action a = cookActions.peek();

                                        if(a.getTime() != 0){
                                                stove = stove + a.getRecipe() + "(" + a.getName() + "=" +a.getTime() + ")";
                                                a.setTime(a.getTime()-1);
                                                stoveUtil++;
                                        }
                                        else{
                                                remarks = remarks + "Done Cooking " + a.getRecipe() + ". ";
                                                cookActions.remove();

                                                //Iterate each recipe in order list?
                                                Iterator<Recipe> j = orders.iterator();
                                                while(j.hasNext()){
                                                        //If recipe is found and done then remove from list?
                                                        Recipe bc = j.next();
                                                        if(a.getRecipe().equals(bc.getName()) && bc.isDone()){
                                                                j.remove();
                                                        }
                                                        //If recipe is found but not yet done then remove the action from the Recipe's Action List then get next action
                                                       else if(a.getRecipe().equals(bc.getName()) && !bc.isDone()){
                                                                if( bc.getActions().peek().getName().equalsIgnoreCase("prep"))
                                                                        prepActions.add(bc.getActions().remove());
                                                                 else{
                                                                       cookActions.add(bc.getActions().remove());
                                                                       Action holder = cookActions.remove();
                                                                        //Sort cookActions LinkedList by Cooking Priority                                                        
                                                                        Collections.sort(cookActions, new Comparator<Action>() {
                                                                                //Override Collections.compare with one which compares cooking priority
                                                                                @Override
                                                                                public int compare(Action a1, Action a2) {
                                                                                     return a1.getPriority() - a2.getPriority();
                                                                                }
                                                                        });
                                                                        cookActions.addFirst(holder);
                                                                }
                                                        }       
                                                }
                                        }
                                }


                                //End Cooking Process
				
				if(stove.length() == 0){
					stove = "empty";
				}
				
				if(ready.length() == 0){
					ready = "none";
				}
				
				if(assistants.length() == 0){
					assistants = "none";
				}
				
				if(remarks.length() == 0){
					remarks = "none";
				}
                                System.out.println(time + ", " + stove + ", " + ready + ", " + assistants + ", " + remarks + "\n");
				ps.println(time + ", " + stove + ", " + ready + ", " + assistants + ", " + remarks);
				time++;
				
				if(tasklist.size() == 0 && orders.size() == 0 && prepActions.size() == 0){
					break;
				}
			}
			ps.println("Total Amount of Time: " + time);
			ps.println("Stove Utilization: " + stoveUtil);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
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
	
	public static boolean executing(Recipe r, LinkedList<Action> a){
		for(int ac = 0; ac < a.size(); ac++){
			if(a.get(ac).getRecipe().equals(r.getName())){
				return true;
			}
		}
		return false;
	}

}
