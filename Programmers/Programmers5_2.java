import java.util.ArrayList;
import java.util.HashSet;

public class Programmers5_2 {
	static HashSet <Integer> num = new HashSet<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("17");
		//solution("011");
	}
    public static int solution(String numbers) {
        int answer = 0;
        int lastIndex = numbers.length();
        int[] arr = new int[lastIndex];
        
        for(int i=0; i<lastIndex; i++) {
        	arr[i] = Character.getNumericValue(numbers.charAt(i));
        }
        
        for(int i=1; i<=lastIndex; i++) {
        	permutation(arr,new int[lastIndex],i,0);
        }
        
        
        ArrayList<Integer> arr2 = new ArrayList<Integer>(num);
        
        for(int i=0; i<arr2.size(); i++) {
        	boolean isPrime = true;
        	if(arr2.get(i) == 1 || arr2.get(i) == 0)
        		isPrime = false;
        		
        	for(int j=2; j<arr2.get(i); j++) {
        		if(arr2.get(i)%j==0) {
        			isPrime = false;
        			break;
        		}
        	}
        	if(isPrime) {
        		System.out.println(arr2.get(i));
        		answer++;
        	}
        }
       
        return answer;
    }
    
    public static void permutation(int[] arr, int[] check, int n, int idx) {
    	if(idx == n) {
    		String newNumber = "";
    		for(int i=0; i<n; i++) {
    			//System.out.print(arr[check[i]] + " ");
    			newNumber = newNumber + arr[check[i]];
    		}
    		//System.out.println(newNumber);
    		num.add(Integer.parseInt(newNumber));
    		
    		return;
    	}
    	
    	for(int i=0; i<arr.length; i++) {
    		boolean alreadyVisited = false;
    		//if check[] 에 겹치는 i 가 있는 경우는 pass
    		for(int j=0; j<idx; j++) {
    			if(check[j] == i)
    				alreadyVisited = true;
    		}
    		if(!alreadyVisited) {
    			//System.out.println(idx + ", " + i);
    			check[idx] = i;
    			permutation(arr, check, n, idx+1);
    		}
    		
    	}

    }
    
}
