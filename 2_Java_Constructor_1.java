Day09_java/ClassEx01.java
매개변수 개수가 다른 메서드가 오버로딩이 된 경우 기본타입 매개변수와 참조타입 배열 매개변수와의 차이점

public class ClassEx01{
	void add(int a, int b, int[] result){	
		result[0] = a + b;
	}// 매개변수 개수가 다른 메서드 오버로딩

	int add(int a, int b){
		return a + b;
	}// 매개변수 개수가 다른 메서드 오버로딩이 된 경우

	public static void main(String[] args){
		ClassEx01 cex = new ClassEx01();// cex 객체 생성
		
		int result = cex.add(3,5); // result = 8
		
		int[] arr = {0}; // 첫번째 배열원소값으로 0 저장
		cex.add(3, 5, arr); // arr배열원소값이 0에서 8로 변경됨
	}
}

/*======================================================================*/

Day09_java/ClassEx02.java
메서드 리턴타입이 참조형인 경우

class Data13{
	int x;
}

public class ClassEx02{
	static Data13 copy(Data13 d){ // 메서드 반환타입이 Data13 클래스형 참조타입 인 경우
		Data13 tmp = new Data13();// 새로운 객체 tmp를 생성하면서 새로운 객체주소를 할당한다.
		tmp.x = d.x; // tmp와 d는 서로 다른 객체주소를 가진다. 값만 복사

		return tmp;
	}
	public static void main(String[] args){
		Data13 d = new Data13(); // d객체 생성
		d.x = 10;

		Data13 d2 = copy(d); // d2와 d는 서로 다른 객체주소를 가진다. d2 = tmp 이다.
		                     // 즉 d2와 tmp는 같은 객체주소이다.

		System.out.println(d.x); // 10
		System.out.println(d2.x);// 10
	}
}

/*======================================================================*/

Day09_java.Ex12_01.java
p() 메서드를 오버로딩하여 두 int 타입 매개변수에 대해서 두 double 타입 매개변수에 대해서 각각 최대값을 구하는
메서드를 작성해 본다. (단, 매개변수 타입을 다르게 한 메서드 오버로딩)

class Mt{
	public void p(int a, int b) {
		if(a > b) {
			System.out.println(a + "와 " + b + "중 더 큰 최대값 = " + a);
		}
	}
	
	public void p(double a, double b) {
		if(a < b) {
			System.out.println(a + "와 " + b + "중 더 큰 최대값 = " + b);
		}
	}// 매개변수 타입을 다르게 한 메서드 오버로딩
}

public class Ex12_01 {

	public static void main(String[] args) {
		
		Mt mt = new Mt();
		mt.p(100, 50);
		mt.p(50.5, 100.7);

	}

}

/*======================================================================*/

Day09_java.Ex12_02.java
속성으로 메모리 용량과 회사명을 저장하는 변수를 갖는 Mp3 클래스를 설계하고 다음과 같은 결과가 나오도록
객체 생성 후 메소드를 호출하시오
----------------------------------------------------------
					Mp3
----------------------------------------------------------
-comp : String				// - 붙으면 private 선언
-size : int					// - 붙으면 private 선언
----------------------------------------------------------
+getComp() : String			// 값 반환 메서드 getter() 메서드
+getSize() : int			// 값 반환 메서드 getter() 메서드
+setComp(new_comp : String)	// 값 저장 메서드 setter() 메서드
+setSize(new_size : int)	// 값 저장 메서드 setter() 메서드
----------------------------------------------------------
class Mp3{
	private String comp; // 회사명
	private int int; // 메모리 용향

	public void setComp(String new_comp){// 값 저장메서드 -> setter() 메서드 
		comp = new_comp;
	}
	
	public void getComp(){// 값 반환 메서드 -> getter() 메서드
		return comp;
	}
	
	public void setSize(int new_size){// 값 저장메서드 -> setter() 메서드
		size = new_size;
	}

	public void getSize(){// 값 반환 메서드 -> getter() 메서드
		return size;
	}
}
public class Ex12_02{
	public static void main(String[] args){

		Mp3 mp = new Mp3();
		mp.setComp("갑을회사");
		mp.setSize(8);

		System.out.println("회사명 : " + m.getComp());
		System.out.println("메모리 용량 : " + m.getSize() + "G");
	}
}

