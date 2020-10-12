import java.util.Arrays;

public class Programmers1_1 {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		boolean find = false;
		for(int i=0; i<completion.length; i++) {
			if(!completion[i].equals(participant[i])) {
				answer = participant[i];
				System.out.println(participant[i]+" "+ completion[i]);
				find = true;
				break;
			}
		}
		
		if(!find)
			answer = participant[participant.length-1];

		return answer;
	}
	
	public static void main(String args []) {
		//String[] a = {"leo", "kiki", "eden"};
		//String[] b = {"eden", "kiki"};
		
		//String[] a = {"marina", "josipa", "nikola", "vinko", "fillipa"};
		//String[] b = {"josipa", "fillipa", "marina", "nikola"};
		
		String[] a = {"mislav", "stanko", "mislav", "ana"};
		String[] b = {"stanko", "ana", "mislav"};
		
		solution(a,b);
	}
}
