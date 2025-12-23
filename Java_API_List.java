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


3. Scanner
Scanner.nextInt();
Scanner.next();
Scanner.nextLine();

int num = Integer.parseInt(scan.nextLine()); // 문자열로 한 줄 입력을 받은 뒤 -> 정수로 변환