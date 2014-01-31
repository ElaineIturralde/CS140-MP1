public class Preparation{
	
	int count = 0;
	
	public void cookInStove(){
		synchronized(this){
			notify();
			count++;
		}
	}
	
	public void prepareForStove(){
		synchronized(this){
			if(count > 0){
				try{ 
					System.out.println ("Waiting for the food to cook in the stove :D");
					this.wait();
				}
				catch (InterruptedException e) {}
				System.out.println ("Preparations are complete!");
			}
		}
	}

}
