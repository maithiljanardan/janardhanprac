package org.janardhan.thread;

public class StartAndRunMethod {

	public static void main(String[] args) {

		Thread startThread = new Thread(new Mythread("start"));
		Thread runThread = new Thread(new Mythread("run"));

		startThread.start();
		runThread.run();

	}
}

class Mythread implements Runnable {

	private String caller;

	public Mythread(String caller) {
		this.caller = caller;
	}

	@Override
	public void run() {
		System.out.println("Thread called from " + Thread.currentThread().getName() + " with " + caller);

	}

}
