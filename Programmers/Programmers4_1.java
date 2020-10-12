import java.util.Arrays;
import java.util.Comparator;


public class Programmers4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {6,10,2};
		//int[] a = {998,9,999};
		//int[] a = {0,0,70};
		//int[] a = {12,121};
		//int[] a = {21,212};
		//int[] a = {3,30,34,5,9};
		//int[] a = {0,0,0,1000};
		//int[] a = {0,0,1000,0};
		//int[] a = {1,11,110,1100};
		int[] a = {1,11,110,1102};
		solution(a);
	}
	
    public static String solution(int[] numbers) {
    	if(Arrays.stream(numbers).sum() == 0)
    		return "0";
    	
    	Integer[] arr = new Integer[numbers.length];
    	for(int i=0; i<numbers.length; i++) {
    		arr[i] = numbers[i];
    	}
    	
    	String answer = "";
    	Arrays.sort(arr, new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			String left = o1.toString();
    			String right = o2.toString();
    			return ((right+left)).compareTo(left+right);
    		}
    	});
    	
    	for(int i=0; i<arr.length; i++) {
    		answer += String.valueOf(arr[i]);
    	}

        //System.out.println(answer);
        return answer;
    }
}
