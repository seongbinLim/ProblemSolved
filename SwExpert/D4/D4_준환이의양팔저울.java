package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D4_준환이의양팔저울 {
	static int result;
	static int N;
	static int[] chu;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			chu = new int[N];
			int total = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				total += chu[i];
			}
			result = 0;
			arr = new int[N];
			isSelected = new boolean[N];
			perm(0);
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}
	static int[] arr;
	static boolean[] isSelected;
	private static void perm(int cnt) { //순열
		if(cnt==N) {
			//System.out.println(Arrays.toString(arr));
			power(0,0,0);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				arr[cnt] = chu[i];
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	
	private static void power(int idx, int left, int right) {
		if(left < right) return;
		if(idx==N) {
			result++;
			return;
		}
		power(idx+1, left+arr[idx], right);
		power(idx+1, left, right+arr[idx]);
	}
}
