package done;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon14889 {
	static int N;
	static int[] sel;
	static int[][] potential;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		potential = new int[N][N];
		sel = new int[N/2];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				potential[i][j] = sc.nextInt();
			}
		}
		
		combi(0,0);
		System.out.println(min);

	}
	static void combi(int idx, int s_idx) {	
		if(s_idx == sel.length) {
			int[] teamB = new int[N/2];
			boolean[] check = new boolean[N];
			for(int i=0; i<N/2; i++) {
				check[sel[i]] = true;
			}
			
			int index = 0;
			for(int i=0; i<N; i++) {
				if(!check[i])
					teamB[index++] = i;
			}
			
			int A = 0; int B = 0;
			
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					A = A + potential[sel[i]][sel[j]];
					B = B + potential[teamB[i]][teamB[j]];
				}
			}
			
			int diff = Math.abs(A-B);
			min = Math.min(min, diff);
		
			return;
		}
		if(idx == potential.length) return;
		sel[s_idx] = idx;
	
		combi(idx+1, s_idx+1);
		combi(idx+1, s_idx);
	}

}
