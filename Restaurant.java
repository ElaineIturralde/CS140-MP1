import java.io.*;
import java.util.regex;

public class Restaurant{

	public static void main(String args[]){
		
		RecipeBook rb = new RecipeBook();
		ArrayList<Action> cookActions;
		ArrayList<Action> prepActions;


    	Collections.sort(cookActions, new Comparator<Action>() {
        	@Override
	        public int compare(Recipe  recipe1, Recipe  recipe2)
	        {

	            return  recipe1.getName().compareTo(recipe2.getName());
	        }
    	});
	

		
		try{
			BufferedReader br = new BufferedReader(new FileReader("tasklist.txt"));
			RestaurantMethods rm = new RestaurantMethods();
			
			while(br.ready()){
				String [] recipe = br.readLine().split(" ");
				String temp = recipe[0] + ".txt";
				if(temp.exists()){
					Recipe food = rm.addRecipeFromFile(temp, Integer.parseInt(recipe[1]));
					System.out.println(food.toString());
					System.out.println(br.readLine());
				}
				else{
					System.out.println ("One recipe does not exist.");
					break;
				}
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
/*
		//Restaurant Methods Test
		RestaurantMethods rm = new RestaurantMethods();
		
		//folder name = MP140
		File folder = new File("MP140");
		String [] listFiles = folder.list();
		
		int x = 0;
		while(listFiles.length > x){
			String [] extension = listFiles[x].split(".");
			if(!listFiles[x].equals("tasklist.txt") && extension[1].equals(".txt")){
				Recipe food = rm.addRecipeFromFile(listFiles[x]);
				System.out.println(food.toString());
			}
			x++;
		}
*/
	}

}
