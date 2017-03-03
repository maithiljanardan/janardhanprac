package org.janardhan.datastructure;

import java.util.Scanner;

public class IterativeTOH {

	private int nDisks;

	public IterativeTOH(int nDisks) {
		this.nDisks = nDisks;
	}

	public void execute() {

		int n = nDisks;

		int limit = (int) Math.pow(2, n) - 1;

		for (int i = 0; i < limit; i++) {

			int disk = disk(i); // DISK TO BE MOVED

			int source = (movements(i, disk) * direction(disk, n)) % 3; // SOURCE
																		// PEG
			int destination = (source + direction(disk, n)) % 3; // DESTINATION
																	// PEG
			move(disk, source, destination);
		}
	}

	private int disk(int i) {

		// RETURNS THE DISK TO BE MOVED IN i
		int C, x = i + 1; // SINCE FOR STARTS WITH 0, ADDING 1

		for (C = 0; x % 2 == 0; C++) { // CONTINUOUS DIVISION BY 2 UNTIL ODD
										// OCCURS
			x /= 2;
		}
		return C; // RETURNS THE COUNTER C
	}

	private int movements(int i, int d) { // HOW MANY TIMES DISK d HAS MOVED
											// BEFORE STAGE i
		while (d-- != 0)
			i /= 2;
		return (i + 1) / 2;
	}

	private int direction(int d, int n) { // EACH DISK MOVES IN SAME DIRECTION
											// CW=1, ACW=2
		return 2 - (n + d) % 2;
	}

	private void move(int disk, int source, int destination) {
		System.out.println("Move Disk " + (disk + 1) + " from Tower " + (source + 1) + " to Tower " + (destination + 1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the No. of Disks : ");
		IterativeTOH toh = new IterativeTOH(sc.nextInt());
		toh.execute();
	}
}
