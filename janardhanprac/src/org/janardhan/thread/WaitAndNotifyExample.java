package org.janardhan.thread;

/***
 * 
 * @author jd
 *
 */
public class WaitAndNotifyExample {

	public static void main(String[] args) {

		Message message = new Message("process it");
		new Thread(new WaiterThread(message), "waiter1").start();
		new Thread(new WaiterThread(message), "waiter2").start();
		new Thread(new NotifierThread(message), "notifier").start();
		System.out.println("All thread processed");
	}
}

class Message {

	private String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

class WaiterThread implements Runnable {

	private Message message;

	public WaiterThread(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();

		synchronized (message) {
			System.out.println(threadName + " waiting to get notified at " + System.currentTimeMillis());
			try {

				message.wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " got notified at " + System.currentTimeMillis());
			System.out.println(threadName + " processed: " + message.getMessage());
		}

	}

}

class NotifierThread implements Runnable {

	private Message message;

	public NotifierThread(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();

		System.out.println(threadName + " started");
		try {

			Thread.sleep(1000);
			synchronized (message) {
				message.setMessage(threadName + " Notifier work done");
				message.notify();// this will notify only one thread and
									// selection of thread depends on OS
				// msg.notifyAll();// All thread will get notified
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}