/*
AutoEx01

자바 5버전에서 추가된 오토박싱과 오토언박싱 문법)
 1. 오토박싱 이란?
  - 기본타입을 참조 래퍼클래스 타입으로 자동형 변환을 하는 것을 말한다.
 2. 오토언박싱 이란?
  - 반대로 래퍼클래스 타입이 기본타입으로 형변환을 하는 것을 말한다.
*/

public class AutoEx01{
	public static void main(String[] args){
		
		int n01 = 10;
		int n02;
		
		Integer num01;
		Integer num02 = new Integer(20);
		
		num01 = n01;//오토박싱
		System.out.println("오토박싱 된 값 = " + num01);
		
		n02 = num02;//오토언박싱
		System.out.printf("오토언박싱 된 값 = %d \n", n02);
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
AutoEx02

1. Object 최고조상 부모클래스의 내장 메서드중에서 문자열 값을 반환해 주는 toString() 메서드를 오버라이딩 해 본다.

java.lang은 기본 패키지 경로이다. 코드상에서 생략해도 된다.
*/

class Point02 extends Object{// extends Object 생략가능
	int x, y;//2개의 클래스 소속 멤버변수 중 인스턴스(속성) 선언
	
	public Point02(){}//매개변수가 없는 기본생성자
	
	public Point02(int x, int y){
		this.x = x;
		this.y = y;
	}// 매개변수 타입을 다르게 한 생성자 오버로딩
	
	@Override
	public String toString(){
		return "(x좌표값 = " + x + ", y좌표값 = " + y + ")";
	}
}
public class AutoEx02{
	public static void main(String[] args){
		
		Point02 pt02 = new Point02(100,200)// 매개변수 2개짜리 오버로딩 된 생성자 호출
		System.out.println(pt02.toString());
		System.out.println(pt02);//toString()이 생략됨
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
AutoEx03

== 같다 비교연산자와 String 문자열 내장클래스 하위의 equals() 내장메서드 비교 예)
*/

public class AutoEx03 {

	public static void main(String[] args) {

		int a = 7, b = 7;

		if (a == b) {//기본타입 값을 == 같다 연산으로 비교하며 값을 비교한다.
			System.out.println(a + "와(과) " + b + "는 값이 같다.");
		}else {
			System.out.printf("%d와(과) %d는 값이 다르다.\n", a, b);
		}
		
		String pwd01 = new String("56789");
		String pwd02 = new String("56789");// new 키워드로 새로운 객체 pws01, pwd02를 각각 생성하면 각 객체주소는 다르다.
		
		if(pwd01 == pwd02) {//String 문자열값을 == 로 비교하면 값을 비교하지 않고 객체주소를 비교한다.
			System.out.println("비번이 같다.");			
		}else {
			System.out.println("비번이 다르다.");
		}
		
		if(!pwd01.equals(pwd02)) {//문자열 값 비교는 equals() 메서드를 사용해야 한다.
			System.out.println("비번이 다르다.");
		}else {
			System.out.println("비번이 같다.");
		}//if ~ else
	}

}
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
AutoEx04

/*
 * Object 내장 메서드 중 하나인 equals()를 자손에서 오버라이딩을 한 경우)
 */

class Point04 extends Object{
	int a,b;
	
	public Point04(){}//기본 생성자
	
	public Point04(int a, int b){
		this.a = a;
		this.b = b;
	}// 생성자 오버로딩
	
	@Override
	public boolean equals(Object obj){
		
		Point04 pt = null;//지역변수
		
		if(obj instanceof Point04){// 다운캐스팅이 가능한가?
			pt = (Point04)obj;//다운캐스팅
		}
		
		if((a == pt.a) && (b == pt.b)){// a,b값만 비교한다.
			return true;
		}else{
			return false;
		}// if else
	}// equals
}
public class AutoEx04{
	public static void main(String[] args){
		
		Point04 pt01 = new Point04(100,200);// 매개변수 2개짜리 오버로딩 된 생성자를 호출
		Point04 pt02 = new Point04(100,200);// pt01, pt02각 객체주소는 다르다.
		
		if(pt01 == pt02){//참조타입을 ==로 비교하면 객체주소를 비교한다.
			System.out.println("같다");
		}else{
			System.out.println("다르다");
		}
		
		if(pt01.equals(pt02)){// 값만 비교
			System.out.println("값이 같다");
		}else{
			System.out.println("값이 다르다");
		}	
	}
}
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■