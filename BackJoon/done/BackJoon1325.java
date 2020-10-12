package done;
import java.util.ArrayList;
import java.util.Scanner;


public class BackJoon1325 {
	static int max;
	static boolean[] v = new boolean[10001];
	static int[] ans = new int[10001];
	static ArrayList<Integer>[] list = new ArrayList[10001];
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		//int N = Integer.parseInt(st.nextToken()) + 1;
		//int M = Integer.parseInt(st.nextToken());

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt()+1;
		int M = sc.nextInt();
		//list = new ArrayList[N];
		for(int i=1; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			//st = new StringTokenizer(br.readLine());
			//int a = Integer.parseInt(st.nextToken());
			//int b = Integer.parseInt(st.nextToken());
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
		}

		//ans = new int[N];
		max = 0;
		for (int i = 1; i < N; i++) {
			v = new boolean[N];
			if(list[i].size() > 0)
				dfs(i);
		}

		//System.out.println(Arrays.toString(ans));
		for(int i=1; i<N; i++) {
			max = Math.max(max, ans[i]);
		}
		for (int i = 1; i < N; i++) {
			if (max == ans[i])
				//System.out.print(i + " ");
				sb.append(i).append(" ");
		}

		System.out.println(sb.toString());

	}
	
	static void dfs(int vertax) {
		v[vertax] = true;
		
		for(int i=0; i<list[vertax].size(); i++) {
			int next = list[vertax].get(i);
			if(!v[next]) {
				ans[next]++;
				//max = Math.max(max, ans[next]);
				dfs(next);
			}
		}
	}

}
