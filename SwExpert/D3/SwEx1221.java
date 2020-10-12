package D3;

import java.util.Scanner;

public class SwEx1221 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			String[] alph = {"ZRO","ONE","TWO","THR","FOR","FIV","SIX","SVN","EGT","NIN"};
			sc.next();
			String input = sc.next();
			//System.out.println(input);
			int N = Integer.parseInt(input);
			int[] num = new int[10];
			for(int i=0; i<N; i++) {
				String tmp = sc.next();
				//System.out.println(tmp);
				for(int j=0; j<10; j++) {
					if(tmp.equals(alph[j])) {
						num[j]++;
						break;
					}
				}
			}
			
			System.out.println("#"+test);
			for(int i=0; i<10; i++) {
				for(int j=0; j<num[i]; j++) {
					System.out.print(alph[i] + " ");
				}
			}
			System.out.println();
		}

	}

}
