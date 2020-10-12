package done;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[9];
		arr = new int[7];
		ans = new int[7];
		for(int i=0; i<9; i++)
			input[i] = sc.nextInt();
		
		pick(0,0,0);
		
		for(int i=0; i<7; i++)
			System.out.println(ans[i]);
	}
	static int[] input;
	static int[] arr;
	static int[] ans;
	static void pick(int idx, int cnt, int sum) {
		if(sum > 100) return;

		if(idx >= 7) {
			if(sum == 100) {
				ans = arr.clone();
				Arrays.sort(ans);
				return;
			}
			return;
		}
		
		if(cnt>=9) return;
		
		for(int i=cnt; i<9; i++) {
			arr[idx] = input[i];
			pick( idx+1, i+1, sum + arr[idx] );
			arr[idx] = -1;
		}
	}
}
