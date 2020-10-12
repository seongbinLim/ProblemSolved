package done;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Virus2 {
	public static class Point {
		int x;
		int y;
		int z;
		public Point(int x,int y,int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	};
	
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int H = sc.nextInt();

		Stack<Point> p = new Stack<>();
		
		int[][][] map = new int[M][N][H];
		boolean[][][] check = new boolean[M][N][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j][k] = sc.nextInt();
					if(map[i][j][k] == 1) {
						p.add(new Point(i,j,k));
					}
				}
			}
		}
		
		



	}

}
