package D4;

import java.util.Arrays;
import java.util.Scanner;

public class D4_PokerGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int S = 0;
			int D = 0;
			int C = 0;
			int H = 0;
			int[] number = new int[14];
			
			for (int i = 0; i < 5; i++) {
				String str = sc.next();
				char st = str.charAt(0);
				char num = str.charAt(1);

				if (st == 'S') S++;
				else if (st == 'D') D++;
				else if (st == 'C') C++;
				else if (st == 'H') H++;
				
				if(num == 'A') number[1]++;
				else if(num == 'T') number[10]++;
				else if(num == 'J') number[11]++;
				else if(num == 'Q') number[12]++;
				else if(num == 'K') number[13]++;
				else number[num-'0']++;
				
			}
			int[] pair = new int[6];
			int startIdx = -1;
			for(int i=1; i<14; i++) {
				if(number[i]==1) {
					if(startIdx==-1) {
						startIdx = i;
						pair[1]++;
					} else if(startIdx!= -1 && number[i-1]==1) pair[1]++;
				}
				else if(number[i]==2) pair[2]++;
				else if(number[i]==3) pair[3]++;
				else if(number[i]==4) pair[4]++;
				else if(number[i]==5) pair[5]++;
			}
			if(S==5 || D==5 || C==5 || H ==5) {
				if(pair[1]==5) {
					System.out.println("#"+t + " Straight Flush");
				} else {
					System.out.println("#"+t + " Flush");
				}
			} else {
				if(pair[4]==1 || pair[5]==1) System.out.println("#"+t + " Four of a Kind");
				else if(pair[3]==1 && pair[2]==1) System.out.println("#"+t + " Full House");
				else if(pair[1]==5) System.out.println("#"+t + " Straight");
				else if(pair[3]==1) System.out.println("#"+t + " Three of a kind");
				else if(pair[2]==2) System.out.println("#"+t + " Two pair");
				else if(pair[2]==1) System.out.println("#"+t + " One pair");
				else System.out.println("#"+t + " High card");
			}
		}
	}
}
