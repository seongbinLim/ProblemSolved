package done;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon13459 {
	static class Point {
		int rx, ry;
		int bx, by;

		boolean Rin, Bin;
		public Point(int x, int y, int bx, int by, boolean Rin, boolean Bin) {
			this.rx = x;
			this.ry = y;
			this.bx = bx;
			this.by = by;
			this.Rin = Rin;
			this.Bin = Bin;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[N][M];
		boolean[][][][] v = new boolean[N][M][N][M];
		int rx = -1, ry = -1, bx = -1, by = -1;
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);

				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
				}
				
				if(map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(rx, ry, bx, by, false, false));
		v[rx][ry][bx][by] = true;
		
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int count = 0;
		boolean find = false;
		while(!q.isEmpty()) {
			System.out.println(q.size());
			int size = q.size();
			for(int k=0; k<size; k++) {
			Point p = q.poll();

				for(int i=0; i<4; i++) {
					int rX = p.rx;
					int rY = p.ry;
					int bX = p.bx;
					int bY = p.by;
					
					if(!p.Rin) {
						rX = p.rx + dx[i];
						rY = p.ry + dy[i];
					}
					if(!p.Bin) {
						bX = p.bx + dx[i];
						bY = p.by + dy[i];
					}
					if(rX==0) rX=1;
					if(rX==N-1) rX=N-2;
					if(rY==0) rY=1;
					if(rY==M-1) rY=M-2;
					
					
					if(bX==0) bX=1;
					if(bX==N-1) bX=N-2;
					if(bY==0) bY=1;
					if(bY==M-1) bY=M-2;
					
					if(rX>-1&&rY>-1&&rX<N&&rY<M
					 &&bX>-1&&bY>-1&&bX<N&&bY<M 
					 &&!v[rX][rY][bX][bY]) {
						
						boolean redIn = p.Rin;
						boolean blueIn = p.Bin;
						if(map[rX][rY]=='O') {
							if(!p.Bin && count < 10) find = true;
							redIn = true;
						}
						if(map[bX][bY]=='O') {
							find = false;
							blueIn = true;
						}

						v[rX][rY][bX][bY] = true;
						q.add(new Point(rX, rY, bX, bY, redIn, blueIn));
					}
				 }
			 }
			count++;
		}
		
		if(find) System.out.println(1);
		else System.out.println(0);
		

	}

}
