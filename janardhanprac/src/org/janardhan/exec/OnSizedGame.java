package org.janardhan.exec;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.janardhan.input.InputParser;

public class OnSizedGame {

	List<Integer> arrList;

	public void solve(InputParser in, PrintWriter out) throws Exception {

		int arr_size = in.nextInt();
		arrList = new ArrayList<>();

		// Populate array
		for (int i = 0; i < arr_size; i++) {
			arrList.add(in.nextInt());
		}

		do {
			int index = this.getIndexSmallestElement(arrList);

			do {
				for (int i = 0; i < arrList.size(); i++) {
					arrList.set(i, (arrList.get(i) - (index + 1)));
				}

			}
			while (arrList.get(index) >= 0);

			this.removeNegativeElement();

		}
		while (this.arrList.size() > 1);

		if (arrList.size() > 0) {
			out.write("Ladia \n");
		}
		else {
			out.write("Kushagra \n");
		}
	}

	private void removeNegativeElement() {

		Iterator<Integer> it = this.arrList.iterator();

		while (it.hasNext()) {
			if (it.next() < 0) {
				it.remove();
			}
		}
	}

	private int getIndexSmallestElement(List<Integer> arrList) {

		int smallest = arrList.get(0);

		int index = 0;
		for (int i = 1; i < arrList.size(); i++) {
			if (arrList.get(i) < smallest) {
				smallest = arrList.get(i);
				index = i;
			}
		}
		return index;
	}

}
