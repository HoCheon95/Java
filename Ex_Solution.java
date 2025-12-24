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

'배열의 유사도'
두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 
return하도록 solution 함수를 완성해주세요.

s1					s2								result
["a", "b", "c"]		["com", "b", "d", "p", "c"]		2
["n", "omg"]		["m", "dot"]					0

public int solution(String[] s1, String[] s2){
	int answer = 0;

	for(int i = 0; i < s1.length; i++){		// s1배열 길이만큼 for
		for(int j = 0; j < s2.length; j++){	// s2배열 길이만큼 for
			if(s1[i].equals(s2[j])){		// s1 값과 s2값의 문자열 비교 함수 equals
				answer++;
			}
		}
	}

	return answer;

}
/*======================================================================*/

'순서쌍의 개수'
순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다. 
자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution
함수를 완성해주세요.

n		result
20		6
100		9

public int solution(int n){
	int answer = 0;

	for(int i =1; i <= n; i ++){
		if(n % i == 0){
			answer++;
	}
	return answer;
}

/*======================================================================*/

'n의 배수 고르기'
정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 
return하도록 solution 함수를 완성해주세요.

n	numlist							result
3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
5	[1, 9, 3, 10, 13, 5]			[10, 5]
12	[2, 100, 120, 600, 12, 12]		[120, 600, 12, 12]



/*======================================================================*/

'n의 배수 고르기'
정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을기
return하도록 solution 함수를 완성해주세요.

n	numlist							result
3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
5	[1, 9, 3, 10, 13, 5]			[10, 5]
12	[2, 100, 120, 600, 12, 12]		[120, 600, 12, 12]

public int[] solution(int n, int[] numlist) {

		int j =0;

		for(int i =0; i < numlist.length; i++){
			if(numlist[i] % n == 0){ // n의 배수의 개수를 구하는 조건식
				j++;
			}
		}

        int[] answer = new int[j]; // n의 배수를 answer 배열의 크기로 지정
		j = 0;

		for(int i = 0; i < numlist.length; i++){
			if(numlist[i] % n == 0){
				answer[j] = numlist[i];
				j++;
			}
		}

        return answer;
}

/*======================================================================*/

'배열 원소의 길이'
문자열 배열 strlist가 매개변수로 주어집니다. 
strlist 각 원소의 길이를 담은 배열을 return하도록 solution 함수를 완성해주세요.


strlist							result
["We", "are", "the", "world!"]	[2, 3, 3, 6]
["I", "Love", "Programmers."]	[1, 4, 12]

public int[] solution(String[] strlist) {
	int[] answer = new int[strlist.length];

	for(int i = 0; i < strlist.length; i++){
		answer[i] = strlist[i].length();
	}

	return answer;
}

/*======================================================================*/

'아이스 아메리카노'
머쓱이는 추운 날에도 아이스 아메리카노만 마십니다. 아이스 아메리카노는 한잔에 5,500원입니다. 
머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때, 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 
순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

money	result
5,500	[1, 0]
15,000	[2, 4000]

public int[] solution(int money) {
	int[] answer = new int[2];

	answer[0] = money / 5500; // 몫
	answer[1] = money % 5500; // 나머지

	return answer;
	//return new int[] {money / 5500, money % 5500}; 이렇게도 사용이 가능하다.
}


/*======================================================================*/

'문자열안에 문자열'
문자열 str1, str2가 매개변수로 주어집니다. 
str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.

str1						str2		result
"ab6CDE443fgh22iJKlmn1o"	"6CD"		1
"ppprrrogrammers"			"pppp"		2
"AbcAbcA"					"AAA"		2

public int solution(String str1, String str2) {
        int answer = 0;
		
		if(str1.contains(str2)){ // contains() 함수는 서로다른 문자열을 비교한다.
			answer = 1;
		}else{
			answer = 2;
		}

        return answer;
}
/*======================================================================*/

'문자 반복 출력하기'
문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 
return 하도록 solution 함수를 완성해보세요.

my_string		n	result
"hello"			3	"hhheeellllllooo"

public String solution(String my_string, int n){
	String answer = "";
	
	for(int i = 0; i < my_string.length(); i++){ // my_string에 들어있는 문자열의 길이만큼 for문 동작
		for(int j = 1; j <= n; j++){ // n만큼 반복할 회수 
			answer += my_string.charAt(i); // my_string에서 i번째만큼 꺼내서 j만큼 반복 출력
		}
	}
	return answer;
}

/*======================================================================*/

'제곱수 판별하기'
어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다. 정수 n이 매개변수로 주어질 때, 
n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.

n		result
144		1
976		2

public int solution(int n){
	int answer = 0;
	
	for(int i = 1; i <= n; i++){ // for반복문을 통해 n번만큼 동작
		if(i * i == n){ // i * i 를 통해서 제곱근을 찾는다.
			answer = 1;
			break;
		}else{
			answer = 2;
		}
	}

	return answer;
}
/*======================================================================*/

'특정 문자 제거하기'
문자열 my_string과 문자 letter이 매개변수로 주어집니다. my_string에서 letter를 제거한 문자열을
return하도록 solution 함수를 완성해주세요.

my_string	letter	result
"abcdef"	"f"		"abcde"
"BCBdbe"	"B"		"Cdbe"

public String solution(String my_string, String letter){
	String answer = "";

	for(int i = 0; i < my_string.length(); i++){
		if(!(my_string.charAt(i) == letter.charAt(0))){
			answer += my_string.charAt(i);
		}
	}
	return answer;
}
/*======================================================================*/

'모음 제거'
영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 문자열 my_string이 매개변수로 
주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.

my_string			result
"bus"				"bs"
"nice to meet you"	"nc t mt y"

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/
