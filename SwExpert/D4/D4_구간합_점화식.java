package D4;

import java.util.HashMap;
import java.util.Scanner;

public class D4_구간합_점화식 {
	static int T;
	static long A,B;
	static HashMap<Long, Long> m = new HashMap<Long, Long>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			A = sc.nextLong();
			B = sc.nextLong();
			setting();
			long result = cal(B, A);
			
			System.out.println("#" + t + " " + result);
		}
	}
	static void setting() {
		m.put(0L, 0L);
		m.put(1L, 1L);
		m.put(2L, 3L);
		m.put(3L, 6L);
		m.put(4L, 10L);
		m.put(5L, 15L);
		m.put(6L, 21L);
		m.put(7L, 28L);
		m.put(8L, 36L);
		m.put(9L, 45L);
		
		long b = 1;
		long point = 1;
		long fin = 11111111111111L;
		while(b <= fin) {
			point *= 10;
			b += point;
			long value = point * (b+"").length();
			
			//System.out.println(b*9 + ", " + value);
			m.put(b*9L, m.get(9L)*value);
		}
		//System.out.println("fin");
	}
	static long cal(long b, long a) {
		if(a<=1) {
			return f(b);
		} else if(a==b){
			return f(b)-f(a-1);
		} else {
			return f(b)-f(a-1);
		}
	}
	static long f(long n) {
		if(m.containsKey(n)) return m.get(n);
		
		long v = (long) Math.pow(10, (n+"").length()-1);
		m.put(n, f(n-1L-n%v) + g(n));
		
		return m.get(n);
	}
	
	static long g(long n) {
		long v = (long) Math.pow(10, (n+"").length()-1);
		return (n/v)*(n%v+1L) + f(n%v);
	}
}
