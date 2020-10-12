package 모의기출;
import java.util.Scanner;

public class SwEx1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test=1; test<=tc; test++) {
			sc.nextInt();
			int[] digit = new int[101];
			for(int i=0; i<1000; i++) {
				int num = sc.nextInt();
				digit[num]++;
			}
			
			int max = 0;
			int maxIdx = 0;
			for(int i=100; i>-1; i--) {
				if(max < digit[i]) {
					max = digit[i];
					maxIdx = i;
				}
			}
			
			System.out.println("#" + test + " " + maxIdx);
			
			
		}
	}

}
