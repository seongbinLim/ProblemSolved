import java.util.Arrays;

public class Programmers4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {3,0,6,1,5};
		int[] a = {1,2,3,3,3,3,4,4,5,6,7,7,8,9,9,10,10,10};
		//int[] a = {7};
		solution(a);
	}
    public static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int[] arr = new int[citations.length];

        for(int i=0; i<citations.length; i++) {
        	arr[i] = citations.length - i;
        	
        }
        
        int maxH = citations[citations.length-1];
        int idx = 0;
        while(idx <= maxH) {
        	for(int i=0; i<citations.length; i++) {
            	if(idx <= citations[i]) {
            		if(idx <= arr[i]) {
            			answer = idx;
            		} else {
            			break;
            		}
            	}
        	}
        	idx++;
        
        }
        //System.out.println(answer);
        
        return answer;
    }
}
