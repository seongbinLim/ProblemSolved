package 모의기출;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwEx1949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			max = -1;
			maxLen = -1;
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					v = new boolean[N][N];
					v[i][j] = true;
					if(map[i][j] == max) {
						dfs(i, j, 1, false);
					}
					//System.out.println("-----------------");
				}
			}
			sb.append("#"+t+" "+maxLen+"\n");
		}
		System.out.println(sb.toString());
	}
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int max;
	static int maxLen;
	static int N, K;
	static void dfs(int x, int y, int len, boolean use) {
		//System.out.println(x +" , " + y +" : " + map[x][y] + " / " + len);
		
		if(searchAll(x, y, use)) {
			maxLen = Math.max(maxLen, len);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			int k = K;
			if(use) k = 0;
			for(int j=0; j<=k; j++) {
				if(nx>-1 && nx<N && ny>-1 && ny<N && !v[nx][ny] && (map[nx][ny]-j>-1) && (map[nx][ny]-j < map[x][y])) {
					if(j>0) use = true;
					v[nx][ny] = true;
					map[nx][ny] = map[nx][ny]-j;
					dfs(nx, ny, len+1, use);
					map[nx][ny] = map[nx][ny]+j;
					v[nx][ny] = false;
					if(j>0) use = false;
				}
			}
		}
	}
	
	static boolean searchAll(int x, int y, boolean use) {
		boolean visit = true;
		for(int i=0; i<4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if(nx>-1&&ny>-1&&nx<N&&ny<N&&!v[nx][ny]) {
				visit = false;
				break;
			}
		}
		
		boolean min = true;
		int k = K;
		if(use) k = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			for(int j=0; j<=k; j++) {
				if(nx>-1&&ny>-1&&nx<N&&ny<N&&map[nx][ny]-j>-1&&map[x][y]>map[nx][ny]-j) {
					min = false;
					break;
				}
			}
		}
		
		return visit||min;
	}
}
