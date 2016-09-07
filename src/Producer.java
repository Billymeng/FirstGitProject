
public class Producer extends Thread {
	private SynchronizedBuffer sharedBuffer;
	public Producer(SynchronizedBuffer sharedBuffer)
	{
		super("producer thread");
		this.sharedBuffer = sharedBuffer;
		
	}
	public void run()// produce four num 1 2 3 4
	{
		for(int count = 1;count<=4;count++)
		{
			try{
				Thread.sleep((int)(Math.random()*2000));
				sharedBuffer.set(count);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
