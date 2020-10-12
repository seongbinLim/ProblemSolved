package 모의기출;
import java.util.Scanner;

public class SwEx1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			
			int[] price = new int[N];
			
			for(int i=0; i<N; i++) {
				price[i] = sc.nextInt();
			}
			
			long total = 0;
			int count = 0;
			for(int i=0; i<N; i++) {
				boolean flag = false;
				for(int j=i+1; j<N; j++) {
					if(price[i] < price[j]) {
						flag = true;
						break;
					}
				}
				if(flag) {
					total -= price[i];
					count++;
				} else {
					if(count>0) {
						total += price[i]*count;
						count = 0;
					}
				}
			}
			System.out.println("#" + test + " " + total);
		}

	}

}
