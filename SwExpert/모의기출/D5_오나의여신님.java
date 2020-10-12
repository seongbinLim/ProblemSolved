package 모의기출;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D5_오나의여신님 {
	static class Point {
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][M];
			boolean[][] v = new boolean[N][M];
			
			Queue<Point> q = new LinkedList<>();
			Queue<Point> devil = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'S') {
						//map[i][j] = '.';
						q.add(new Point(i, j));
						v[i][j] = true;
					}
					if(map[i][j] ==  '*') {
						devil.add(new Point(i, j));
					}
				}
			}
			
			int time = 0;
			boolean find  = false;
			
			int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
			
			B : while(!q.isEmpty()) {
				time++;
				int devilSize = devil.size();
				for(int i=0; i<devilSize; i++) {
					Point devP = devil.poll();
					for(int k=0; k<4; k++) {
						int devX = devP.x + dir[k][0];
						int devY = devP.y + dir[k][1];
						
						if(devX>-1&&devY>-1&&devX<N&&devY<M&&map[devX][devY]=='.') {
							map[devX][devY]='*';
							devil.add(new Point(devX, devY));
						}
					}
				}
				
				int size = q.size();
				for(int j=0; j<size; j++) {
					Point p = q.poll();
					
					for(int k=0; k<4; k++) {
						int suyeonX = p.x + dir[k][0];
						int suyeonY = p.y + dir[k][1];
						if(suyeonX>-1&&suyeonY>-1&&suyeonX<N&&suyeonY<M&&(map[suyeonX][suyeonY]=='.'||map[suyeonX][suyeonY]=='D')&&!v[suyeonX][suyeonY]) {
							if(map[suyeonX][suyeonY]=='D') {
								find = true;
								break B;
							}
							q.add(new Point(suyeonX, suyeonY));
							v[suyeonX][suyeonY] = true;
						}
					}
					
				}
			}
			
			sb.append("#"+t+" ");
			if(!find) sb.append("GAME OVER");
			else sb.append(time);
			
			System.out.println(sb.toString());
		}

	}

}
