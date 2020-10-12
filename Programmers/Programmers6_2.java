import java.util.Arrays;

public class Programmers6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solution("JEROEN");
		//solution("JAN");
		//solution("BBAABB");
		//solution("AZAAAZ");
	}
	
    public static int solution(String name) {
        int answer = 0;
        char[] complete = new char[name.length()];
        
        int i=0;
        boolean isRight = true;
        Arrays.fill(complete,'A');
        
        while(!name.equals(String.valueOf(complete))) {
        	if(name.charAt(i) == 'A') {
        	}else if(name.charAt(i) <= 'N') {
        		answer = answer + name.charAt(i) - 'A';
        		complete[i] = name.charAt(i);
        		//System.out.println(i);
        	} else {
        		answer = answer + 'Z' - name.charAt(i) + 1;
        		complete[i] = name.charAt(i);
        		//System.out.println(i);
        	}
            //System.out.println(answer);
        	
        	if(name.equals(String.valueOf(complete))) break;
            
        	if(isRight){
            	if(name.charAt(i+1) == 'A') {
            		int count = 1;
            		for(int j=i+1; j<name.length(); j++) {
            			if(name.charAt(j) != 'A') {
            				break;
            			} else {
            				count++;
            			}
            		}	
            		if(i+1 < count) {
            			answer+=i+1;
            			i = name.length()-1;
            			isRight = false;
            		} else {
            			i++;
            			answer++;
            		}
            	} else {
            		i++;
            		answer++;
            	}
        	} else {
        		if(name.charAt(i-1) == 'A') {
        			int count = 1;
        			for(int j=i-1; j>=0; j--) {
        				if(name.charAt(j) != 'A') {
        					break;
        				} else {
        					count++;
        				}
        			}
        			if(name.length()-i < count) {
        				answer =+ name.length()-i;
        				i = 0;
        				isRight = true;
        			} else {
        				i--;
        				answer++;
        			}
        		} else {
        			i--;
        			answer++;
        		}
        	}
        	//next cursor ·Î À§Ä¡
        }

        //System.out.println(answer);
        return answer;
    }
}
