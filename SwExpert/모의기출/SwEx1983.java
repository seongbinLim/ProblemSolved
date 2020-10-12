package 모의기출;
import java.util.Scanner;

public class SwEx1983 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int want = sc.nextInt();
			
			double[] score = new double[N];
			String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			for(int i=0; i<N; i++) {
				int mid = sc.nextInt();
				int exam = sc.nextInt();
				int hw = sc.nextInt();
				
				score[i] = mid*0.35 + exam*0.45 + hw*0.2;
			}
			
			double jumsu = score[want-1];
			int count = 0;
			for(int i=0; i<N; i++) {
				if(score[i] > jumsu) {
					count++;
				}
			}
			
			count = count/(N/10);
			
			System.out.println("#" + test + " " + grade[count]);
		}

	}

}
