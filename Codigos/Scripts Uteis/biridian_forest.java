import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
 
// this is not good for reading double values.
public class Problem329B {
	static int m = 10000007;
 
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		PrintWriter o = new PrintWriter(System.out, false);
//		System.out.println('0');
		int row = r.nextInt();
		int col = r.nextInt();
		char[][] grid = new char[row + 1][col + 1];
		int sx = 0, sy = 0, dx = 0, dy = 0;
		for (int i = 1; i <= row; i++) {
			String cr = r.readString();
			for (int j = 1; j <= col; j++) {
				grid[i][j] = cr.charAt(j - 1);
//				System.out.println(grid[i][j]);
				if (grid[i][j] == 'S') {
					dx = i;
					dy = j;
				}
				if (grid[i][j] == 'E') {
					sx = i;
					sy = j;
				}
			}
		}
		int[][] dist = new int[row + 1][col + 1];
		for (int[] a : dist)
			Arrays.fill(a, m);
// 	   System.out.println(Arrays.deepToString(grid));
		int[][] visited = new int[row + 1][col + 1];
		visited[sx][sy] = 1;
		dist[sx][sy] = 0;
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(sx, sy));
		while (!q.isEmpty()) {
			pair cp = q.poll();
			int x = cp.x;
			int y = cp.y;
			int d = dist[x][y];
 
			if (x - 1 >= 1 && grid[x - 1][y] != 'T') {
				dist[x - 1][y] = Math.min(d + 1, dist[x - 1][y]);
				if (visited[x - 1][y] == 0) {
					visited[x - 1][y] = 1;
					q.add(new pair(x - 1, y));
				}
			}
			if (y - 1 >= 1 && grid[x][y - 1] != 'T') {
				dist[x][y - 1] = Math.min(d + 1, dist[x][y - 1]);
				if (visited[x][y - 1] == 0) {
					visited[x][y - 1] = 1;
					q.add(new pair(x, y - 1));
				}
			}
			if (x + 1 <= row && grid[x + 1][y] != 'T') {
				dist[x + 1][y] = Math.min(d + 1, dist[x + 1][y]);
				if (visited[x + 1][y] == 0) {
					visited[x + 1][y] = 1;
					q.add(new pair(x + 1, y));
				}
			}
			if (y + 1 <= col && grid[x][y + 1] != 'T') {
				dist[x][y + 1] = Math.min(d + 1, dist[x][y + 1]);
				if (visited[x][y + 1] == 0) {
					visited[x][y + 1] = 1;
					q.add(new pair(x, y + 1));
				}
			}
 
		}
//		System.out.println(Arrays.deepToString(dist));
		int d = dist[dx][dy];
//		System.out.println("d" + " " + d);
		int ans = 0;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
//				System.out.println(i+" "+j+" "+dist[i][j]+" "+grid[i][j]);
				if (grid[i][j] != '0' && grid[i][j] != 'T' && grid[i][j] != 'E' && grid[i][j] != 'S' && dist[i][j] <= d) {
					ans += (grid[i][j] - 48);
//					System.out.println(ans);
				}
			}
		}
		o.println(ans);
		o.close();
	}
 
	// pair object x,y
	static class pair {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
 
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			pair other = (pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
 
		int x, y;
 
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
 
	// gcd int no
	static int gcd(int n, int r) {
		return r == 0 ? n : gcd(r, n % r);
	}
 
	static long[][] modPow(long[][] M, long exp) {
		long[][] result = new long[][] { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		long[][] pow = M;
		while (exp != 0) {
			if ((exp & 1) == 1) {
				result = multiply(result, pow);
			}
			exp >>>= 1;
			pow = multiply(pow, pow);
		}
		return result;
	}
 
	static long[][] multiply(long[][] A, long[][] B) {
		long[][] C = new long[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				long value = 0;
				for (int k = 0; k < 4; k++) {
					value += A[i][k] * B[k][j];
				}
				C[i][j] = value % m;
			}
		}
		return C;
	}
 
	// gcd long numbers
	static long gcd(long n, long r) {
		return r == 0 ? n : gcd(r, n % r);
	}
 
	// input/output
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.')
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			if (neg)
				return -ret;
			return ret;
		}
 
		public int[] readIntArray(int size) throws IOException {
			int[] arr = new int[size];
			for (int i = 0; i < size; i++)
				arr[i] = nextInt();
			return arr;
		}
 
		public long[] readLongArray(int size) throws IOException {
			long[] arr = new long[size];
			for (int i = 0; i < size; i++)
				arr[i] = nextInt();
			return arr;
		}
 
		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}
