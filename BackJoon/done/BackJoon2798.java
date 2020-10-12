package done;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon2798 {
	static int max;
	static int N;
	static int M;
	static int[] card;
	static int[] sel = new int[3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		card = new int[N];
		max = 0;
		for(int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		comb(0,0);
		System.out.println(max);

	}
	
	static void comb(int s_idx, int idx) {
		if(s_idx == 3) {
			int total = sel[0]+sel[1]+sel[2];
			if(total <= M)
				max = Math.max(max, total);
			return;
		}
		if(idx == card.length) {
			return;
		}

		sel[s_idx] = card[idx];
		comb(s_idx+1, idx+1);
		comb(s_idx, idx+1);
	}

}
