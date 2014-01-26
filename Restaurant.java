import java.io.*;

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
		
	}

}
