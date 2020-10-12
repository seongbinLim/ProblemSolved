package 모의기출;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class SwEx2383_점심식사시간 {
	static int[][] map;
	static int N;
	static int stairA;
	static int stairB;
	static ArrayList<Info> list;
	static boolean[] sel;
	static int min;
	static class Info implements Comparable<Info> {
		int x;
		int y;
		int timeA;
		int timeB;

		public Info(int x, int y, int timeA, int timeB) {
			this.x = x;
			this.y = y;
			this.timeA = timeA;
			this.timeB = timeB;
		}

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + ", " + timeA + ", " + timeB + "]";
		}

		@Override
		public int compareTo(Info o) {
			return this.timeA > o.timeA ? 1 : -1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];

			int s1X = -1, s1Y = -1, s2X = -1, s2Y = -1;

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > 1 && s1X == -1) {
						s1X = i;
						s1Y = j;
						stairA = map[i][j];
					} else if (map[i][j] > 1 && s1X != -1) {
						s2X = i;
						s2Y = j;
						stairB = map[i][j];
					}

					if (map[i][j] == 1)
						count++;
				}
			}

			sel = new boolean[count];
			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
			findStair(s1X, s1Y, s2X, s2Y);
			powerset(0);
			System.out.println("#"+t+" " + min);

		}
	}

	// ��ܱ����� �ִ� ��� ã�� (stair1, stair2)
	static void findStair(int s1X, int s1Y, int s2X, int s2Y) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					int diff1 = Math.abs(s1X - i) + Math.abs(s1Y - j);
					int diff2 = Math.abs(s2X - i) + Math.abs(s2Y - j);
					list.add(new Info(i, j, diff1, diff2));
				}
			}
		}

		//Collections.sort(list);
	}

	static void powerset(int idx) {
		if (idx == sel.length) {
			ArrayList<Info> goToA = new ArrayList<>();
			ArrayList<Info> goToB = new ArrayList<>();
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					goToA.add(list.get(i));
				} else {
					goToB.add(new Info(list.get(i).x, list.get(i).y, list.get(i).timeB, list.get(i).timeA));
				}
			}
			Collections.sort(goToA);
			Collections.sort(goToB);
			//System.out.println("--------------");
			//System.out.println(goToA.toString());
			min = Math.min(min, calculate(goToA, goToB));
			return;
		}
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;
		powerset(idx + 1);
	}

	static int calculate(ArrayList<Info> a, ArrayList<Info> b) {
		
		
		int time = 0;
		int size = 0;
		int index = 0;
		int timeA = 0;
		
		int sec = 1;
		int outIdx = 0;
		//System.out.println(a.size());
		if (a.size() > 0) {
			while(index < a.size()) {
				if (size < 3) {
					while (size < 3 && index < a.size() && a.get(index).timeA < sec) {
						size++;
						index++;
					}
				} else {
					if (sec <= a.get(index - 3).timeA + stairA) {
						time++;
					}
				}
				
				while(outIdx < index && sec == a.get(outIdx).timeA+stairA) {
					size--;
					outIdx++;
				}
				
				//System.out.println(sec + ", " +time + ", " + size + ", " +index);
				sec++;
			}
			
			timeA = sec-1 + stairA;
			//System.out.println(timeA);
		}
		
		time = 0;
		size = 0;
		index = 0;
		sec = 1;
		outIdx = 0;
		int timeB = 0;
		if (b.size() > 0) {
			while(index < b.size()) {
				if (size < 3) {
					while (size < 3 && index < b.size() && b.get(index).timeA < sec) {
						size++;
						index++;
					}
				} else {
					if (sec <= b.get(index - 3).timeA + stairB) {
						time++;
					}
				}
				
				while(outIdx < index && sec == b.get(outIdx).timeA+stairB) {
					size--;
					outIdx++;
				}
				
				//System.out.println(sec + ", " +time + ", " + size + ", " +index);
				sec++;
				
				//if(sec == 13) break;
			}
			
			timeB = sec-1 + stairB;
			//System.out.println(timeB);
		}		 
		
		return Math.max(timeA, timeB);
	}

}
