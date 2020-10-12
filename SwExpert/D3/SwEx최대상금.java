package D3;

import java.util.Arrays;
import java.util.Scanner;

public class SwEx최대상금 {
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int input = sc.nextInt();
			int change = sc.nextInt();

			String str = input + "";
			num = new int[str.length()];

			for (int i = 0; i < str.length(); i++) {
				num[i] = str.charAt(i) - '0';
			}
			
			int idx = 0;
			int remain = 0;
			for (int i = 0; i < change; i++) {

				if(idx >= num.length) {
					idx = num.length-2;
				}
				int maxIdx = idx;
				int max = num[idx];
				
				for (int j = idx + 1; j < num.length; j++) {
					if (max <= num[j]) {
						max = num[j];
						maxIdx = j;
					}
				}
				if (idx != maxIdx) {
					swap(idx, maxIdx);
					remain++;
				} else if(idx == maxIdx && change < num.length-1){
					i--;
				} else {
					if(remain < num.length-1 ) {
						remain++;
						i--;
					} else {
						if(num[num.length-2] != num[num.length-3]) {
							swap(num.length-2, num.length-1);
						}
					}
				}
				
				if(idx > 0 && num[idx] == num[idx-1]) {
					for(int m=maxIdx; m<maxIdx+idx; m++) {
						if(m < num.length-1 && num[m] < num[m+1]) {
						
							swap(m,m+1);
						}
					}
				}
				
				
				idx++;

			}
			
			StringBuilder sb = new StringBuilder();
			for(int n : num) {
				sb.append(n);
			}
			
			System.out.println("#"+t+" "+sb.toString());

		}

	}

	static void swap(int a, int b) {
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}

}
