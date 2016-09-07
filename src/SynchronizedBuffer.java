
public class SynchronizedBuffer {
	
	private int buffer = -1;
	// define the buffer content(int)
	
	private boolean occupiedBuffer = false;
	//flag to show if occupied
	
	public synchronized void set(int value)//set the buffer
	{
		String name = Thread.currentThread().getName();
		
		while(occupiedBuffer)
		{
			try
			{
				System.err.println(name +"to produce ,failed");
				wait();// producer waiting
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		buffer = value;
		System.out.println(name + "produced a name "+buffer);
		occupiedBuffer =true;
		notify();
		
	}
	
	public synchronized int get()//to consume a buffer 
	{
		String name = Thread.currentThread().getName();
		while(!occupiedBuffer)
		{
			try
			{
				System.err.println(name+"to consume failed! ");
				wait();
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				
			}
		}
		occupiedBuffer = false;
		System.out.println(name + "consume a int! ");
		notify();
		return buffer;
		
	}
	

}
