package done;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon2096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[3];
		int[] min = new int[3];
		int[] max = new int[3];
		
		min[0] = sc.nextInt();
		min[1] = sc.nextInt();
		min[2] = sc.nextInt();
		max[0] = min[0];max[1] = min[1];max[2] = min[2];
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				arr[j] = sc.nextInt();
			}
			int minA = Math.min(min[0], min[1]);
			int minB = Math.min(min[1], min[2]);
			min[0] = arr[0]+minA;
			min[2] = arr[2]+minB;
			min[1] = arr[1]+Math.min(minA, minB);
			
			int maxA = Math.max(max[0], max[1]);
			int maxB = Math.max(max[1], max[2]);
			max[0] = arr[0]+maxA;
			max[2] = arr[2]+maxB;
			max[1] = arr[1]+Math.max(maxA, maxB);
			
			System.out.println(Arrays.toString(min));
		}
		
		int fMax = Math.max(Math.max(max[0], max[1]),max[2]);
		int fMin = Math.min(Math.min(min[0], min[1]),min[2]);
		
		System.out.println(fMax + " " + fMin);

	}

}
