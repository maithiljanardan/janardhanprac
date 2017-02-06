package org.janardhan.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author jd
 *
 */
public class CyclicBarrierExample {

	public static void main(String[] args) {

		// creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call
		// await()
		final CyclicBarrier cBarrier = new CyclicBarrier(3, new BarrierAction());

		Thread thread1 = new Thread(new Task(cBarrier), "Thread 1");
		Thread thread2 = new Thread(new Task(cBarrier), "Thread 2");
		Thread thread3 = new Thread(new Task(cBarrier), "Thread 3");

		thread1.start();
		thread2.start();
		thread3.start();

	}
}

class BarrierAction implements Runnable {

	@Override
	public void run() {
		// This task will be executed once all thread reaches barrier
		System.out.println("All parties are arrived at barrier, lets play");

	}

}

class Task implements Runnable {

	private CyclicBarrier barrier;

	public Task(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
		}
		catch (InterruptedException ex) {
			Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (BrokenBarrierException ex) {
			Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
