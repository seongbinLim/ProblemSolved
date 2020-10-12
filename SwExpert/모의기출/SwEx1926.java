package 모의기출;
import java.util.Scanner;

public class SwEx1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		for(int i=1; i<=N; i++) {
			String num = i+"";
			if(num.contains("3") || num.contains("6") || num.contains("9")) {
				int count = 0;
				for(int j=0; j<num.length(); j++) {
					if(num.charAt(j) == '3') {
						count++;
					}
					if(num.charAt(j) == '6') {
						count++;
					}
					if(num.charAt(j) == '9') {
						count++;
					}
				}
				
				for(int j=0; j<count; j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			} else {
				System.out.print(num + " ");
			}
				
		}
	}

}
