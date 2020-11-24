package newVersion;

import java.util.Arrays;
import java.util.Scanner;

public class Backjoon20165 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] map = new int[N][M];
		status = new boolean[N][M];
		
		int[][] attack = new int[R][3];
		int[][] defense = new int[R][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		sc.nextLine();
		for(int i=0; i<R; i++) {
			String[] input = sc.nextLine().split(" ");

			attack[i][0] = Integer.parseInt(input[0])-1;
			attack[i][1] = Integer.parseInt(input[1])-1;
			if("E".equals(input[2])) attack[i][2] = 0;
			if("S".equals(input[2])) attack[i][2] = 1;
			if("W".equals(input[2])) attack[i][2] = 2;
			if("N".equals(input[2])) attack[i][2] = 3;
			defense[i][0] = sc.nextInt()-1;
			defense[i][1] = sc.nextInt()-1;

			sc.nextLine();
			
		}
		
		for(int i=0; i<R; i++) {
			go(map, attack[i][0], attack[i][1], attack[i][2]);
			status[defense[i][0]][defense[i][1]] = false;
		}
		
		System.out.println(cnt);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!status[i][j]) System.out.print("S ");
				else System.out.print("F ");
			}
			System.out.println();
		}
	}
	static int cnt = 0;
	static boolean[][] status;
	private static void go(int[][] map, int r, int c, int dir) {
		int N = map.length;
		int M = map[0].length;
		
		if(dir==0) { //East
			int maxLen = c + map[r][c]-1;
			for(int i=c; i<M; i++) {
				if(!status[r][i] && maxLen>=i) {
					cnt++;
					status[r][i] = true;
					maxLen = Math.max(maxLen, i+map[r][i]-1);
				}
			}
		} else if(dir==1) { //South
			int maxLen = r + map[r][c]-1;
			for(int i=r; i<N; i++) {
				if(!status[i][c] && maxLen>=i) {
					cnt++;
					status[i][c] = true;
					maxLen = Math.max(maxLen, i+map[i][c]-1);
				}
			}
		} else if(dir==2) { //West
			int maxLen = c - map[r][c]+1;
			for(int i=c; i>=0; i--) {
				if(!status[r][i] && maxLen<=i) {
					cnt++;
					status[r][i] = true;
					maxLen = Math.min(maxLen, i-map[r][i]+1);
				}
			}
		} else if(dir==3) { //North
			int maxLen = r - map[r][c]+1;
			for(int i=r; i>=0; i--) {
				if(!status[i][c] && maxLen<=i) {
					cnt++;
					status[i][c] = true;
					maxLen = Math.min(maxLen, i-map[i][c]+1);
				}
			}
		}
	}

}
