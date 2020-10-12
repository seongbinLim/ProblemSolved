import java.util.ArrayList;
import java.util.Arrays;

public class Programmers2_4 {

	public static void main(String[] args) {
		int[] p = {93, 30, 55};
		int[] s = {1, 30, 5};
		
		//int[] p = {40,93,30,55,60,65};
		//int[] s = {60,1,30,5,10,7};
		
		//int[] p = {93,30,55,60,40,65};
		//int[] s = {1,30,5,10,60,7};
		//solution(p, s);
		
		int[] a = {1,5,2,6,3,7,4};
		int[][] b = {{2,5,3}, {4,4,1}, {1,7,3}};
		
		solution2(a,b);
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int checkIdx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
        	double temp = (double)(100 - progresses[i]) / speeds[i];
        	progresses[i] = (int)Math.ceil(temp);
        }
        
        for(int i=0; i<progresses.length; i=i+checkIdx) {
        	int count = 1;
        	for(int j=i+1; j<progresses.length; j++) {
        		if(progresses[i] >= progresses[j]) {
        			count++;
        			if(j == progresses.length-1) {
        				list.add(count);
        				checkIdx = count;
        				break;
        			}
        		} else {
        			checkIdx = count;
        			list.add(count);
        			break;
        		}
        	}
    		if(i == progresses.length-1) {
    			list.add(count);
    		}
        }
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int s = commands[i][0]-1;
            int e = commands[i][1];
            int k = commands[i][2]-1;
           
            int[] list = new int[e-s];
            int idx = 0;
            for(int j=s; j<e; j++) {
                list[idx++] = array[j];
            }
            
            Arrays.sort(list);
            
            answer[i] = list[k];
            
        }
        
        return answer;
    }
    
}
