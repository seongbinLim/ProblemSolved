package newVersion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Backjoon20166 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] in = br.readLine().split(" ");
		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);
		int R = Integer.parseInt(in[2]);
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				go(r,c, map[r][c]+"");
			}
		}
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			if(hm.get(str)==null) sb.append("0\n");
			else sb.append(hm.get(str)+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

	static char[][] map;
	static int N,M;
	static Map<String, Integer> hm = new HashMap<String, Integer>();
	private static void go(int r, int c, String current) {
		if(hm.containsKey(current)) hm.put(current, hm.get(current)+1);
		else hm.put(current, 1);
		
		if(current.length()>=5) return;
		
		int[] dc = {-1,0,1,0,1,-1,1,-1};
		int[] dr = {0,1,0,-1,1,-1,-1,1};
		for(int i=0; i<8; i++) {
			int idx = current.length();
			int nc = c +dc[i];
			int nr = r +dr[i];
			if(nc==-1) nc = M-1;
			else if(nc==M) nc = 0;
			
			if(nr==-1) nr = N-1;
			else if(nr==N) nr = 0;

			
			go(nr, nc, current+map[nr][nc]);
			
		}
	}
}
