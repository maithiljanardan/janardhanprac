package org.janardhan.thread;

public class RunnableThread {

	public static void main(String[] args) {

		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {

			System.out.println("Runnable Running by Thread ::: " + Thread.currentThread().getName());
		}
	}

}