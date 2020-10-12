package D4;
import java.util.Scanner;

public class D4_수지의수지맞는여행 {
	static char[][] map;
	static boolean[] visited;
	static int R,C;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			R = sc.nextInt();
			C = sc.nextInt();sc.nextLine();
			map = new char[R][C];
			visited = new boolean[26];
			
			for(int i=0; i<R; i++) {
				String str = sc.next();
				for(int j=0; j<C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			max = Integer.MIN_VALUE;
			visited[map[0][0]-'A'] = true;
			dfs(1, 0, 0);
			
			System.out.println("#"+t + " "+max);
		}
	}
	
	static void dfs(int cnt, int x, int y) {
		if(cnt > 26)
			return;
		
		max = Math.max(max, cnt);
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		for(int k=0; k<4; k++) {
			int newX = x+dx[k];
			int newY = y+dy[k];
			if(newX>-1&&newY>-1&&newX<R&&newY<C&&!visited[map[newX][newY]-'A']) {
				//System.out.println(alph+ " : " +newX + ", "+newY);
				visited[map[newX][newY]-'A'] = true;
				dfs(cnt+1, newX, newY);
				visited[map[newX][newY]-'A'] = false;
			}
		}
	}

}
