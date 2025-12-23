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

'최대값 만들기1'
정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 
최댓값을 return하도록 solution 함수를 완성해주세요.

numbers	result
[1, 2, 3, 4, 5]			20
[0, 31, 24, 10, 1, 9]	744

입출력 예 #1
두 수의 곱중 최댓값은 4 * 5 = 20 입니다.

입출력 예 #1
두 수의 곱중 최댓값은 31 * 24 = 744 입니다.

public class pra2 {
	
	public int solution(int[] numbers) {
        int answer = 0;

		int max1 = 0;
        int max2 = 0;
        
        for (int i = 0; i<numbers.length; i++) {	// for문을 매개변수길이만큼 실행
        	if(numbers[i] > max1) {		// numbers[i]의 값과 max1비교
        		max2 = max1;			// 현재값이 더 크면 max2 = max1 대입
        		max1 = numbers[i];		// max1에 현재값 대입
        	}else if (numbers[i] > max2) {	// 첫 조건문에서 조건이 성립되지 않으면 실행
        		max2 = numbers[i];		// 첫 조건문이 실행이 안되면 max1은 구해진 상태
        	}							// 그다음 최대값을 max2로 구하는 조건
        }
        return max1 * max2;
    }
	
	public static void main(String[] args) {
		
		pra2 p = new pra2();
		//int[] arr = {1,2,3,4,5};
		int[] arr = {0, 31, 24, 10, 1, 9};
		System.out.println(p.solution(arr));
			
	}

}

/*======================================================================*/

'머쓱이보다 키 큰 사람'
머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다. 
머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 
머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.

array					height	result
[149, 180, 192, 170]	167		3
[180, 120, 140]			190		0

입출력 예 #1
149, 180, 192, 170 중 머쓱이보다 키가 큰 사람은 180, 192, 170으로 세 명입니다.

입출력 예 #2
180, 120, 140 중 190보다 큰 수는 없으므로 0명입니다.

public int soulution(int[] array, int height){
	int answer = 0;

	for (int i=0; i<array.length; i++ ){
		if (array[i] > height)	// array[] 배열안에서 height 보다 큰 값을 찾는다
		{
			answer++;	// 값이 클때마다 count를 해준다
		}
	}
	return answer;
}

/*======================================================================*/

'삼각형의 완성조건(1)
선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.

가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 
세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.

sides			result
[1, 2, 3]		2
[3, 6, 2]		2
[199, 72, 222]	1

public int solution(int[] sides){
	int answer = 0;
	int max = 0;
	int sum = 0;

	for(int i=0; i<sides.length; i++){
		sum += sides[i]; // 총 3변의 길이를 구함
		if(sides[i] > max){
			max = sides[i]; // 3변의 길이 중 최대값을 구함
		}
	}

	if (sum - max > max)// sum-max = 가장 긴 변의 길이를 제외한 나머지 길이 > 가장 긴 변의 길이
	{
		answer = 1; // 가장 긴 변의 길이보다 두변의 합이 클 경우 조건 성립
	}else{
		answer = 2;
	}
	return answer;
}

/*======================================================================*/

'배열 자르기'
정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때, 
numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.

numbers				num1	num2	result
[1, 2, 3, 4, 5]		1		3		[2, 3, 4]
[1, 3, 5]			1		2		[3, 5]

public int[] solution(int[] numbers, int num1, int num2){
	int[] answer = new int[num2 - num1 + 1] // answer의 배열의 크기를 선언 [3 - 1 + 1]
	int j = 0;

	for(int i = num1; i<=num2; i++){	// i 초기값을 num1 시작할 인덱스 ~ num2 까지 인덱스
		answer[j] = numbers[i];	// answer[0]의 인덱스부터 대입
		j++;
	}

	return answer;

}

/*======================================================================*/

'피자 나눠 먹기(3)'
머쓱이네 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다. 
피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때, 
n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지를 
return 하도록 solution 함수를 완성해보세요.

slice	n	result
7		10	2
4		12	3

public int solution(int slice, int n) {
    int answer = 0;

	if(n % slice == 0){ // 나머지가 0인경우 인원과 조각이 맞음
		answer = n / slice // 몫을 출력
	}else{
		answer = n / slice + 1; // 나머지가 발생하므로 피자가 부족함
	} // 몫 + 1
    return answer;
}

/*======================================================================*/

'점의 위치 구하기'
사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.

dot		result
[2, 4]	1
[-7, 9]	2
public int solution(int[] dot) {
	int answer = 0;
	if (dot[0] > 0 && dot[1] > 0) {
		answer = 1;
	} else if (dot[0] < 0 && dot[1] > 0) {
		answer = 2;
	} else if (dot[0] < 0 && dot[1] < 0) {
		answer = 3;
	} else if (dot[0] > 0 && dot[1] < 0) {
		answer = 4;
	}
	return answer;
}


/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/
