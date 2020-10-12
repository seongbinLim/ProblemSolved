import java.util.Arrays;

public class Programmers6_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a = {70,80,50};
		int b = 100;

		solution(a,b);
	}
	
    public static int solution(int[] people, int limit) {
        int answer = 0;
        
        boolean[] visited = new boolean[people.length];
        Arrays.sort(people);
        
        int left = 0, right = people.length-1;
        
        while(left <= right) {
        	if(left == right && !visited[left]) {
        		answer++;
        		visited[left] = true;
        		break;
        	}
        	if(!visited[right]) {
        		if(people[left] + people[right] <= limit) {
        			answer++;
                	visited[left] = true;
        			visited[right] = true;
        			right--;
        			left++;
        		} else {
        			visited[right] = true;
        			answer++;
        			right--;
        		}
        	}
        	System.out.println(left + ", " + right + " : " + answer);
        }
        return answer;
    }
}
