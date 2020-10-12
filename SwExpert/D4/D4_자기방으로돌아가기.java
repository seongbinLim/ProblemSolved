package D4;
import java.util.Arrays;
import java.util.Scanner;

public class D4_자기방으로돌아가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] state = new int[401];

			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if (start > end) {
					int tmp = end;
					end = start;
					start = tmp;
				}

				if(start%2==1) start++;
				if(end%2==1) start++;
				for (int j = start; j <= end; j++) {
					state[j]++;	
				}
			}

			Arrays.sort(state);

			System.out.println("#" + t + " " + state[400]);
		}
	}
}
