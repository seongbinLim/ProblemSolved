package done;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon10026 {
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
		int N = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[N][N];
		char[][] map2 = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R' || map[i][j] == 'G')  {
					map2[i][j] = 'R';
				} else {
					map2[i][j] = 'B';
				}
			}
		}
		
		int[] district = new int[3];
		int[] district2 = new int[2];
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 'W') {
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i,j));
					char color = map[i][j];
					if(color == 'R') district[0]++;
					else if(color == 'G') district[1]++;
					else if(color == 'B') district[2]++;
					map[i][j] = 'W';
					
					while(!q.isEmpty()) {
						Point p = q.poll();
						for(int k=0; k<4; k++) {
							int X = p.x + dx[k];
							int Y = p.y + dy[k];
							
							if(X>-1 && Y>-1 && X<N && Y<N && map[X][Y]==color) {
								map[X][Y] = 'W';
								q.add(new Point(X, Y));
							}
						}
					}
					
				}
				
				if(map2[i][j] != 'W') {
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i,j));
					char color = map2[i][j];
					if(color == 'R') district2[0]++;
					else if(color == 'B') district2[1]++;
					map2[i][j] = 'W';
					
					while(!q.isEmpty()) {
						Point p = q.poll();
						for(int k=0; k<4; k++) {
							int X = p.x + dx[k];
							int Y = p.y + dy[k];
							
							if(X>-1 && Y>-1 && X<N && Y<N && map2[X][Y]==color) {
								map2[X][Y] = 'W';
								q.add(new Point(X, Y));
							}
						}
					}
				}
			}
		}
		
		int total = district[0] + district[1] + district[2];
		int total2 = district2[0] + district2[1];
		
		System.out.println(total + " " + total2);
	}

}
