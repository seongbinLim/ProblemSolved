package done;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon1726 {
	static class Point {
		int x;
		int y;
		int dir;
		
		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[][] map = new int[row][col];
		boolean[][][] v = new boolean[row][col][4];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//0 : �� 
		//1 : ��
		//2 : ��
		//3 : ��
		int robotX = sc.nextInt()-1;
		int robotY = sc.nextInt()-1;
		int robotD = sc.nextInt()-1;
		
		int endX = sc.nextInt()-1;
		int endY = sc.nextInt()-1;
		int endD = sc.nextInt()-1;

		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(robotX, robotY, robotD));
		v[robotX][robotY][robotD] = true;
		
		int size = q.size();
		int cnt = 0;
		while(!q.isEmpty()) {
			if(size==0)  {
				size = q.size();
				cnt++;
			}
			Point p = q.poll();
			size--;
			//System.out.println(cnt + " : " + p.x + ", " + p.y + ", " + p.dir);
			if(p.x == endX && p.y == endY && p.dir == endD) {
				System.out.println(cnt);
				break;
			}
			
			B:for(int i=2; i<7; i++) {
				//direction change
				if(i<4) {
					int direction = p.dir;
					if(i == 2) {
						if(direction == 0) direction = 2;
						else if(direction == 1) direction = 3;
						else if(direction == 2) direction = 1;
						else if(direction == 3) direction = 0;
					} else {
						if(direction == 0) direction = 3;
						else if(direction == 1) direction = 2;
						else if(direction == 2) direction = 0;
						else if(direction == 3) direction = 1;
					}
					if(!v[p.x][p.y][direction]) {
						q.add(new Point(p.x, p.y, direction));
						v[p.x][p.y][direction] = true;
					}	
				} 
				//go 1,2,3
				else {
					int go = i-3;
					int newX = p.x;
					int newY = p.y;
					boolean ok = true;
					for(int k=0; k<go; k++) {
						newX += dr[p.dir];
						newY += dc[p.dir];
						if(newX > -1 && newY > -1 && newX < row && newY < col && map[newX][newY] == 0) {
						} else {
							ok = false;
							break B;
						}
					}
					
					if(ok && !v[newX][newY][p.dir]) {
						q.add(new Point(newX, newY, p.dir));
						v[newX][newY][p.dir] = true;
					}
				}
			}
		}
	}

}
