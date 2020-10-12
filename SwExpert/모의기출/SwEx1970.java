package 모의기출;
import java.util.Scanner;

public class SwEx1970 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int money = sc.nextInt();
			int[] don = {50000,10000,5000,1000,500,100,50,10};
			int[] count = new int[8];
			
			String ans = "";
			for(int i=0; i<don.length; i++) {
				if(money >= don[i]) {
					count[i] = money/don[i];
					//System.out.println(don[i]);
					money = money%(count[i]*don[i]);
				}
				ans += count[i] + " ";
			}
			 
			System.out.println("#"+test);
			System.out.println(ans);
			
		}
		
	}

}
