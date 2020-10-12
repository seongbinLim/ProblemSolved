package D3;

import java.util.Scanner;

public class SwEx5356 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			char[][] input = new char[5][15];
			
			for(int i=0; i<5; i++) {
				String tmp = sc.next();
				for(int j=0; j<tmp.length(); j++) {
					input[i][j] = tmp.charAt(j);
				}
			}

			String ans = "";
			for(int i=0; i<15;i++) {
				for(int j=0; j<5; j++) {
					if(input[j][i]!='\u0000')
						ans += input[j][i];
				}
			}
			System.out.println("#"+test + " " + ans);
		}

	}

}
