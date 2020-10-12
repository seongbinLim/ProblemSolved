package done;
import java.util.Scanner;

public class BackJoon15649 {
	static boolean [] flag;
	static int[] num;
	static int[] go;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		flag = new boolean[n];
		num = new int[n];
		go = new int[r];
		
		for(int i=0; i<n; i++) {
			num[i] = i+1;
		}
		
		nCr(0, r);
	}
	
	public static void nCr(int idx, int N) {
		if(N == idx) {
			for(int i=0; i<go.length; i++) {
				System.out.print(go[i] + " ");
				
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<num.length; i++) {
			if(!flag[i]) {
				flag[i] = true;
				go[idx] = num[i];
				nCr(idx+1, N);
				flag[i] = false;
			}
		}
	}

}
