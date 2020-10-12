package D4;

import java.util.Scanner;

public class D4_구간합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			long start = sc.nextInt();
			long end = sc.nextInt();
			long[] ans = new long[10];
			long point = 1;
			while(start<=end) {
				while(end%10!=9&& start<=end) {
					cal(end, ans, point);
					end--;
				}
				if(end<start) {
					break;
				}
				while(start % 10 !=0 && start <= end ) {
					cal(start, ans, point);
					start++;
				}
				
				start/=10;
				end/=10;
				for(int i=0; i<ans.length; i++) {
					ans[i]+=(end-start+1)*point;
				}
				System.out.println(point);
				point*=10;
			}
			long sum=0;
			for(int i=0; i<10; i++) {
				sum+=(ans[i]*i);
			}
			System.out.println("#"+t+" "+sum);
		}

	}

	private static void cal(long x, long[] ans, long point) {
		//자리수 구하기
		while(x>0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length()-1)-'0';
			ans[xx] += point;
			x /= 10;
		}
		
	}

}
