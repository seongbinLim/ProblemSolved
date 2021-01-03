package newVersion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int find = Integer.parseInt(st.nextToken());
			binarySearch(num, find, 0, N-1);
		}
	}
	public static void binarySearch(int[] num, int target, int s, int e) {
		if(s>e) {
			System.out.println(0);
			return;
		}
		
		int mid = (s+e)/2;
		if(num[mid]==target) {
			System.out.println(1);
			return;
		} else if(num[mid]>target) {
			binarySearch(num, target, s, mid-1);
		} else {
			binarySearch(num, target, mid+1, e);
		}
	}
}
