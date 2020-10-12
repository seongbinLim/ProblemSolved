package 모의기출;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwEx_벽돌깨기 {
	//static int[][] map;
	static int N;
	static int W;
	static int H;
	static int min;

	static class Point {
		int x, y, size;
		public Point(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			int[][] map = new int[H][W];
			for(int i=0; i<H ;i ++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			pick(0, map);
			
			System.out.println(min);
		}
	}
	
	static void pick(int idx, int[][] m) {
		System.out.println(idx + " , " + min);
		if(idx==N) {
			int count = 0;
			for(int i=0; i<H ;i ++) {
				for(int j=0; j<W; j++) {
					if(m[i][j]!=0) count++;
				}
			}
			
			min = Math.min(min, count);
			System.out.println(min + "ㅋ");
			return;
		}		
		
		for(int i=0; i<W; i++) {
			int[] len = getIndexOfRow(m);
			if(len[i]!=-1) {
				int[][] newMap = new int[H][W]; 
				for(int index=0; index<H; index++) {
					newMap[index] = m[index].clone();
				}
				bfs(newMap, i, len);
				pick(idx+1, newMap);
			}
		}
	}
	static int[][] bfs(int[][] m, int pick, int[] len) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(len[pick], pick, m[len[pick]][pick]));
		//bfs()
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			m[p.x][p.y] = 0;
			System.out.println(p.x +", " + p.y);
			for(int k=0; k<4; k++) {
				int nx = p.x;
				int ny = p.y;
				int size = p.size-1;
				
				for(int go=0; go<size; go++) {
					nx += dx[k];
					ny += dy[k];
					
					if(nx>-1&&ny>-1&&nx<H&&ny<W&&m[nx][ny]!=0) {
						q.add(new Point(nx, ny, m[nx][ny]));
						//m[nx][ny] = 0;
					}
				}
			}
		}
		
		//구슬 떨어트리기
		for(int j=0; j<W; j++) {
			for(int i=H-2; i>-1; i--) {
				if(m[i][j]!=0) {
					int idx = i;
					do {
						idx++;
					}while(idx<H && m[idx][j]!=0);
					
					if(m[idx-1][j]==0) {
						m[idx-1][j] = m[i][j];
						m[i][j] = 0;
					}
				}
			}
		}
		
		print(m);
		return m;
	}
	static int[] getIndexOfRow(int[][] m) {
		int[] len = new int[W]; //row index 저장
		
		Arrays.fill(len, -1);
		for(int i=0; i<H ;i ++) {
			for(int j=0; j<W; j++) {
				if(len[j]==-1 && m[i][j]!=0) {
					len[j] = i;
				}
			}
		}
		System.out.println(Arrays.toString(len));
		return len;
	}
	
	static void print (int[][] m) {
		//System.out.println("--------------------");
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(m[i][j] + " " );
			}
			System.out.println();
		}
	}

}
