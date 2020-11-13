import java.util.Arrays;
class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = 1;
        long high = (long) times[times.length-1] * n;
        long answer = high;
        while(low <= high) {
        	long mid = (low+high)/2;
        	long cnt = 0;
        	//System.out.println(low +", " + high + ", " + mid);
        	for(int i=0; i<times.length; i++) {
        		cnt += mid/times[i];
        	}
        	
        	if(cnt>=n) {
        		answer = Math.min(answer, mid);
        		high = mid-1;
        	} else {
        		low = mid+1;
        	}
        }
        
        return answer;
    }
}