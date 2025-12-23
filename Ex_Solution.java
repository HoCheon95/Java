'피자 나눠 먹기(1)'
머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 주어질 때, 
모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.

입출력 예 #1
 - 7명이 최소 한 조각씩 먹기 위해서 최소 1판이 필요합니다.

입출력 예 #2
 - 1명은 최소 한 조각을 먹기 위해 1판이 필요합니다.

입출력 예 #3
 - 15명이 최소 한 조각씩 먹기 위해서 최소 3판이 필요합니다.

public class pra2 {
	
	public int solution(int n) {
        int answer = 0;
        if(n == 1) {
        	answer = 1;
        }else if (n%7 == 0) {
        	answer = n/7; 
        }else {
        	answer = (n/7)+1;
        }
        //return (n + 6) / 7;
        return answer;
    }
	
	public static void main(String[] args) {
		
		pra2 p = new pra2();
		
		System.out.println(p.solution(7));
			
	}

}

/*======================================================================*/

'세균 증식'
어떤 세균은 1시간에 두배만큼 증식한다고 합니다. 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 
t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.

입출력 예 #1
처음엔 2마리, 1시간 후엔 4마리, 2시간 후엔 8마리, ..., 
10시간 후엔 2048마리가 됩니다. 따라서 2048을 return합니다.

입출력 예 #2
처음엔 7마리, 1시간 후엔 14마리, 2시간 후엔 28마리, ..., 
15시간 후엔 229376마리가 됩니다. 따라서 229,376을 return합니다.

public class pra2 {
	
	public int solution(int n, int t) {
        int answer = n;

        for(int i=0; i<t; i++) {
        	answer *= 2;	// 반복문을 통해 2배씩 증감식을 만들면 된다.
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		pra2 p = new pra2();
		
		System.out.println(p.solution(2,10));
			
	}

}

/*======================================================================*/

