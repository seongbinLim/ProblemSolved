package done;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//concept
//1. 25중 7명을 뽑는다. (이다솜파가 4명 이상인지 check)
//2. 그게 dfs로 연결되어있는지 검색
public class BackJoon1941_2 {
	static int ans;
	
	static char[][] array;
	static boolean[][] map;
	static boolean[] visited;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		array = new char [5][5];

		for(int i=0; i<5; i++) {
			array[i] = sc.nextLine().toCharArray();
		}
		
		for(int i=0; i<25; i++) {
			visited = new boolean[25];
			map = new boolean[5][5];
			dfs(i,1,0,i);
		}
		
		System.out.println(ans);

	}

	public static void dfs(int n, int cnt, int s, int startPoint) {
		if(array[n/5][n%5] == 'S') {
			++s;
		}
		
		visited[n] = true;
		map[n/5][n%5] = true;
		
		if(cnt == 7) {
			if(s>=4) {
				boolean[] v = visited.clone();
				if(isConnect(startPoint, v)) { 
					ans++;
				}
			}
		} else {
			for(int i=n+1; i<25; i++) {
				if(!visited[i])
					dfs(i, cnt+1, s, startPoint);
			}
		}
		
		visited[n] = false;
		map[n/5][n%5] = false;
	}
	
	static class Point {
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static boolean isConnect(int start, boolean[] v) {
		int x = start/5;
		int y = start%5;

		//System.out.println(x + ", " + y);
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		v[x*5 + y] = false;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<5 && ny<5 && v[nx*5+ny]) {
					//System.out.println(nx + ", " +ny);
					v[nx*5 + ny] = false;
					q.add(new Point(nx, ny));
					cnt++;
				}
			}
		}
		
		if(cnt==7)
			return true;
		return false;
	}

}
