package 모의기출;
import java.util.Arrays;
import java.util.Scanner;

public class SwEx요리사 {
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int size = N/2;
			
			v = new boolean[N];
			sel = new int[size];
			min = Integer.MAX_VALUE;
			nCr(0, 0);
			
			System.out.println("#"+t+" " + min);
		}
	}
	
	static int[] sel;
	static boolean[] v;
	static int min;
	static void nCr(int idx, int cnt) {
		if(idx==(N/2)) {
			//System.out.println(Arrays.toString(sel));
			int totalA = 0;
			for(int i=0; i<sel.length; i++) {
				for(int j=i+1; j<sel.length; j++) {
					totalA += map[sel[i]][sel[j]];
					totalA += map[sel[j]][sel[i]];
				}
			}
			
			int size = N/2;
			int[] selB = new int[size];
			int index = 0;
			for(int i=0; i<v.length; i++) {
				if(!v[i]) {
					selB[index++] = i;
				}
			}
			
			int totalB = 0;
			for(int i=0; i<selB.length; i++) {
				for(int j=i+1; j<selB.length; j++) {
					totalB += map[selB[i]][selB[j]];
					totalB += map[selB[j]][selB[i]];
				}
			}
			
			min = Math.min(min, Math.abs(totalA-totalB));
			return;
		}

		for(int i=cnt; i<N; i++) {
			sel[idx] = i;
			v[i] = true;
			nCr(idx+1, i+1);
			v[i] = false;
		}	
	}
}
