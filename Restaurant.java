import java.io.*;
import java.util.regex;

public class Restaurant{

	public static void main(String args[]){
		
		RecipeBook rb = new RecipeBook();

		
		try{
			BufferedReader br = new BufferedReader(new FileReader("tasklist.txt"));
			
			while(br.ready()){
				System.out.println(br.readLine());
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}

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
	}

}
