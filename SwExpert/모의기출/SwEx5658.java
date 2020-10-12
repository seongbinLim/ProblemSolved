package 모의기출;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SwEx5658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t);
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			char[] num = br.readLine().toCharArray();

			HashSet<Integer> set = new HashSet<>();

			for (int i = 0; i < (N / 4); i++) {
				for (int k = i; k < N; k = k + (N / 4)) {
					String zz = "";
					for (int j = k; j < k + (N / 4); j++) {
						int idx = j%N;
						zz += num[idx];
					}

					set.add(Integer.parseInt(zz, 16));
				}
			}
			ArrayList<Integer> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			//System.out.println(list.toString());
			int result = list.get(K-1);

			sb.append(" " + result + "\n");
		}

		System.out.println(sb.toString());

	}

}