/*======================================================================*/

Day09_java/ClassEx03.java
'생성자'
1. 생성자 이름은 클래스 이름과 같게 정의한다. new 클래스명();에 의해서 생성자를 호출한다.
2. 생성자의 주된 기능은 클래스 소속의 멤버변수 중 객체 생성해서 접근하는 인스턴스 변수 초기화 기능이다.
3. 생성자 명 앞에 리턴타입을 기술하지 않는다.

class MyDate03{
	private int year;
	private int month;
	private int date;

	public MyDate03(){// 매개변수가 없는 기본 생성자
		year = 2025;
		month = 12;
		date = 31;
	}
}	
public class ClassEx03{
	public static void main(String[] args){
		MyDate03 md = new MyDate03(); // new MyDate03()에 의해서 기본 생성자 호출
	}
}

/*======================================================================*/

Day09_java/ClassEx04.java
'생성자 특징'
 - 생성자도 메서드의 일종이기 때문에 오버로딩이 가능하다.

class Member04{
	private String mem_id;
	private String mem_name;
	private String mem_phone;

	public Member04(){ // 매개 변수가 없는 기본 생성자
		mem_id = "kkkkk";
		mem_name = "홍길동";
		mem_phone = "020-999-9999";
	}

	public Member04(String new_id, String new_name, String new_phone){
		mem_id = new_id,
		mem_name = new_name,
		mem_phone = new_phone;
	} // 매개변수 개수가 다른 생성자 오버로딩

	public void pr(){
		System.out.println("회원아이디 : " + mem_id + ", 회원이름 : " + mem_name + ", 회원번호 : + " mem_phone)
	}// 사용자 정의 메서드
}
public class classEx04{
	public static void main(String[] args){

		Member04 member = new Member04(); // new Member04();에 의해서 기본생성자 호출
		member.pr();

		Member04 member02 = new Member04("ccccc", "신사임당", "010-7777-7777");
		member02.pr();
	}
}

/*======================================================================*/

Day09_java/ClassEx05.java
/*
 * 기본 생성자(디폴트 생성자) 특징)
 *  기본 생성자는 매개변수가 없는 생성자를 말한다. 생성자가 오버로딩이 안된 경우에는 자바 컴파일러는 묵시적인 기본생성자를 제공
 *  한다.
 */

class MyDate05{
	private int year;
	private int month;
	private int date;
	
	//기본 생성자 묵시적 생략
	
	public void print() {
		System.out.println(year + "년 " + month + "월 " + date + " 일");
	}
}
public class ClassEx05 {

	public static void main(String[] args) {
		
		MyDate05 md = new MyDate05();// new MyDate05();에 의해서 기본생성자 호출
		md.print();

	}

}
/*======================================================================*/

Day09_java/ClassEx06.java
/* 생성자의 특정)
 *  생성자가 오버로딩이 되면 자바 컴팡일러는 더 이상 묵시적인 기본생성자를 제공하지 않는다.
 * 
 */

class GuestBook06{
	String writer;//방명록 글쓴이
	String title; //방명록 제목
	
	//생성자를 오버로딩을 해서 기본생성자 묵시적 제공 안함
	public GuestBook06(String new_write, String new_title) {
		writer = new_write;
		title = new_title;
	}// 매개변수 개수가 다른 생성자 오버로딩
	
	public void pr() {
		System.out.println("방명록 글쓴이 : " + writer + ", 방명록 제목 : " + title);
	}
}// 방명록 클랙스
public class ClassEx06 {

	public static void main(String[] args) {
		
		//GuestBook06 guest = new GuestBook06();// new GuestBook06(); 에 의해서 묵시적으로 제공하지
		                                      //  않는 기본생성자를 호출하려다가 컴파일 에러 발생
		//guest.pr();
		
		GuestBook06 guest02 = new GuestBook06("홍길동", "방명록 제목입니다.");// 매개변수 2개짜리 오버로딩 된 생성자 호출
		guest02.pr();

	}

}

