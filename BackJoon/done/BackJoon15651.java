package done;
import java.util.Scanner;

public class BackJoon15651 {

	static int[] arr;
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N];
		sel = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		perm(0, M);
	}
	
	static void perm(int idx, int M) {
		if(idx == M) {
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
				
		for(int i=0; i<arr.length; i++) {
			sel[idx] = arr[i];
			perm(idx+1, M);
		}
	}
}
