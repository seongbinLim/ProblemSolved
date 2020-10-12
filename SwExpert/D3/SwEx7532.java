package D3;

import java.util.Scanner;

public class SwEx7532 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			int M = sc.nextInt();
			
			int s = 1;
			int e = 1;
			int m = 1;
			
			int ad = 1;
			
			while(!(S==s && E==e && M==m)) {
				if(s == 365) {
					s=1;
				} else {
					s++;
				}
				if(e == 24) {
					e=1;
				} else {
					e++;
				}
				if(m == 29) {
					m=1;
				} else {
					m++;
				}
				
				ad++;
			}
			
			System.out.println("#" + test + " " + ad);
		}
	}

}
