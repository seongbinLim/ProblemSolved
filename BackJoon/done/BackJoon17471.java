package done;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon17471 {
	static class Dist {
		int population;
		ArrayList<Integer> list = new ArrayList<>();
	}
	static int district;
	static Dist[] d;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		district = sc.nextInt()+1;
		d = new Dist[district];
		
		for(int i=1; i<district; i++) {
			d[i] = new Dist();
			d[i].population = sc.nextInt();
		}
		
		for(int i=1; i<district; i++) {
			int num = sc.nextInt();
			for(int j=0; j<num; j++) {
				d[i].list.add(sc.nextInt());
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i=1; i<district-1; i++) {
			comb(new int[i], 0, 1);
			//System.out.println("-------------------");
		}
		//for(int i=1; i<district; i++) {
		//	System.out.println( i + " : " + d[i].population + " " + d[i].list.toString());
		//}
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	//구역으로 만들 수 있는 모든 조합의 수
	static void comb(int[] arr, int s_idx, int idx) {
		if(s_idx == arr.length) {
			//System.out.println(Arrays.toString(arr));

			int[] arr2 = new int[district-1-arr.length];
			boolean[] list = new boolean[district];
			for(int j=0; j<arr.length; j++) {
				list[arr[j]] = true;
			}
			int index = 0;
			for(int i=1; i<list.length; i++) {
				if(!list[i]) {
					arr2[index++] = i;
				}
			}
			
			boolean result = isConnected(arr, arr2);
			if(result) {
				min = Math.min(min, sumOfPopulation(arr, arr2));
			}
			
			//return 값이 true 이면 인구 수 차이 확인
			//인구수 차이 값 받아서 min 값과 비교
			return;
		}
		if(idx == district) return;
		arr[s_idx] = idx;
		comb(arr,s_idx+1, idx+1);
		comb(arr,s_idx, idx+1);
	}
	
	static boolean isConnected(int[] distA, int[]distB) {
		if(distA.length > 1) {
			boolean[] v = new boolean[district];
			v[0] = true;
			for(int i=0; i<distB.length; i++) {
				v[distB[i]] = true;
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(distA[0]);
			while(!q.isEmpty()) {
				int index = q.poll();
				v[index] = true;
				for(int i=0; i<d[index].list.size(); i++) {
					int data = d[index].list.get(i);
					if(!v[data]) {
						q.add(data);
					}
				}
			}
			
			for(int i=1; i<v.length; i++) {
				if(!v[i]) {
					return false;
				}		
			}
		}
		
		if(distB.length > 1) {
			boolean[] v = new boolean[district];
			v[0] = true;
			for(int i=0; i<distA.length; i++) {
				v[distA[i]] = true;
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(distB[0]);
			while(!q.isEmpty()) {
				int index = q.poll();
				v[index] = true;
				for(int i=0; i<d[index].list.size(); i++) {
					int data = d[index].list.get(i);
					if(!v[data]) {
						q.add(data);
					} 
				}
			}
			
			for(int i=0; i<v.length; i++) {
				if(!v[i]) {
					return false;
				}		
			}
		}
		
		return true;
		
	}
	
	static int sumOfPopulation(int[] distA, int[] distB) {
		int totalA = 0;
		int totalB = 0;
		
		for(int i=0; i<distA.length; i++) {
			totalA += d[distA[i]].population;
		}
		
		for(int i=0; i<distB.length; i++) {
			totalB += d[distB[i]].population;
		}
		return Math.abs(totalA-totalB);
	}
	
	

}
