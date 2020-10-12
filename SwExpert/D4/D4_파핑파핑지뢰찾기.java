package D4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class D4_파핑파핑지뢰찾기 {
	static class Point implements Comparable<Point>{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			if(cnt[this.x][this.y] > cnt[o.x][o.y]) return 1;
			else if(cnt[this.x][this.y] < cnt[o.x][o.y]) return -1;
			return 0;
		}
	}
	static int N;
	static int min;
	static char[][] map;
	static int[][] cnt;
	//static boolean[][] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();sc.nextLine();
			map = new char[N][N];
			cnt = new int[N][N];
			PriorityQueue<Point> pq = new PriorityQueue<>();
			
			for(int i=0; i<N; i++) {
				String str = sc.nextLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j);
					//if(map[i][j]=='.') {
					//	pq.add(new Point(i, j));
					//}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == '.') {
						int bomb = 0;
						int[] dx = {-1,-1,0,1,1,1,0,-1};
						int[] dy = {0,1,1,1,0,-1,-1,-1};
						
						for(int k=0; k<8; k++) {
							int newX = i + dx[k];
							int newY = j + dy[k];
							
							if(newX>-1&&newY>-1&&newX<N&&newY<N&&map[newX][newY]=='*') {
								bomb++;
							}
						}
						
						cnt[i][j] = bomb;
					} else {
						cnt[i][j] = -1;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='.') {
						pq.add(new Point(i, j));
					}
				}
			}
			min = Integer.MAX_VALUE;
			dfs(pq);
			
			System.out.println("#"+t+" " + min);
		}

	}
	static void dfs(PriorityQueue<Point> pq) {
		int count = 0;
		boolean[][] v = new boolean[N][N];
		
		while(!pq.isEmpty()) {
			Point start = pq.poll();
			
			if(!v[start.x][start.y]) {
				count++;
				//System.out.println("c : "+count + " (" + start.x + "," + start.y + ")");
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(start.x, start.y));
				v[start.x][start.y] = true;
				while(cnt[start.x][start.y]==0 && !q.isEmpty()) {
					Point cur = q.poll();
					int[] dx = {-1,-1,0,1,1,1,0,-1};
					int[] dy = {0,1,1,1,0,-1,-1,-1};
					
					for(int k=0; k<8; k++) {
						int newX = cur.x + dx[k];
						int newY = cur.y + dy[k];
						
						if(newX>-1&&newY>-1&&newX<N&&newY<N&&map[newX][newY]=='.'&&!v[newX][newY]) {
							v[newX][newY] = true;
							if(cnt[newX][newY]==0) {
								q.add(new Point(newX, newY));
							}
						}
					}
				}
			}
		}
		
		min = Math.min(min, count);
	}
}
