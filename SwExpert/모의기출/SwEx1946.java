package 모의기출;
import java.util.Arrays;
import java.util.Scanner;

public class SwEx1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			char[] alph = new char[N];
			int total = 0;
			for(int i=0; i<N; i++) {
				alph[i] = sc.next().charAt(0);
				num[i] = sc.nextInt();
				total += num[i];
			}
			
			//System.out.println(Arrays.toString(num));
			
			System.out.println("#"+test);
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<num[i]; j++) {
					if(count > 0 && count%10 == 0) {
						System.out.println();
					}
					System.out.print(alph[i]);
					count++;
				}
			}
			System.out.println();
		}
	}

}