/*======================================================================*/

Day09_java/ClassEx07.java
/* this 키워드를 사용하는 이유)
 *  1. 메서드(생성자) {} 중괄호 블록내에서 클래스 소속의 멤버 변수 중 인스턴스 변수와 생성자나 메서드 소속의 매개 변수명이 
 *  같을 때 자바는 어느것이 인스턴스 변수인지 매개 변수인지 구분을 못해서 값이 저장 안된다. 이러한 문제점을 해결하기
 *  위해서 왼쪽의 인스턴스 변수명 앞에 this. 을 붙임으로서 클래스 소속의 인스턴스 변수라는 것을 알려주면 구분이
 *  되어 져서 값이 저장된다.
 * 
 *  2. 여기서는 this.을 인스턴스 변수명 앞에 붙이지 않아서 값이 저장 안되는 경우에 대해서 알아 본다.
 */

class MyDate07{
	private int year;	// 멤버 변수 | 인스턴스 변수(속성) 3개 정의
	private int month;	// 멤버 변수 | 인스턴스 변수(속성) 3개 정의
	private int date;	// 멤버 변수 | 인스턴스 변수(속성) 3개 정의

	public MyDate07(){} //기본 생성자

	public MyDate07(int year, int month, int date){
		year = year;
		this.month = month;	// this. 을 붙임으로서 클래스 소속의 인스턴스 변수라는 것을 알려주는 구분
		this.date = date;
	}// 생성자 오버로딩
}


/*======================================================================*/

Day09_java/ClassEx08.java
생성자 또는 메서드{} 블록내에서 클래스 소속의 멤버변수 중 인스턴스 변수와 생성자나 메서드 소속의 매개변수명이 동일 할 때
인스턴스 변수명앞에 this.을 붙이면 구분이 되어져서 값이 저장된다.

class Board08{
	private String name;
	private String title;
	private String content;

	public Board08() {} // 매개변수가 없는 기본생성자

	public Board08(String name, String title, String content){
		this.name = name;
		this.title = title;
		this.content = content;
	} // 생성자 오버로딩

	public void print(){
		System.out.println("글쓴이 : " + name + ", 제목 : " + title + ", 내용 : " + content);
	}
}
public class ClassEx08{
	public static void main(String[] args){
		Board08 board = new Board08("홍길동", "게시판 제목입니다.", "게시판 내용입니다");
		board.print();
	}
}

/*======================================================================*/

Day09_java/ClassEx09.java
같은 클래스내에서 오버로딩 된 다른 생성자를 호출할 때는 this()를 사용한다.

class MyDate09{
	private int year;
	private int month;
	private int date;

	public MyDate09(){
		this(2025,12,23); // 같은 클래스내에서 오버로딩 된 다른 생성자를 호출
	}// 매개변수가 없는 기본생성자

	public MyDate09(int year, int month, int date){
		this.year = year;
		this.month = month;
		this.date = date;
	}// 생성자 오버로딩
}

/*======================================================================*/

Day09_java/ClassEx10.java
자바에서 생성자가 오버로딩이 안되었을 때는 컴파일러가 메개변수가 없는 기본생성자를 묵시적으로 제공한다.
하지만 생성자가 오버로딩이 되면 기본생성자 묵시적 제공을 하지 않는다. 이런 경우 기본생성자를 호출하려다가
'컴파일에러가 발생하는 예제소스' 이다.
class Data10{
	int value; //클래스 소속의 멤버변수(속성)중 인스턴스 변수
	
	// 생성자 오버로딩이 되어서 기본생성자 묵시적 제공을 안함

	//Data10(){ } // 2. 해결방안 | 기본생성자를 호출해서 컴파일 에러 해결
	Data10(int value){
		this.value = value;
	}// 매개변수 개수가 다른 생성자 오버로딩

	void pr(){
		System.out.printf("value = %d \n", value);
	}// 사용자 저으이 메서드 pr()
}// Data10 class

public class ClassEx10{
	public static void main(String[] args){
		//new Data10(100).or(); // 1. 해결방안 | 오버로딩 생성자 호출 컴파일 에러 해결
		new Data10().pr();
		// new Data10();에 의해서 묵시적으로 제공되지 않는 기본생성자를 호출하려다가 컴파일 에러가 발생함
	}
}

