package 모의기출;
import java.util.Scanner;

public class 주혁이의복권당첨 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			String[] winNum = new String[N];
			int[] winMoney = new int[N];

			for (int i = 0; i < N; i++) {
				winNum[i] = sc.next();
				winMoney[i] = sc.nextInt();
			}

			String[] juhyuk = new String[M];
			for (int i = 0; i < M; i++) {
				juhyuk[i] = sc.next();
			}

			boolean winArr[] = new boolean[N];
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int count = 0;
					for (int k = 0; k < 8; k++) {

						if (winNum[i].charAt(k) == juhyuk[j].charAt(k) || winNum[i].charAt(k) == '*') {
							winArr[i] = true;
						}
						else if (winNum[i].charAt(k) != juhyuk[j].charAt(k)) {
							winArr[i] = false;
							break;
						}
					}
					if (winArr[i]) {
						sum += winMoney[i];
						//break;

					}
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
