package done;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon17141 {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int M;
	static int min;
	static int[][] map;
	static ArrayList<Point> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					map[i][j] = 0;
					list.add(new Point(i, j));
				}
			}
		}
		min = Integer.MAX_VALUE;
		nCr(0,0,new int[M]);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	static void nCr(int idx, int sIdx, int[] arr) {
		if(sIdx == arr.length) {
			//System.out.println(Arrays.toString(arr));
			int[][] copy = new int[N][N];
			for(int i=0; i<N; i++) {
				copy[i] = map[i].clone();
			}
			Queue<Point> q = new LinkedList<>();
			for(int i=0; i<sIdx; i++) {
				int x = list.get(arr[i]).x;
				int y = list.get(arr[i]).y;
				q.add(new Point(x, y));
				copy[x][y] = 2;
			}
			int time = bfs(q, copy);
			if(time != -1)
				min = Math.min(min, time);
			return;
		}
		if(idx == list.size()) return;
		
		arr[sIdx] = idx;
		nCr(idx+1, sIdx+1, arr);
		nCr(idx+1, sIdx, arr);
	}
	
	static int bfs(Queue<Point> q, int[][] copy) {
		int count = 0;
		int size = q.size();
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while(!q.isEmpty()) {
			if(size==0) {
				size = q.size();
				count++;
			}
			Point p = q.poll();
			size--;
			for(int i=0; i<4; i++) {
				int X = p.x + dx[i];
				int Y = p.y + dy[i];
				if(X>-1 && Y>-1 && X<N && Y<N && copy[X][Y]==0) {
					q.add(new Point(X, Y));
					copy[X][Y] = 2;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (copy[i][j] == 0) return -1;
			}
		}
		return count;
		
	}

}