/*======================================================================*/

Day09_java/ClassEx11.java
this()에 의해서 같은 클래스내에서 오버로딩 된 다른 생성자를 호출해 본다.

class Car11{
	String color; // 차 색상
	String gaerType; // 변속기 종류 : auto(자동), 수동
	int door; // 문의 개수

	Car11(){
		this("white", "auto", 4); // 같은 클래스내에서 매개변수 3개짜리 오버로딩 된 생성자를 호출
	}

	Car11(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}// 매개변수 개수가 다른 생성자 오버로딩

	void print(){
		System.out.println("차색상 : " + color + ", 변속기 종류 : " + gearType + ", 차문 개수 : " + door);
	}
}// Car11 class

/*======================================================================*/

Day09_java/ClassEx12.java
생성자 오버로딩에 관한 예제

class Car12{
	String color;
	String gearType;
	int door;

	/*
	 * 클래스 소속의 멤버변수를 명시적 코드로 초기화를 하지 않으면 자바는 다음과 같은 기본값으로 초기화를 한다.
	 * 참조 즉 레퍼런트 타입 : null, boolean 타입 : false
	 * byte,short,int : 0, long : 0L, float : 0.0f, double : 0.0 또는 0.0d
	 */

	Car12(){ // 매개변수가 없는 기본생성자
		this("white", "auto", 4); // 같은 클래스내의 배개변수 3개짜리 오버로딩 된 다른 생성자를 호출
	}
	
	Car12(Car12 c){ // 생성자를 이용한 객체 복사 | car01객체 주소를 받아오지만 주소 변수의 값만 복사
		color = c.color; // car01 주소의 color 값만 저장
		gearType = c.gearType; // car01 주소의 gearType 값만 저장
		door = c.door; // 값만 복사
	}// 생성자 오버로딩

	Car12(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

	void pr(){
		System.out.printf("차색상 : %s, 변속기 종류 : %s, 차문 개수 : %d \n", color, gearType, door);
	}

}
public class ClassEx12{
	public static void main(String[] args){

		Car12 car01 = new Car12(); // car01 참조변수 | new Car12(); 객체 생성
		car01.pr();
		Car12 car02 = new Car12(car01); // 생성자 인자값으로 car01객체 전달 (주소전달)

		car01.door = 6;
		car01.pr();	// 차문 개수가 4에서 6으로 변경
		car02.pr(); // car01과 car02는 서로 다른 객체주소를 가진다. 그러므로 값도 다른값을 가진다.
	
	}
}


/*======================================================================*/

Day09_java/ClassEx13.java
클래스 초기화 블록, 인스턴스 초기화 블록

public class ClassEx13{
	int a;

	static {
		/*
		클래스 초기화 블록으로 해당 클래스가 로드 실행될 떄 같이 딱 한번 만 실행한다.
		이 초기화 블록은 static 키워드로 정의하고 정적변수 초기화에 사용된다.
		*/
	}

	{
		a = 100;
		/*
		이 영역은 인스턴스 초기화 블록{}이다. 클래스 소속 멤버변수 중 객체 생성해서 접근하는 인스턴스 변수
		초기화에 사용한다. 인스턴스 초기화 블록은 생성자와 같이 객체가 생성될 때 마다 실행한다.
		주의할 것은 인스턴스 변수 초기화에는 주로 생성자를 사용하고 모든 생성자에서 공통으로 사용되는 코드 부분은
		인스턴스 초기화 블록에서 사용한다.
		*/
	}

	public ClassEx13(){
		/*
		생성자 보다 인스턴스 초기화 블록이 먼저 실행된다.
		*/
	}

	public static void main(String[] args){
		new ClassEx13(); // 먼저 인스턴스 초기화 블록을 실행하고 난 다음 생성자를 호출
		new ClassEx13(); // 객체가 생성될 때 마다 인스턴스 초기화 블록과 생성자를 호출
		ClassEx13 cex13 = new ClassEx13();
	}
}



