package org.janardhan.thread;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author jd Java program to demonstrate How to use CountDownLatch in Java.
 *         CountDownLatch is useful if you want to start main processing thread
 *         once its dependency is completed as illustrated in this
 *         CountDownLatch Example. CountDownLatch cannot be reset. Exhasuted
 *
 **/
public class CountDownLatchExample {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(3);

		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

		cacheService.start(); // separate thread will initialize CacheService
		alertService.start(); // another thread for AlertService initialization
		validationService.start();

		// application should not start processing any thread until all service
		// is up
		// and ready to do there job.
		// Countdown latch is idle choice here, main thread will start with
		// count 3
		// and wait until count reaches zero. each thread once up and read will
		// do
		// a count down. this will ensure that main thread is not started
		// processing
		// until all services is up.

		// count is 3 since we have 3 Threads (Services)

		try {
			latch.await(); // main thread is waiting on CountDownLatch to finish
			System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}

class Service implements Runnable {

	private final String threadName;
	private final int timeToStart;
	private final CountDownLatch latch;

	public Service(String threadName, int timeToStart, CountDownLatch latch) {
		this.threadName = threadName;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, e);
		}

		System.out.println(threadName + " is up. ");
		latch.countDown();// reduce count of CountDownLatch by 1
	}

}
