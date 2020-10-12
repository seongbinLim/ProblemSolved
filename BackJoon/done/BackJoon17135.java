package done;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon17135 {
	static class Person {
		int r;
		int c;
		int num;
		public Person(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	static int[] sel = new int[3];
	static int[] archer;
	static ArrayList<Person> people;
	static int N;
	static int M;
	static int possible;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		possible = sc.nextInt();
		archer = new int[M];
		people = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				people.add(new Person(i,j, sc.nextInt()));
				
			}
		}
		max = 0;
		combination(0, 0);
		System.out.println(max);
	}

	static int distance(int x, int y, int targetX, int targetY) {
		return Math.abs(x - targetX) + Math.abs(y - targetY);
	}

	static void calculate() {
		//System.out.println("_____________________");
		int[] clone = archer.clone();
		ArrayList<Person> list = new ArrayList<>();
		for(int i=0; i<people.size(); i++) {
			list.add(new Person(people.get(i).r, people.get(i).c, people.get(i).num));
		}
		int count = 0;
		for (int turn = 0; turn < N; turn++) {
			for (int p = 1; p <= possible; p++) {
				for (int k = 0; k < M; k++) {
					if (clone[k] == 1) {
						int leftIdx = -1;
						for (int i = 0; i < list.size(); i++) {
							int x = list.get(i).r;
							int y = list.get(i).c;
							int num = list.get(i).num;
							//System.out.println("p : " + p +" k: " + k + " : "+x+","+ y);
							if (x < N && num != 0 && distance(x, y, N, k) == p) {
								//System.out.println("in"+x+","+ y);
								if (leftIdx == -1)
									leftIdx = i;
								else if (list.get(leftIdx).c > y) {
									leftIdx = i;
								}
							}

						}
						if (leftIdx != -1) {
							list.get(leftIdx).num = -1;
							clone[k] = 0;
						}
					}
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).num == -1) {
					count++;
					list.get(i).num = 0;
				}
				list.get(i).r++;
			}
			//System.out.println(Arrays.toString(clone));
			clone = archer.clone();
		}
		
		if (count > max)
			max = count;
		//System.out.println(count);
	}

	static void combination(int idx, int s_idx) {
		if (s_idx == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				archer[sel[i]] = 1;
			}

			calculate();
			Arrays.fill(archer, 0);
			return;
		}

		if (idx == M)
			return;

		sel[s_idx] = idx;
		combination(idx + 1, s_idx + 1);
		combination(idx + 1, s_idx);
	}

}
