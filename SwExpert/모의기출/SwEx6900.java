package 모의기출;
import java.util.Scanner;

public class SwEx6900 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test=1; test<=T; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String[] dangchum = new String[N];
			int[] money = new int[N];
			
			for(int i=0; i<N; i++) {
				dangchum[i] = sc.next();
				money[i] = sc.nextInt();
			}
			
			int total = 0;
			for(int i=0; i<M; i++) {
				String juheak = sc.next();
				for(int j=0; j<N; j++) {
					boolean ismatch = true;
					for(int k=0; k<8; k++) {
						char a = dangchum[j].charAt(k);
						if(a!='*' && a!=juheak.charAt(k)) {
							ismatch = false;
							break;
						}
					}
					if(ismatch) {
						total += money[j];
					}
				}
			}
			
			System.out.println("#"+test+" " + total);

		}

	}

}
