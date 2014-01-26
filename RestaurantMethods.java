import java.io.*;
import java.util.ArrayList;

public class RestaurantMethods{
	
	/*
		This method creates a Recipe object from the data on a file
		Relies in the Recipe class
		Returns a Recipe Object
	*/
	public Recipe addRecipeFromFile(String file){

		//Variable Initialization
		String name = "";
		int priority = 0;
		String[] line = new String[2];
		ArrayList<String> action = new ArrayList<String>();
		ArrayList<Integer> actionTime = new ArrayList<Integer>();	

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));

		


			line = br.readLine().split(" ");
			name = line[0];
			priority = Integer.parseInt(line[1]);

			while(br.ready()){
				line = br.readLine().split(" ");
				action.add(line[0]);
				actionTime.add(Integer.parseInt(line[1]));
			}


			

		} catch(FileNotFoundException e){
			System.out.println("File " + file + " not found!");
			System.exit(1);
		} catch(IOException e){
			System.exit(1);
		}

		Recipe ret = new Recipe(name,priority,action,actionTime);

		return ret;

	}

}