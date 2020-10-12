package 모의기출;
import java.util.LinkedList;
import java.util.Scanner;

public class SwEx특이한자석 {

	static LinkedList<Integer>[] magnet;
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			K = sc.nextInt();
			magnet = new LinkedList[5];
			for(int i=1; i<=4; i++) {
				magnet[i] = new LinkedList<>();
				for(int j=0; j<8; j++) {
					magnet[i].add(sc.nextInt());
				}
			}
			//k번 자석을 돌리자
			for(int k=0; k<K; k++) {
				int mNum = sc.nextInt(); //몇번 자석을?
				boolean dir = sc.nextInt()==1?true:false; //1:시계 , 0:반시계
				if(mNum>1) { //자기 왼쪽에 자석이 있는 애들
					action(mNum, 6, dir);
				}
				
				if(mNum>1 && mNum<4) { //중간에 낀 2,3번은 rotate 두번 당하니까 한번 무효화
					rotate(mNum, !dir);
				}
				
				if(mNum<4) { //자기 오른쪽에 자석이 있는 애들
					action(mNum,2,dir);
				}
			}
			
			int ans = 0;
			for(int i=1; i<=4; i++) {
				ans += (magnet[i].get(0) * (1<<(i-1)));
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void action(int mNum, int idx, boolean dir) {
		int mNext = mNum + (idx==2? +1: -1); //2이면 오른쪽 , 6이면 왼쪽으로 진행
		if(mNext>0 && mNext<5 && magnet[mNum].get(idx) != magnet[mNext].get((idx+4)%8)) {
			action(mNext, idx, !dir); //옆자석번호, 왼오방향은 유지, 시계반시계 방향은 반대
		}
		rotate(mNum, dir); //옆 자석을 돌릴지 말지 확인하고 났으면 이제 현재자석도 돌려
	}
	
	static void rotate(int mNum, boolean dir) { //mNum번 자석을 시계or반시계 돌림
		if(dir) {
			magnet[mNum].addFirst(magnet[mNum].removeLast());
		} else {
			magnet[mNum].addLast(magnet[mNum].removeFirst());
		}
		
	}
}
 