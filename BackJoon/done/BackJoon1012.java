package done;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon1012 {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[N][M];
			for(int i=0; i<K; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				map[x][y] = 1;
			}
			
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						count++;
						int[] dx = {-1,0,1,0};
						int[] dy = {0,1,0,-1};
						Queue<Point> q = new LinkedList<>();
						q.add(new Point(i,j));
						map[i][j] = 0;
						while(!q.isEmpty()) {
							Point p = q.poll();
							
							for(int k=0;k<4;k++) {
								int newX = p.x + dx[k];
								int newY = p.y + dy[k];
								if(newX>-1&&newY>-1&&newX<N&&newY<M&&map[newX][newY]==1) {
									map[newX][newY] = 0;
									q.add(new Point(newX, newY));
								}
							}
						}
					}
				}
			}
			
			System.out.println(count);
			
			
		}

	}

}
