import java.util.ArrayList;

public class Programmers2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1,3,2};
		int b = 2;
		
		//int[] a = {1,1,9,1,1,1};
		//int b = 0;
		solution(a,b);
		
	}
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int key : priorities) {
        	list.add(key);
        }
        
        int lastIdx = priorities.length;
        
        while(list.size() > 0) {
        	int maxP = list.get(0);
            int idx = -1;
        	for(int i=0; i<lastIdx; i++) {
        		if(list.get(i) >  maxP) {
        			idx = i;
        			maxP = list.get(i);
        		}
        	}
        	
        	if(idx != -1) {
        		if(location-idx < 0) {
        			location = location + list.size() - idx;
        		} else if(location-idx > 0) {
        			location = location - idx;
        		} else {
        			location = 0;
        		}
        		
        		ArrayList<Integer> newList = new ArrayList<>();
        	
        		for(int i=idx; i<lastIdx; i++) {
        			newList.add(list.get(i));
        		}
        		for(int i=0; i<idx;i++) {
        			newList.add(list.get(i));
        		}
        	
        		list.clear();
        		list = (ArrayList<Integer>) newList.clone();
        	}

        	if(location == 0) {
        		break;
        	} else {
        		answer++;
        	}
        	lastIdx--;
        	list.remove(0);
        	location--;        	
        }
        
        System.out.println(answer);
        return answer;
    }
}
