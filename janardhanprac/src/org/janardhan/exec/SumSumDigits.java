package org.janardhan.exec;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class SumSumDigits {

	private static InputReader in;
	private static PrintWriter ou;
	private static PrintWriter dbg;
	private static StringBuilder sb;
	private static final boolean MULTIPLE_TEST_CASES = false;
	private static boolean DEBUG = false;

	private static HashMap<Long, Integer> map = new HashMap<>();

	public static void solve(int testCase) throws Exception {

		int arrSize = in.nextInt();
		int queries = in.nextInt();

		long[] arr = new long[arrSize];
		int[] arr_val = new int[arrSize];

		for (int i = 0; i < arrSize; i++) {
			arr[i] = in.nextLong();
		}

		for (int i = 0; i < arrSize; i++) {
			arr_val[i] = sumOfDigits(arr[i]);
		}

		Arrays.sort(arr_val);

		for (int q = 0; q < queries; q++) {

			int sum = 0;
			int flag = in.nextInt();
			int k = in.nextInt();
			if (flag == 1) {
				// max
				for (int i = arrSize - 1; i >= arrSize - k; i--) {
					sum = sum + arr_val[i];
				}
			}
			else {
				// min
				for (int i = 0; i < k; i++) {
					sum = sum + arr_val[i];
				}
			}
			sb.append(sum + "\n");
		}

	}

	private static int sumOfDigits(long num) {
		long sum;
		if (num / 10 == 0)
			return (int) num;
		else {
			if (map.get(num) != null)
				return map.get(num);
			else {
				sum = getSum(num);
				if (map.get(sum) != null)
					return sumOfDigits(map.get(sum));
				else {
					map.put(num, (int) sum);
					return sumOfDigits(sum);
				}

			}

		}

	}

	private static long getSum(long num) {

		long sum = 0;
		while (num != 0) {
			int lastdigit = (int) (num % 10);
			sum += lastdigit;
			num /= 10;
		}

		return sum;
	}

	private static long getMax(List<Long> list, int k) {

		if (k == 0) {
			return (list.get(0) * list.get(list.size() - 1));
		}
		return Math.max(getMax(list.subList(1, list.size()), (k - 1)), getMax(list.subList(0, list.size() - 1), (k - 1)));
	}

	public static void main(String[] args) throws Exception {
		in = new InputReader(System.in);
		ou = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		sb = new StringBuilder("");
		// debugInit();

		int t = 1;
		if (MULTIPLE_TEST_CASES) {
			t = in.nextInt();
		}

		for (int i = 1; i <= t; i++) {
			solve(i);
		}

		ou.print(sb);
		ou.close();
		debugEnd();
	}

	static class InputReader {

		private final InputStream st;
		private final byte[] buf = new byte[8192];
		private int cc, sc;
		private SpaceCharFilter f;

		public InputReader(InputStream st) {
			this.st = st;
		}

		public int t() {
			if (sc == -1)
				throw new InputMismatchException();
			if (cc >= sc) {
				cc = 0;
				try {
					sc = st.read(buf);
				}
				catch (IOException e) {
					throw new InputMismatchException();
				}
				if (sc <= 0)
					return -1;
			}
			return buf[cc++];
		}

		public int nextInt() {
			int c = t();
			while (isSpaceChar(c)) {
				c = t();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = t();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = t();
			}
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = t();
			while (isSpaceChar(c)) {
				c = t();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = t();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = t();
			}
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public String readString() {
			int c = t();
			while (isSpaceChar(c)) {
				c = t();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = t();
			}
			while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = t();
			while (isSpaceChar(c))
				c = t();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = t();
			}
			while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (f != null)
				return f.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	public static void debugInit() {
		DEBUG = true;
		dbg = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.err)));
	}

	public static void debug(Object o) {
		if (DEBUG)
			dbg.println(o.toString());
	}

	public static void debugEnd() {
		if (DEBUG)
			dbg.close();
	}
}