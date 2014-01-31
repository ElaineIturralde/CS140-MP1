public class Preparation{
	
	//tentative layout for preparation
	
	int count = 0;
	
	public void prepareForStove(){
		synchronized(this){
			notify();
			count++;
		}
	}
	
	public void cookInStove(){
		synchronized(this){
			if(count > 0){
				try{ 
					System.out.println ("Waiting for other food to be prepared");
					this.wait();
				}
				catch (InterruptedException e) {}
				System.out.println ("Can cook in stove!");
			}
			count = 0;
		}
	}

}
