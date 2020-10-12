package done;
import java.util.Scanner;

public class BackJoon15652 {
	static boolean[] visited;
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		visited = new boolean[M+1];
		sel = new int[N];
		
		perm(0, M, N, 1);

	}
	
	static void perm(int idx, int M, int N, int prv) {
		if(idx == N) {
			for(int i=0; i<N; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=prv; i<=M; i++) {
			sel[idx] = i;
			perm(idx+1, M, N, i);
		}		
	}
}
