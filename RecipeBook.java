import java.util.ArrayList;

public class RecipeBook{

	private ArrayList<Recipe> recipe_book;
	
	public RecipeBook(){
		recipe_book = new ArrayList<Recipe>();
	}
	
	public ArrayList<Recipe> getRecipeBook(){
		return this.recipe_book;
	}
	
	public void addRecipe(Recipe r){
		this.getRecipeBook().add(r);
	}

	public boolean searchRecipe(String name){
		for(int ac = 0; ac < this.getRecipeBook().size(); ac++){
			if(this.getRecipeBook().get(ac).getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
}
