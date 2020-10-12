package D4;

import java.util.Arrays;
import java.util.Scanner;

public class D4_달리기 {
	
	
	public static void main(String[] args) {
		int start = 10000;
		int end = 99999;
		int count = 0;
		for(int i=start; i<=end; i++) {
			if((i+"").contains("4")) count++;
		}
		
		System.out.println(count);
		//Setting();
		getFloor(45);

	}
	static long[] floor = new long[13];
    static void Setting() {
        long num = 1;
        floor[1] = 1;
        for (int i = 2; i <= 12; i++) {
            num *= 9;
            num += Math.pow(10, i - 1);
            floor[i] = num;
        }
        
        System.out.println(Arrays.toString(floor));
    }
    
    static long getFloor(long N) {
        long ret = 0;
        int step = 0;
        while (N > 0) {
            long x = N % 10;
            System.out.println(x + " : x");
            if (x > 4)
                x--;
            for (int i = 0; i < step; i++)
                x *= 9;
            ret += x;
            N /= 10;
            step++;
            System.out.println(ret);
        }
        return ret;
    }
}
