package 모의기출;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwEx_탈주범검거 {
	static class Point {
		int r,c,t;
		public Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt(); //시간
			
			int[][] map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(R,C,L-1));
			boolean[][] v = new boolean[N][M];
			v[R][C] = true;
			int count = 1;
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				if(p.t==0) break;
				boolean[] dir = new boolean[4];
				if(map[p.r][p.c]==1) {
					dir[0] = true;
					dir[1] = true;
					dir[2] = true;
					dir[3] = true;
				} else if(map[p.r][p.c]==2) {
					dir[0] = true;
					dir[2] = true;
				}else if(map[p.r][p.c]==3) {
					dir[1] = true;
					dir[3] = true;
				}else if(map[p.r][p.c]==4) {
					dir[0] = true;
					dir[1] = true;
				}else if(map[p.r][p.c]==5) {
					dir[1] = true;
					dir[2] = true;
				}else if(map[p.r][p.c]==6) {
					dir[2] = true;
					dir[3] = true;
				} else if(map[p.r][p.c]==7) {
					dir[0] = true;
					dir[3] = true;
				}
				
				int[] dx = {-1,0,1,0};
				int[] dy = {0,1,0,-1};
				for(int i=0; i<4; i++) {
					if(!dir[i])
						continue;
					int nx = p.r+dx[i];
					int ny = p.c+dy[i];
					
					if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==0||v[nx][ny])
						continue;
					
					
					boolean[] dir1 = new boolean[4];
					if(map[nx][ny]==1) {
						dir1[0] = true;
						dir1[1] = true;
						dir1[2] = true;
						dir1[3] = true;
					} else if(map[nx][ny]==2) {
						dir1[0] = true;
						dir1[2] = true;
					}else if(map[nx][ny]==3) {
						dir1[1] = true;
						dir1[3] = true;
					}else if(map[nx][ny]==4) {
						dir1[0] = true;
						dir1[1] = true;
					}else if(map[nx][ny]==5) {
						dir1[1] = true;
						dir1[2] = true;
					}else if(map[nx][ny]==6) {
						dir1[2] = true;
						dir1[3] = true;
					} else if(map[nx][ny]==7) {
						dir1[0] = true;
						dir1[3] = true;
					}					

					if(dir[i] && dir1[(i+2)%4]) {
						q.add(new Point(nx, ny, p.t-1));
						v[nx][ny] = true;
						count++;
					}
				}
			}
			
			System.out.println("#"+t+" "+count);
		}

	}

}
