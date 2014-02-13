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
                       
                        // Prints the tasks in the tasklist.
                        /**
                        for(int ac = 0; ac < tasklist.size(); ac++){
                                Task t = tasklist.get(ac);
                                System.out.println(t.getName() + " " + t.getStartTime());
                        }
                        **/
                       
                        // Execution Process
                        LinkedList<Recipe> orders = new LinkedList<Recipe>();
                        LinkedList<Action> cookActions = new LinkedList<Action>();
                        LinkedList<Action> prepActions = new LinkedList<Action>();
                        PrintStream ps = new PrintStream("output.txt");
                        int time = 1;
                        int time_of_highest_priority = -1, index_of_highest_priority = -1, highest_priority = 0;
						String recipe_of_highest_priority = "", tentrecipe = "";
						int z = 0;
                       
                        while(true){
                               
                                Task t;
                                Recipe r;
                                System.out.println ("Time " + time);
                                if(tasklist.size() != 0 && time == tasklist.get(0).getStartTime()){
                                        t = tasklist.remove();
                                        r = rb.getRecipe(rb.getIndex(t.getName()));
                                        orders.add(r);
                                }
                               
                                for(int ac = 0; ac < orders.size(); ac++){
                                        if(!orders.get(ac).getActions().isEmpty()){
                                        	Action a = orders.get(ac).getActions().get(0);
                                        	if(a.getName().equalsIgnoreCase("prep") && !a.getIsExecuting()){
                                                a.execute();
                                                prepActions.add(a);
                                        	}
                                        }
                                }
                               
                                for(int ac = 0; ac < prepActions.size(); ac++){
                                        System.out.println(prepActions.get(ac).getRecipe() + " " + prepActions.get(ac).getTime() + " " + time);
                                }
                                
                                if(time_of_highest_priority < 1 && !orders.isEmpty()){
                                	highest_priority = 0;
                                	
                                	/*//checking
                                	for(int ac = 0; ac < orders.size(); ac++){
                                		System.out.println ("order " + orders.get(ac).getName());
                                	}*/
                                	
                                	cookActions = new LinkedList<Action>();
                                	for(int ac = 0; ac < orders.size(); ac++){
                                		if(!orders.get(ac).getActions().isEmpty() && orders.get(ac).getActions().get(0).getName().equalsIgnoreCase("cook")){
                                			cookActions.add(orders.get(ac).getActions().get(0));
                                		}
                                	}
                                	if(!cookActions.isEmpty()){
                                		boolean contains = false;
                                		for(int ac = 0; ac < orders.size(); ac++){
                                			for(int bc = 0; bc < cookActions.size(); bc++){
                                				if(orders.get(ac).getNewPriority() > highest_priority && orders.get(ac).getName().equals(cookActions.get(bc).getRecipe())){
                                					highest_priority = orders.get(ac).getNewPriority();
                                					recipe_of_highest_priority = orders.get(ac).getName();
                                					time_of_highest_priority = orders.get(ac).getActions().get(0).getTime();
                                					index_of_highest_priority = ac;
                                					contains = true;
                                				}
                                			}
                                		}
                                		if(contains){
                                			orders.get(index_of_highest_priority).getActions().remove(0);
                                			System.out.println ("cooking: " + recipe_of_highest_priority + " " + highest_priority + " " + time_of_highest_priority);
                                		}
                                	}
                                }
                                else{
                                	System.out.println ("cooking: " + recipe_of_highest_priority + " " + highest_priority + " " + time_of_highest_priority);
                                }
                                time_of_highest_priority--;
                               
                                //Execution Preparation Process
                                for(int ac = 0; ac < prepActions.size(); ac++){
                                       
                                        Action a = prepActions.get(ac);
                                        a.setTime(a.getTime() - 1);
                                       
                                        if(a.getTime() == 0){
                                                a.setIsDone();
                                                prepActions.remove(ac);
                                                ac--;
                                                for(int bc = 0; bc < orders.size(); bc++){
                                                       
                                                        if(a.getName().equals(orders.get(bc).getName())){
                                                                orders.get(bc).getActions().remove();
                                                        }
                                                       
                                                        if(orders.get(bc).getActions().size() == 0){
                                                                orders.remove();
                                                        }
                                                }
                                        }
                                }
                               
                                //Execution of Cooking Process
                               
                               
                                time++;
                               
                                if(tasklist.size() == 0 && prepActions.size() == 0 && cookActions.size() == 0){
                                        break;
                                }
                                z++;
                               
                        }
                       
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
 
}
