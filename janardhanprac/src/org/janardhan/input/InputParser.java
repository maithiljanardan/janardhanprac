package org.janardhan.input;

import java.io.DataInputStream;
import java.io.InputStream;

public class InputParser {

	final private int BUFFER_SIZE = 1 << 17;
	public DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public InputParser(InputStream in) {
		din = new DataInputStream(in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String nextString() throws Exception {
		StringBuffer sb = new StringBuffer("");
		byte c = read();
		while (c <= ' ')
			c = read();
		do {
			sb.append((char) c);
			c = read();
		} while (c > ' ');
		return sb.toString();
	}

	public char nextChar() throws Exception {
		byte c = read();
		while (c <= ' ')
			c = read();
		return (char) c;
	}

	public int nextInt() throws Exception {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		do {
			ret = ret * 10 + c - '0';
			c = read();
		} while (c > ' ');
		return ret;
	}

	private void fillBuffer() throws Exception {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws Exception {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
}
