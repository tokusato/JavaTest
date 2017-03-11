package free;

import java.io.InputStreamReader;
import java.util.concurrent.SynchronousQueue;


public class Test6 implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		InputStreamReader isr = new InputStreamReader(System.in);
//		int i = 0;
//		try {
//			while ((i = isr.read()) != -1){
//				System.out.println((char)i);
//
//			}
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

		/* スレッドの実行 */
		Thread t = new Thread(new Test6());
		System.out.println("bbb");
		t.start();

	}


	@Override
	public void run() {
		try {
			new Thread_test().addList();
			System.out.println("aaa");
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}

class Thread_test {

	SynchronousQueue<Integer> squeue = new SynchronousQueue<>();

	public synchronized void addList() throws InterruptedException{
		int i = 0;
		for (i=0 ; i<11 ; i++){
			while (i != 6){
				squeue.put(i);
				System.out.println(i);
			}
				wait();
		}
	}

	public synchronized void takeList() throws InterruptedException{
		Thread.sleep(1000, 5);

		notify();

		int i ;
		int j ;
		for (i=0 ; i<11 ; i++){
			while (i != 6){
				j = squeue.take();
				System.out.println("taking" + i);
			}
		}
	}


}


