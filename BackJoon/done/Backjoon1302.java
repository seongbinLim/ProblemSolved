package newVersion;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Backjoon1302 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();sc.nextLine();
		
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String input = sc.nextLine();
			map.put(input, map.getOrDefault(input, 0)+1);
		}

		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(map.get(o1) == map.get(o2)) return o1.compareTo(o2);
				return Integer.compare(map.get(o2), map.get(o1));
			}
		});
		
		for(String key : map.keySet()) {
			pq.add(key);
		}
		
		System.out.println(pq.poll());
	}

}
