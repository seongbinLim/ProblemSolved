package done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BackJoon2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int y = sc.nextInt();
		int x = sc.nextInt();
		
		ArrayList<Integer> xlist = new ArrayList<>();
		ArrayList<Integer> ylist = new ArrayList<>();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			if(a == 0) {
				xlist.add(sc.nextInt());
			} else {
				ylist.add(sc.nextInt());				
			}
		}
		xlist.add(x);
		ylist.add(y);
		Collections.sort(xlist);
		Collections.sort(ylist);

		int prvx = 0;
		int prvy = 0;
		int max = 0;
		for(int i=0; i<xlist.size(); i++) {
			for(int j=0; j<ylist.size(); j++) {
				//System.out.println(prvx +", " +prvy +":" + xlist.get(i) + ", " + ylist.get(j));
				int sum = (xlist.get(i)-prvx) * (ylist.get(j)-prvy);
				prvy = ylist.get(j);
				max = Math.max(max, sum);
			}
			prvx = xlist.get(i);
			prvy=0;
		}
		
		System.out.println(max);


	}

}
