package done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon12851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] v = new int[100001];
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		int time = 0;
		int size = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while(!q.isEmpty()) {
			if(size == 0) {
				size = q.size();
				time++;
			}
			
			int p = q.poll();
			v[p] = 1;
			size--;
			
			if(p == K) {
				min = Math.min(min, time);
				if(min == time) cnt++;
				
			}
			
			
			if(p+1 > -1 && p+1 < 100001 && v[p+1]==0) q.add(p+1);
			if(p-1 > -1 && p-1 < 100001 && v[p-1]==0) q.add(p-1);
			if(p*2 > -1 && p*2 < 100001 && v[p*2]==0) q.add(p*2);
			
		}
		System.out.println(min);
		System.out.println(cnt);
		
	}

}
