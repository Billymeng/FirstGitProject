
public class Consumer extends Thread {
	private SynchronizedBuffer sharedBuffer;
	public Consumer(SynchronizedBuffer sharedBuffer)
	{
		super("consumer thread");
		this.sharedBuffer = sharedBuffer;
		
	}
	public void run()// produce four num 1 2 3 4
	{
		int sum = 0;
		for(int count = 1;count<=4;count++)
		{
			try{
				Thread.sleep((int)(Math.random()*2000));
				sum +=sharedBuffer.get();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(getName()+"consum sum is "+sum);
	}

}
