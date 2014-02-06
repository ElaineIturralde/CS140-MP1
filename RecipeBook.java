import java.util.ArrayList;

public class RecipeBook{

	private ArrayList<Recipe> recipe_book;
	private int size;
	
	public RecipeBook(){
		this.recipe_book = new ArrayList<Recipe>();
		this.size = 0;
	}
	
	public ArrayList<Recipe> getRecipeBook(){
		return this.recipe_book;
	}
	
	public void addRecipe(Recipe r){
		this.getRecipeBook().add(r);
		this.size++;
	}
	
	public Recipe getRecipe(int i){
		if(i < 0 || i > this.recipe_book.size()){
			System.out.println("Recipe does not exist.");
			return null;
		}
		else
			return recipe_book.get(i);
	}
	
	public int getSize(){
		return this.size;
	}
	
	public int getIndex(String name){
		for(int ac = 0; ac < this.getRecipeBook().size(); ac++){
			if(this.getRecipeBook().get(ac).getName().equals(name))
				return ac;
		}
		return -1;	
	}	
	
	public boolean searchRecipe(String name){
		for(int ac = 0; ac < this.getRecipeBook().size(); ac++){
			if(this.getRecipeBook().get(ac).getName().equals(name))
				return true;
		}
		return false;
	}
	
}
