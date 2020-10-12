package D4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D4_스타일리쉬들여쓰기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();sc.nextLine();
			
			String[] master = new String[p];
			String[] me = new String[q];
			
			for(int i=0; i<p; i++) {
				master[i] = sc.nextLine();
			}
			for(int i=0; i<q; i++) {
				me[i] = sc.nextLine();
			}	
			//find RCS
			findRCS(master);

			//adapt RCS to my code
			int[] result = adaptRCS(me);
			
			System.out.print("#"+t+" ");
			for(int value : result)
				System.out.print(value + " ");
			System.out.println();
		}
	}
	static ArrayList<Integer> possibleR = new ArrayList<>();		
	static ArrayList<Integer> possibleC = new ArrayList<>();		
	static ArrayList<Integer> possibleS = new ArrayList<>();
	static int[] number = new int[3];
	static boolean[] index;
	
	static void rePerm(int end, int cnt, int[] R, int[] C, int[] S) {
		if(cnt==3) {
			int value = number[0]*(R[0]-R[1]) + number[1]*(C[0]-C[1]) + number[2]*(S[0]-S[1]);
			if(value == end) {
				//System.out.println(value + ":" + Arrays.toString(number));
				possibleR.add(number[0]);
				possibleC.add(number[1]);
				possibleS.add(number[2]);
			}
			return;
		}
		
		for(int i=1; i<=20; i++) {
			number[cnt] = i;
			rePerm(end, cnt+1, R, C, S);
		}
	}

	static boolean isPossible(int dot, int idx, int[] R, int[] C, int[] S) {
		int value = possibleR.get(idx)*(R[0]-R[1]) + possibleC.get(idx)*(C[0]-C[1]) + possibleS.get(idx)*(S[0]-S[1]);
		if(value==dot) return true;
		return false;
	}
	static void findRCS(String[] master) {		
		int[] R = new int[2];
		int[] C = new int[2];
		int[] S = new int[2];
		
		for(int i=0; i<master[0].length(); i++) {
			if(master[0].charAt(i)=='(') R[0]++;
			if(master[0].charAt(i)==')') R[1]++;
			if(master[0].charAt(i)=='{') C[0]++;
			if(master[0].charAt(i)=='}') C[1]++;
			if(master[0].charAt(i)=='[') S[0]++;
			if(master[0].charAt(i)==']') S[1]++;
		}
		
		int dot = 0;
		if(master.length>1) {
			for(int i=0; i<master[1].length(); i++) {
				if(master[1].charAt(i)=='.') dot++;
				else break;
			}
		}
		
		rePerm(dot, 0, R, C, S);
		index = new boolean[possibleR.size()];
		Arrays.fill(index, true);
		
		for(int i=1; i<master.length; i++) {
			dot=0;
			boolean check = false;
			for(int j=0; j<master[i].length(); j++) {
				if(master[i].charAt(j)=='.') {
					if(j==0) dot++;
					else if(j>0 && master[i].charAt(j-1)=='.') dot++;
				} else {
					if(!check) {
						check = true;
						//System.out.println("R"+R[0] +"," + R[1]);
						//System.out.println("C"+C[0] +"," + C[1]);
						//System.out.println("S"+S[0] +"," + S[1]);
						for(int idx=0; idx<possibleR.size(); idx++) {
							if(index[idx] && !isPossible(dot, idx, R, C, S)) {
								index[idx] = false;
							}
						}
						//System.out.println(possibleC.size() + " : " + dot);
						//for(int k=0; k<index.length; k++) {
						//	if(index[k])
						//		System.out.print(possibleC.get(k) + " ");
						//}
						//System.out.println();
					}
					if(master[i].charAt(j)=='(') R[0]++;
					else if(master[i].charAt(j)==')') R[1]++;
					else if(master[i].charAt(j)=='{') C[0]++;
					else if(master[i].charAt(j)=='}') C[1]++;
					else if(master[i].charAt(j)=='[') S[0]++;
					else if(master[i].charAt(j)==']') S[1]++;
				}
			}
		}
		
		//for(int k=0; k<index.length; k++) {
		//	if(index[k])
		//		System.out.print(possibleR.get(k) + " " + possibleC.get(k) + " " + possibleS.get(k) + " ");
		//}
		//System.out.println("-----------");
	}
	static int isUnique(int[] R, int[] C, int[] S) {
		int value = -1;
		
		for(int i=0; i<index.length; i++) {
			if(index[i]) {
				int curValue = possibleR.get(i)*(R[0]-R[1]) + possibleC.get(i)*(C[0]-C[1]) + possibleS.get(i)*(S[0]-S[1]);
				if(value == -1)
					value = curValue;
			
				if(value != curValue)
					return -1;
			}
		}
		return value;
	}
	static int[] adaptRCS(String[] me) {
		int[] inline = new int[me.length];
		int[] R = new int[2];
		int[] C = new int[2];
		int[] S = new int[2];
		
		for(int i=0; i<me.length; i++) {
			
			int value = isUnique(R,C,S);
			inline[i] = value;

			for(int j=0; j<me[i].length(); j++) {
				if(me[i].charAt(j)=='(') R[0]++;
				if(me[i].charAt(j)==')') R[1]++;
				if(me[i].charAt(j)=='{') C[0]++;
				if(me[i].charAt(j)=='}') C[1]++;
				if(me[i].charAt(j)=='[') S[0]++;
				if(me[i].charAt(j)==']') S[1]++;
				
			}
		}
		return inline;
	}
}
