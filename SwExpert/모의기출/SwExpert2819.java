package 모의기출;
import java.util.Scanner;

public class SwExpert2819 {
	public static int [][] input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		input = new int[4][4];
		
		for(int i=0; i<testCase; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<4; k++) {
					input[j][k] = sc.nextInt();
				}
			}
		}
		
		for(int j=0; j<4; j++) {
			for(int k=0; k<4; k++) {
				calculate(j, k, 0);
			}
		}
	}	
	public static void calculate(int i, int j, int c) {
		if(c == 7) {
			return ;
		}
		
		
		
	}
	public static void output(int [] result) {
		for(int i =0; i<result.length; i++) {
			System.out.println("#" + (i+1) + " " + result[i]);
		}
	}

}
