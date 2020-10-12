package D4;

import java.util.Scanner;

public class D4_극한의청소작업 {

	public static void main(String[] args) {
		fourFloor(44);
		/*
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			long start = sc.nextLong();
			long end = sc.nextLong();
			long ans = 0;
			int four = 0;
			
			if(start > end) {
				long temp = start;
				start = end;
				end = temp;
			}
			
			if(end < 0 && start > 0) {
				four = count(start, end);
				ans = end - start - four -1;
			} else {
				four = count(start, end);
				ans = end - start - four;
			}
			System.out.println("#"+" "+ans);
		}
		*/
	}
	static int count(long start, long end) {
		int count = 0;
		if(end < 0 && start < 0) {
			//0~end 4의 갯수 - 0~start 4의 갯수
			end = end*(-1);
			start = start*(-1);

			
		} else if(end < 0 && start > 0) {
			//0~end 4의 갯수 + 0~start 4의 갯수
			end = end*(-1);
		
		
		} else {
			//0~start 4의 갯수 - 0~end 4의 갯수

		}
		
		return count;
	}
	
	static long fourFloor(int N) {
		long digit = 1;
		long ret = 0;
		
		while(N>0) {
			int remain = N%10;
			ret += (long) Math.pow(10, digit-1);
			
			
			if(digit > 1 && remain > 4) {
				ret += (remain-1)*(digit-1);
			} else if(digit > 1 && remain < 4) {
				ret += (remain)*(digit-1);
			}
			digit++;
			N = N/10;
			System.out.println(ret);
		}
		
		return ret;
	}
}
