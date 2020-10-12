package done;

import java.util.Scanner;

public class BackJoon6987 {
	static int[] g1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] g2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[] win;
	static int[] lose;
	static int[] draw;
	static boolean possible;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		win = new int[6];
		lose = new int[6];
		draw = new int[6];
		
		for(int i=0; i<4; i++) {
            int winN = 0, loseN = 0, drawN = 0;
			for(int j=0; j<6; j++) {
				win[j] = sc.nextInt();
				draw[j] = sc.nextInt();
				lose[j] = sc.nextInt();
			}
			possible = false;
			dfs(0);
			if(!possible || (winN+loseN+drawN!=30)) sb.append("0 ");
			else sb.append("1 ");
		}
		
		System.out.println(sb.toString());

	}
	static void dfs(int num) {
		if(num==15) {
			possible = true;
			return;
		}
		
		int team1 = g1[num];
		int team2 = g2[num];
		
		//team1 승리
		if(win[team1] > 0 && lose[team2] > 0) {
			win[team1]--;
			lose[team2]--;
			dfs(num+1);
			win[team1]++;
			lose[team2]++;
		}
		
		//team1 패배
		if(lose[team1] > 0 && win[team2] > 0) {
			lose[team1]--;
			win[team2]--;
			dfs(num+1);
			lose[team1]++;
			win[team2]++;
		}
		
		//무승부
		if(draw[team1] > 0 && draw[team2] > 0) {
			draw[team1]--;
			draw[team2]--;
			dfs(num+1);
			draw[team1]++;
			draw[team2]++;
		}
	}
}
