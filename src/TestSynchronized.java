
public class TestSynchronized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("show:");
		
		//�������������õ����ݴ洢�ռ�
		SynchronizedBuffer sharedBuffer = new SynchronizedBuffer();
		Producer producer = new Producer(sharedBuffer);
		Consumer consumer = new Consumer(sharedBuffer);
		
		producer.start();
		consumer.start();

	}

}
