
public class TestSynchronized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("show:");
		
		//生产消费所共用的数据存储空间
		SynchronizedBuffer sharedBuffer = new SynchronizedBuffer();
		Producer producer = new Producer(sharedBuffer);
		Consumer consumer = new Consumer(sharedBuffer);
		
		producer.start();
		consumer.start();

	}

}
