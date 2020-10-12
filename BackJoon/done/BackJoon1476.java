package done;

import java.util.Scanner;

public class BackJoon1476 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int year = 1;
		
		while(!((year-E)%15==0 && (year-S)%28==0 && (year-M)%19==0)) {
			year++;
		}

		System.out.println(year);
	}

}
