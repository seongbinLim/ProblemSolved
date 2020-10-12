import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Programmers1_3 {
	public static void main(String args []) {
		//String[][] a = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}};
		//String[][] a = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		String[][] a = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
		solution(a);
	}
	
	public static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		for(int i=0; i<clothes.length; i++) {
			list.put(clothes[i][1], list.getOrDefault(clothes[i][1], 0)+1);
		}
		
		Iterator<String> keys = list.keySet().iterator();
		
		int data = 1;
		
		while ( keys.hasNext() ) {
			String key = keys.next();
			
			//answer = answer + list.get(key);
			data = data * (list.get(key)+1);
		}
		

		answer = data -1;
		
		System.out.println(answer);
		return answer;
	}
	
	public static int solution3(String[][] clothes) {
		int answer = 0;
		
		String[] list = new String[clothes.length];
		int[] count = new int[clothes.length];
		
		int idx = 0;
		int lastIdx = 1;
		
		list[0] = clothes[0][1];
		count[0]++;
		
		for(int i=1; i<clothes.length; i++) {
        	while( idx < lastIdx ) {
        		if(list[idx].equals(clothes[i][1])) {
        			count[idx]++;
        			idx = 0;
        			break;
        		}
    			idx++;
        	}
        	if(idx == lastIdx) {
        		list[idx] = clothes[i][1];
        		count[idx]++;
        		idx = 0;
        		lastIdx++;
        	}
		}
		
		if(lastIdx == 1)
			answer = count[idx];
		else {
			int data = 1;
			for(int i=0; i<lastIdx; i++) {
				answer = answer + count[i];
				data = data * count[i];
			}
			
			answer = answer + data;
		}
		System.out.println(answer);
		return answer;
	}
	
    public static int solution2(String[][] clothes) {
        int answer = 0;
        
        ArrayList<String> list[] = new ArrayList[1000];
        
        int idx = 0;
        int lastIdx = 1;
        
		list[idx] = new ArrayList<>();
		
		list[idx].add(clothes[0][1]);
		list[idx].add(clothes[0][0]);
		
        for(int i=1; i<clothes.length; i++) {
        	
        	while( idx < lastIdx ) {
        		if(list[idx].get(0).equals(clothes[i][1])) {
        			list[idx].add(clothes[i][0]);
        			idx = 0;
        			break;
        		}
    			idx++;
        	}
        	
        	if(idx == lastIdx) {
        		//System.out.println("idx : " + idx + " lastIdx : " + lastIdx);
        		//System.out.println("i : " + i + " clothes : " + clothes[i][0]);
        		list[idx] = new ArrayList<>();
        		list[idx].add(clothes[i][1]);
        		list[idx].add(clothes[i][0]);
        		idx = 0;
        		lastIdx++;
        	}
        }
        
        /*for(int i=0; i<lastIdx; i++) {
        	for(int j=0; j<list[i].size(); j++) {
        		System.out.print(list[i].get(j)+" ");
        	}
        	System.out.println();
        }*/
        int data = 0;
        if(lastIdx > 1) {
        	data = 1;
        	for(int i=0; i<lastIdx; i++) {
        		data = data * (list[i].size()-1);
        	}
        }
        answer = clothes.length + data;
        //System.out.println(data);
        System.out.println(answer);
        return answer;
    }
}
