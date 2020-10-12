package 모의기출;
import java.util.Arrays;
import java.util.Scanner;

public class SwEx1984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int[] num = new int[10];
			
			for(int i=0; i<10; i++) {
				num[i] = sc.nextInt();
			}
			
			Arrays.sort(num);

			double total = 0;
			for(int i=1; i<9; i++) {
				total += num[i];
			}

			System.out.println("#"+test+" "+ Math.round(total/8));
		}

	}

}
