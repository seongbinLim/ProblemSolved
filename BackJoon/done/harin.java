package done;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class harin {
	static int[][] arr;
	static boolean[][][] visited;
	static int N,M;
	static int MIN=Integer.MAX_VALUE;
	static Robot startR;
	static Robot endR;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
			N = sc.nextInt();
			M = sc.nextInt();
			//�迭����
			arr=new int[N+1][M+1];
			for(int i=0;i<=N;i++) {
				arr[i][0]=1;
			}
			
			for(int i=0;i<=M;i++) {
				arr[0][i]=1;
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0; i<=N; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println();
			//�κ���
			for(int i=0;i<=1;i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				int dir=sc.nextInt();
				if(i==0)
					startR=new Robot(x, y, dir,0);
				else
					endR=new Robot(x, y, dir,0);
			}
			visited=new boolean[N+1][M+1][5];
			bfs();
			
			sb.append(MIN);
			System.out.println(sb.toString());
		}
	//1�� 2�� 3�� 4��
	static int[] dr= {0,0,0,1,-1};
	static int[] dc= {0,1,-1,0,0};
	static void bfs() {
		Queue<Robot> queue= new LinkedList<>();
		queue.add(startR);
		while(!queue.isEmpty()) {
			Robot t = queue.poll();
			if(t.x==endR.x && t.y==endR.y && t.dir == endR.dir) {
				//���� �ٲٱ�
				MIN=Math.min(MIN, t.cnt);
				break;
			}
			for(int i=1;i<=3;i++) {
				int row=t.x+dr[t.dir]*i;
				int col=t.y+dc[t.dir]*i;
				if(row <N+1 && row >0 && col <M+1 && col > 0 && arr[row][col]!=1) {
					if(visited[row][col][t.dir]) continue;
					visited[row][col][t.dir]=true;
					queue.add(new Robot(row,col,t.dir,t.cnt+1));
				}else break;
			}
			
			for(int i=1;i<=4;i++) {
				if(t.dir!=i && !visited[t.x][t.y][i]) {
					visited[t.x][t.y][i]=true;
					if((t.dir==1 && i==2) ||  (t.dir==3 && i==4) ||(t.dir==2 && i == 1) || (t.dir==4 && i==3)) queue.add(new Robot(t.x,t.y,i,t.cnt+2));
					else queue.add(new Robot(t.x,t.y,i,t.cnt+1));
				}
			}
		}
	}
	
	static class Robot{
		int x;
		int y;
		int dir;
		int cnt;
		public Robot(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Robot [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}
}