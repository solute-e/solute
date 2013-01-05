package jdk.java.lang;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class SynchronizedTest {
	private Map<String, String> map = new HashMap<String, String>();
	private Semaphore semaphore = new Semaphore(1);
	
	private Runnable runnable = new Runnable() {
		public void run() {
			try {
				if (!map.containsKey("abc")) {
					System.out.println("enter");
					semaphore.acquire();
					if(!map.containsKey("abc")) {
						System.out.println("setting map put str");
						while(true);
						// semaphore.release();
	//					writeLock.unlock();
	//					writeLock.notify();
					}
				}
				System.out.println("setting map get");
				String str = map.get("abc");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	};

	@Test
	public void testSynchronized() throws InterruptedException {
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		
		thread1.start();
		Thread.sleep(100);
		thread2.start();
		thread1.join();
		thread2.join();
	}
}
