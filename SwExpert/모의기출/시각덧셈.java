package 모의기출;
import java.util.Scanner;

public class 시각덧셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int testcase = 1; testcase<=tc; testcase++) {
			int firstT = sc.nextInt();
			int firstM = sc.nextInt();
			
			int secondT = sc.nextInt();
			int secondM = sc.nextInt();
			
			int sumT = firstT + secondT;
			int sumM = firstM + secondM;
			
			if(sumM >= 60) {
				sumT++;
				sumM -= 60;
			}
			
			if(sumT > 12 && sumT < 25) {
				sumT = sumT - 12;
			}
			
			if(sumT > 25) {
				sumT = sumT%12;
			}
			
			System.out.println("#" + testcase + " " + sumT + " " + sumM);
		}

	}

}
