package done;
import java.util.Scanner;

public class BackJoon2138 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		String origin = sc.next();
		String ans = sc.next();
		pushSwitch(ans, origin);
	}
	public static char change(char a) {
		if( a == '0') 
			return '1';		
		return '0';
	}
	public static void pushSwitch(String ans, String origin) {
		char[] s = origin.toCharArray();
		int changeCount = -1;
		int count = 0;
		
		for(int k=0; k<2; k++) {
			for(int i=1; i<s.length; i++) {
				if(s[i-1] != ans.charAt(i-1)) {
					s[i-1] = change(s[i-1]);
					s[i] = change(s[i]);										
					if(i < s.length-1) {
						s[i+1] = change(s[i+1]);
					}					
					count++;
				} 
			}
			
			if(ans.equals(String.valueOf(s))) {
				if(changeCount == -1 || changeCount > count) {
					changeCount = count;
				}
			}
			
			s = origin.toCharArray();
			s[0] = change(s[0]);
			s[1] = change(s[1]);
			count = 1;
		}
				
		System.out.println(changeCount);
	}
}
