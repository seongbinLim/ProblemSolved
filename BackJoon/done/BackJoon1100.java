package done;
import java.util.Scanner;

public class BackJoon1100 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int check = -1;
		int count = 0;
		for(int i=0; i<8; i++) {
			check = i%2;
			String input = sc.next();
			for(int j=0; j<8; j++) {
				if(check%2==0 && input.charAt(j)=='F') {
					count++;
				}
				check++;
			}
		}
		
		System.out.println(count);
		

	}

}
