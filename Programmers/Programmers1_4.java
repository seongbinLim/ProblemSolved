import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Programmers1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"classic", "pop", "classic", "classic", "pop"};
		int [] b = {500, 600, 150, 800, 2500};
		solution(a, b);
	}
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
        int idx = 0;
        
		HashMap<String, Integer> music = new HashMap<String, Integer>();
        for(int i=0; i<genres.length; i++) {        	
        	music.put(genres[i], music.getOrDefault(genres[i], 0) + plays[i]);
        }
       
        String[] compare = new String[music.size()];
        int[] compareCount = new int[music.size()];
        
        int index = 0;
		Iterator<String> keys2 = music.keySet().iterator();
		while ( keys2.hasNext() ) {
			String key = keys2.next();
			compare[index] = key;
			compareCount[index] = music.get(key);
			index++;
		}
		
        for(int i=0; i<compare.length; i++) {
        	for(int j=0; j<compare.length; j++) {
        		if(compareCount[i] > compareCount[j]) {
        			String tempS = compare[i];
        			int tempI = compareCount[i];
        			
        			compare[i] = compare[j];
        			compareCount[i] = compareCount[j];
        			compare[j] = tempS;
        			compareCount[j] = tempI;
        		}
        	}
        }
        
        ArrayList<Integer> a = new ArrayList<>();
        
        for(int j=0; j<compare.length; j++) {
        	int[] max = new int[2];
        	int[] secondMax = new int[2];
        	max[0] = -1; max[1] = -1;
        	secondMax[0] = -1; secondMax[1] = -1;

        	for(int i=0; i<genres.length; i++) {
        		if(compare[j].equals(genres[i])) {
        			if(secondMax[0] < plays[i]) {
        				if(max[0] < plays[i]) {
        					if(max[0] > secondMax[0]) {
        						secondMax[0] = max[0];
        						secondMax[1] = max[1];
        					}
        					max[0] = plays[i];
        					max[1] = i;
        				} else {
        					secondMax[0] = plays[i];
        					secondMax[1] = i;
        				}
        			}
        		}
        	}
        	//answer[idx++] = max[1];
        	//if(secondMax[0] != -1) {
        	//	answer[idx++] = secondMax[1];
        	//}
        	
        	a.add(max[1]);
        	if(secondMax[0] != -1) {
        		a.add(secondMax[1]);
        	}
		}
        answer = new int[a.size()];
        
        for(int i=0; i<a.size(); i++) {
        	answer[i] = a.get(i);
        }

        return answer;
	}
	
    public static int[] solution2(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> music = new HashMap<String, Integer>();
        
        for(int i=0; i<genres.length; i++) {
        	music.put(genres[i], music.getOrDefault(genres[i], 0) + plays[i]);
        	System.out.println(genres[i] + " " + music.get(genres[i]));
        }
        
		Iterator<String> keys = music.keySet().iterator();
		while ( keys.hasNext() ) {
			String key = keys.next();
			System.out.println("key : " + key + " value : " + music.get(key));
		}
        
		int[][] sortedSong = new int[plays.length][2];
		for(int i=0; i<plays.length; i++) {
			sortedSong[i][0] = i;
			sortedSong[i][1] = plays[i];
		}		
        return answer;
    }
}
