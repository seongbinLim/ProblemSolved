package 모의기출;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 정올_냉장고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] ondo = new int[N][2];
		for (int i = 0; i < N; i++) {
			ondo[i][0] = sc.nextInt();
			ondo[i][1] = sc.nextInt();
		}
		Arrays.sort(ondo, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] <= b[0] ? -1 : 1;
			}
		});

		for(int i=0; i<ondo.length; i++) {
			//System.out.println(ondo[i][0] + "," + ondo[i][1]);
		}
		
		int count = 1;
		int min = ondo[0][1];
		
		for(int i=1; i<ondo.length; i++) {
			if(ondo[i][0] <= min) {
				if(ondo[i][1] < min) {
					//count++;
					min = ondo[i][1];
				}
			} else {
				count++;
				min = ondo[i][1];
			}
		}
		
		System.out.println(count);

	}

}
