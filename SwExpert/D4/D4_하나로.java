package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//개어려움
public class D4_하나로 {
	static class Point {
		int x,y;
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static Point[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			
			arr = new Point[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = new Point();
				arr[i].x = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				arr[i].y = sc.nextInt();
			}
			
			float E = sc.nextFloat();
			
			double[][] size = new double[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i!=j && size[i][j]==0) {
						size[i][j] = distance(i, j);
						size[j][i] = size[i][j];
					}
				}
			}
			
			boolean[][] adj = new boolean[N][N];
			int[] index = new int[2];
			do {
				//값이 최소인 index 고르기
				index = min(size);
				adj[index[0]][index[1]] = true;
				adj[index[1]][index[0]] = true;
			
				//모두 순회가능한지 check

			} while(!bfs(adj, index[0]));
			
			double result = 0;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(adj[i][j]) {
						result += size[i][j]*E;
					}
				}
			}
			
			System.out.println(Math.round(result));
		}

	}
	static int[] min(double[][] size) {
		int[] index = new int[2];
		double min = Double.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(min > size[i][j]) {
					min = size[i][j];
					index[0] = i;
					index[1] = j;
				}
			}
		}
		
		return index;
	}
	static double distance(int i, int j) {
		return Math.pow(arr[i].x-arr[j].x,2) + Math.pow(arr[i].y-arr[j].y, 2);
	}
	static boolean bfs(boolean[][] adj, int first) {
		boolean[] v = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(first);
		v[first] = true;
		while(!q.isEmpty()) {
			for(int i=0; i<N;i++) {
				if(adj[first][i]) {
					q.add(i);
					v[i] = true;
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(!v[i]) return false;
		}
		return true;
	}

}
