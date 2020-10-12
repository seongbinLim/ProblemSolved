package 모의기출;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] r = new int[tc];
		
		for(int i=0; i<tc; i++) {
			sc.nextInt();
			sc.nextLine();
			
			String tmp = sc.nextLine();
			
			String[] a = tmp.split(" ");
			int[] b = new int[a.length];

			for(int j=0; j<a.length; j++) {
				b[j] = Integer.parseInt(a[j]);
			}
		
			Arrays.sort(b);
			
			int count = 1;
			ArrayList<Integer> list = new ArrayList<>();
			int maxNum = -1;
			int maxCount = 0;
			for(int j=1; j<b.length; j++) {
				if(b[j] != b[j-1]) {
					list.add(count);
					if(maxCount <= count) {
						maxCount = count;
						maxNum = b[j-1];
					}
					count = 1;
				} else {
					count++;
				}
			}
			r[i] = maxNum;
		}
		
		for(int i=0; i<tc; i++) {
			System.out.println("#"+(i+1) + " " + r[i]);
		}
	}

}
