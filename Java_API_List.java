1. 출력 / 문자열

System.out.println()	// 줄바꿈
System.out.print()		// 수평 출력
System.out.printf()		// 형식 지정 출력
%d : 정수
%f : 실수
%s : 문자열
%c : 문자
\n : 줄바꿈

2. 수학

(int)(Math.random())
int tmp = (int)(Math.random() * 5);
random()메서드는 0.0이상 1.0미만 사이의 실수숫자 난수를 구함.
실수숫자 난수 발생 -> (int)로 캐스팅하면 0이상 5미만
결국 0 부터 4사이의 임의의 정수숫자 난수 구함

Ramdom random = new Random(); // import util패키지 사용해야됨
random.nextInt(10); // 0 ~ 9 까지

Math.max
 - 최대값
Math.PI
 - 원주율

3. Scanner
Scanner.nextInt();
Scanner.next();
Scanner.nextLine();

int num = Integer.parseInt(scan.nextLine()); // 문자열로 한 줄 입력을 받은 뒤 -> 정수로 변환
int num = Integer.parseInt(); // String -> int 형변환

4. 비교함수
 1) equals() // 문자열 비교함수
	s1[i].equals(s2[j]);
	
 2) contains()
    answer = str1.contains(str2); // 결과는 bloolean 형태
	
 3) replace
    str.replace('a', ''); // char 사용
	str.replace("a", ""); // String 사용
	
 4) replaceAll
    str.replaceAll("[0-9]","");
  - Day15_java.AutoEx07.java 참고

5. StringTokenizer
 - 특수문자를 기준으로 문자열 분리
 - Day15_java.AutoEx05.java 참고
 
6. Calendar
 - 컴퓨터 시스템의 년월일 시분초 값을 반환해 준다.
  - Day15_java.AutoEx06.java 참고
  
7. toUpperCase()
 - 영문대문자로 변경해 준다.
 - Day15_java.AutoEx07.java 참고
 
8. indexOf('e');
 - 단일문자 e를 맨왼쪽에서 부터 찾아서 가장 먼저 나오는 해당위치번호를 맨 왼쪽 첫문자를 0부터 카운터해서 구한다.
 - Day15_java.AutoEx07.java 참고
 
9. StringBuffer();
 - Day15_java.AutoEx07.java 참고
 
10. Arrays.toString()		
 - 배열 출력
 - Day15_java.AutoEx07.java 참고 
 
11. charAt(2)
 - 첫문자를 0부터 시작해서 세번? 단일문자 e를 반환
 - Day15_java.AutoEx07.java 참고
 
12. length
 - 길이 구하는 함수

13. length();
 - 배열 인덱스의 문자열의 길이를 구하는 함수
 - answer[i] = strlist[i].length();
 
14. toString();
 - 배열 %s로 출력


 