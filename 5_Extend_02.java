Day12_java/Ex16_2.java

/* 16장.상속.pdf No.20쪽 1번문제)
 *  강의 교안 소스 중에서 접근 권한이 잘못된 번호를 기술하고, 보다 더 좋은 OOP(객체지향 프로그래밍) 자바 코드로
 *  변경해 본다.(불필요한 코드 제거)
 * 
 */
// 잘못된 부분 정답 번호는 [1]번 과 [5]번 과 [9]
class Parent02 { // extends Object이 생략됨
	private int a;
	int b;
	protected int c;
	public int d;
}// 부모클래스 Parent02

class Child02 extends Parent02 {
	public Child02(int a, int b, int c, int d) {
		//this.a = a; // [1]	정답 -> 부모 Parents02에서 private 으로 정의된 멤버변수 a는 같은 패키지의 자손클래스에서 접근 못함
		this.b = b; // [2]
		this.c = c; // [3]
		this.d = d; // [4]
	}// 매개변수가 다른 생성자 오버로딩

	void func() {
		//System.out.println(a); // [5] 정답
		System.out.println(b); // [6]
		System.out.println(c); // [7]
		System.out.println(d); // [8]
	}// 사용자 정의 메서드 func()
}// 자손클래스 Child02

public class Ex16_2 {

	public static void main(String[] args) {
		Child02 one = new Child02(1, 2, 3, 4);
		one.func();
	}

}
////////////////////////////////////////////////////////////
class Parent {
	private int a; // 같은 클래스에서만 사용가능한 멤버변수
	int b;
	protected int c;
	public int d;
	
	public Parent(int a, int b, int c, int d) {
		this.a = a;
		this.b = b; 
		this.c = c; 
		this.d = d; 
	}
	
	protected int getA() {
		return a;
	}
}

class Child extends Parent {
	public Child(int a, int b, int c, int d) {
		super(a, b, c, d);
	}

	void func() {
		System.out.println(getA()); // [5]
		System.out.println(b); // [6]
		System.out.println(c); // [7]
		System.out.println(d); // [8]
	}
}

public class Ex16_2 {

	public static void main(String[] args) {
		Child one = new Child(1, 2, 3, 4);
		one.func();
	}

}

/*======================================================================*/

Day12_java/Ex16_3.java

/* 16장.상속.pdf No.21쪽 2번문제)
 *  상속 구조에서 생성자의 호출 순서를 알아보기 위한 문제이다. 이 부분을 확인해 보고, 부모클래스 멤버변수를 상속받아서
 *  자손에게 출력시키는 메서드 public void pr(){} 사용자 정의 메서드를 정의해 본다.
 */

class Parent03 {
	protected int a, b, c;

	public Parent03() {
		super(); // 생략가능함. 최고 조상 부모클래스 Object 의 기본생성자 호출
		System.out.println("1.Parent03 클래스의 디폴트 생성자 호출");
	}// 기본 생성자

	public Parent03(int a, int b, int c) {
		// super(); 가 생략됨
		System.out.println("3.Parent03 클래스의 전달인자 3개짜리 생성자 호출");
		this.a = a;
		this.b = b;
		this.c = c; // 생성자의 주된 기능인 인스턴스 변수 초기화
	}// 매개변수 3개짜리 오버로딩 생성자
}// Parent2 부모클래스

class Child03 extends Parent03 {
	public Child03() {
		System.out.println("2.Child03 클래스의 디폴트 생성자 호출");
	}// 기본 생성자

	public Child03(int a, int b, int c) {
		super(a, b, c); // 부모클래스 오버로딩 된 생성자 호출
		System.out.println("4.Child03 클래스의 전달인자 3개짜리 생성자 호출");
	}

	public void pr() {
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
	}

}// Child2 자손클래스

public class Ex16_3 {

	public static void main(String[] args) {
		Child03 one = new Child03(); // 자손의 기본생성자 호출
		one.pr();// 0, 0, 0
		Child03 two = new Child03(10, 20, 30);// 자손의 매개변수 3개짜리 오버로딩 된 생성자를 호출
		two.pr();// 10, 20, 30

	}

}


////////////////////////////////////////////////////////////

class Parent2{
	protected int a, b, c;
	
	public Parent2() {
		System.out.println("1.Parent2 클래스의 디폴트 생성자 호출");
	}// 기본 생성자
	
	public Parent2(int a, int b, int c) {
		System.out.println("3.Parent 클래스의 전달인자 3개짜리 생성자 호출");
		this.a = a;
		this.b = b;
		this.c = c;
	}// 매개변수 3개짜리 오버로딩 생성자
}// Parent2 부모 클래스

class Child2 extends Parent2{
	public Child2() {
		System.out.println("2.Child2 클래스의 디폴트 생성자 호출");
	}// 기본 생성자
	
	public Child2(int a, int b, int c) {
		super(a, b, c);
		System.out.println("4.Child2 클래스의 전달인자 3개짜리 생성자 호출");
	}
	
	public void pr() {
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
	}
	
}// Child2 자손 클래스
public class Ex16_3 {

	public static void main(String[] args) {
		Child2 one = new Child2();
		Child2 two = new Child2(10, 20, 30);
		one.pr();
		two.pr();		

	}

}
/*======================================================================*/

Day12_java/Ex16_4.java

/* 16장.상속.pdf No.23쪽 3번문제)
 * 문제는 강의교안 참고한다. 추가적인 문제는 부모클래스 메서드내에서 if~else문 대신 if문만 사용해도 된다.
 * 부모클래스 각 메서드내의 실행문장으로 '소녀는 사람이다', '사람은 2발로 걷는다'로 처리하고 Dog동물 자손클래스에서
 * 부모클래스 각 메서드를 오버라이딩을 한다음 실행문장으로 if문만 사용해서 '강아지는 동물이다', '강아지는 4발로 걷는다.'가
 * 출력되는 자바코드를 완성해 본다.
 */

class Animal04 {// extends Object이 생략됨
	protected String kind; // 어떤 종인지 저장할 변수(사람,강이지)
	protected int leg; // 다리개수

	public Animal04() {
	}// 매개변수가 없는 기본생성자

	public Animal04(String kind, int leg) {
		this.kind = kind;
		this.leg = leg;
	}// 매개변수 개수가 다른 생성자 오버로딩

	public void printKind() {
		if (kind.equals("소녀")) {// String 문자열 참조타입 내장클래스 하위의 equals() 메서드는 객체주소를 비교하지 않고
								// 문자열 내용값만 비교한다. 문자열 내용이 같으면 true, 다르면 false -> 문자열 값이
								// 같다 다르다 비교는 ==(같다) 비교 연산을 사용하지 않고 equals()메서드르르 사용해야 한다.
			System.out.println(kind + "는 사람이다.");
		}
	}// printKind() 사용자 저으이 메서드

	public void walk() {
		if (leg == 2) {
			System.out.println("사람은 " + leg + " 발로 걷는다.");
		}
	}// walk() 사용자 정의 메서드

}// Animal04 부모클래스

class Dog04 extends Animal04 {
	public Dog04() {
	}

	public Dog04(String kind, int leg) {
		super(kind, leg);// 부모클래스 매개변수 2개짜리 오버로딩 된 생성자 호출
	}

	@Override
	public void printKind() {// 메서드 오버라이딩
		if (kind.equals("강아지")) {
			System.out.println(kind + "는 동물이다.");
		}
	}

	@Override
	public void walk() {
		if (leg == 4) {
			System.out.println(kind + "는 " + leg + "발로 걷는다.");
		}
	}

}// 첫번째 자손클래스 Dog04

class Human04 extends Animal04 {
	public Human04() {
	}

	public Human04(String kind, int leg) {
		super(kind, leg);
	}
}// Human04 두번째 자손클래스

public class Ex16_4 {

	public static void main(String[] args) {
		Dog04 d = new Dog04("강아지", 4);
		d.printKind();
		d.walk();

		Human04 h = new Human04("소녀", 2);
		h.printKind();
		h.walk();

	}

}


///////////////////////////////////////////////////////////////

class Animal {
	protected String kind;
	protected int leg;

	public Animal(String kind, int leg) {
		this.kind = kind;
		this.leg = leg; // 생성자의 주된 기능인 인스턴스 변수 초기화
	}// 매개변수 2개까지 오버로딩 생성자

	public void getKind() {
		if ("소녀".equals(kind)) {
			System.out.println("소녀는 사람이다.");
		}
	}// 어떤 동물인지 알려주는 메서드

	public void walk() {
		if (leg == 2) {
			System.out.println("사람은 2발로 걷는다.");
		}

	}// 어떻게 걷는지 알려주는 메서드
}// Animal 부모클래스

class Dog extends Animal {
	public Dog(String kind, int leg) {
		super(kind, leg); // 부모클래스 오버로딩된 생성자 호출
	}
	
	@Override
	public void getKind() {
		if ("강아지".equals(kind)) {
			System.out.println(kind + "는 동물이다.");
		}
	}

	@Override
	public void walk() {
		if (leg == 4) {
			System.out.println(kind + "는 " + leg + "발로 걷는다.");
		}
	}
}// Dog 자손클래스

class Human extends Animal {
	public Human(String kind, int leg) {
		super(kind, leg); // 부모클래스 오버로딩된 생성자 호출
	}
}// Human 자손클래스

public class Ex16_4 {

	public static void main(String[] args) {
		Dog d = new Dog("강아지", 4);
		Human h = new Human("소녀", 2);

		d.getKind();
		d.walk();
		h.getKind();
		h.walk();

	}

}

/*======================================================================*/

Day12_java/Ex16_5.java

/* 16장.상속.pdf No.26쪽 4번문제)
 *  강의 교안 문제와 UML 클래스 다이어 그램을 보고 클래스 설계 자바 코드를 완성해 본다.
 */

class HandPhone05 extends Object{//extends Object은 생략가능
	protected String model; //폰모델
	protected String number;//폰번호
	
	public HandPhone05() { }
	
	public HandPhone05(String model, String number) {
		this.model = model;
		this.number = number;
	}//매개변수 개수가 다른 생성자 오버로딩
	
}// HandPhone05 부모클래스

class DicaPhone05 extends HandPhone05{
	protected String pixel;//화소수
	
	public DicaPhone05() { }
	
	public DicaPhone05(String model, String number, String pixel) {
		super(model, number);//부모클래스 오버로딩 된 생성자 호출
		this.pixel = pixel;
	}
	
	public void prnDicaPhone() {
		System.out.println("모델명 : " + model + ", 폰번호 : " + number + ", 화소수 : " + pixel);
	}
}// DicaPhone05 자손클래스
public class Ex16_5 {

	public static void main(String[] args) {
		
		DicaPhone05 dp = new DicaPhone05("아이폰", "010-9999-9999", "2780");
		dp.prnDicaPhone();
		
	}

}

//////////////////////////////////////////////////////////////////////

class HandPhone {
	protected String model;
	protected String number;

	public HandPhone(String model, String number) {
		this.model = model;
		this.number = number; // 생성자의 주된 기능인 인스턴스 초기화
	}// 매개변수 2개짜리 오버로딩 생성자

}// HandPhone 부모클래스

class DicaPhone extends HandPhone {
	protected String pixel;

	public DicaPhone(String model, String number, String pixel) {
		super(model, number); // 부모클래스에서 오버로딩된 생성자 호출
		this.pixel = pixel;
	}// 매개변수 3개 짜리 오버로딩 생성자
	
	public void prnDicaphone() {
		System.out.println("모델명 : " + model + " 번호 : " + number + " 화소수 : " + pixel);
	}// 사용자 정의 메서드
	
}// DicaPhone 자손 클래스

public class Ex16_5 {

	public static void main(String[] args) {

		DicaPhone dp = new DicaPhone("갤럭시", "010", "1024");
		dp.prnDicaphone();

	}

}

/*======================================================================*/

Day12_java/Ex16_6.java

/*
 * 16장.상속.pdf No.28쪽 5번문제)
 */

class TestSuper {
	int i; //클래스 소속의 멤버변수 중 인스턴스 변수(속성) 정의, 초기 기본값 0
	
	TestSuper(){ } // 부모클래스에서 기본생성자 정의
	
	TestSuper(int i) {
		this.i = i;
	}// 생성자가 오버로딩 되면 매개변수가 없는 기본생성자 묵시적 제공을 안함
	
	//생성자가 오버로딩 되면 자바는 기본생성자를 묵시적으로 제공하지 않는다.
	
}

class TestSub extends TestSuper{ 
	/*
	 * 답안) 컴파일 에러가 발생하는 이유는 부모클래스 생성자 오버로딩이 되면 부모의 기본생성자를 더이상 묵시적 제공을 하지 않는다.
	 *      그런데 자손에서 부모의 묵시적으로 제공되지 않는 기본생성자를 호출할려다가 에러가 발생하는 것이다.
	 */
	// 자손의 기본생성자 묵시적으로 생략됨
	
}

public class Ex16_6 {

	public static void main(String[] args) {
		new TestSub();// 자손의 기본생성자를 호출
	}

}

/*======================================================================*/

Day12_java/Ex16_7.java
/*
 * 16장.상속.pdf No.29쪽 6번문제)
 * 문제와 자바소스는 강의교안을 참조하고 이 소스의 실행 결과를 주석문으로 처리해 보자.
 */
class Base{//extends Object 생략
	Base(){
		super();//생략가능함. 최상위 부모클래스 Object의 기본생성자를 호출하면서 끝이 남.
		System.out.print("Base");
	}// 기본 생성자
}// 부모클래스 Base 

class Alpha extends Base{
	//기본생성자 묵시적 생략됨
}// 자손클래스 Alpha
public class Ex16_7 {

	public static void main(String[] args) {
		new Alpha(); // Base
		new Base();  // Base
		/*
		 * 답안) BaseBase
		 * 생성자는 상속되지 않는다.
		 * 자손클래스에서 new Alpha();에 의해서 생성자를 호출하면 자바는 먼저 
		 * 부모클래스 기본생성자를 먼저 호출하도록 설계 되어져 있다.
		 */
	}

}

/*======================================================================*/

Day12_java/Ex16_9.java
/*
 * 16장.상속.pdf No.31쪽 8번문제)
 * 문제와 소스는 강의교안을 참조하고 소스에서 컴파일 에러가 나는 이유에 대해서 주석문 처리한다.
 */

class A{
	public A() {
		//super(); 가 생략됨
		System.out.println("hello from a");
	}
}

class B extends A{
	public B() {
		super();
		System.out.println("hello from b");		
		//super(); 
		/* 여기서 컴파일 에러가 발생하는 이유는 부모클래스 생성자를 호출할 때는 생성자 {} 내에서 항상 맨 첫줄에 와서 
		가장 먼저 호출해야 하기 때문이다.*/
		
	}
}
public class Ex16_9 {

	public static void main(String[] args) {
		new B();
		/*
		 * 답안) hello from a
		 *      hello from b
		 *
		 */
	}

}

/*======================================================================*/

Day12_java/RefCastEx01.java

/*
 * 자바에서 레퍼런스 간의 형변환 중 업캐스팅 특징)
 *  1. 업캐스팅을 할려면 사전에 상속 관계를 만들어야 한다.
 *  2. 업캐스팅이란 자손타입이 부모타입으로 올라가는 현상을 말한다. 업캐스팅은 암묵적인 자동형 변환을 해준다.
 *  
 */

class Mother01 extends Object{

	public void m01(){
		System.out.println("부모클래스 메서드 m01()");
	}
}

class Son01 extends Mother01{
	public void s01(){
		System.out.println("자손클래스 메서드 s01()");
	}
}
public class RefCastEx01{
	public static void main(String[] args){
		Mother01 m01 = new Son01();//업캐스팅
		m01.m01(); // 부모클래스 메서드 호출

		Object obj01 = new Son01();// Mother01 부모를 건너뛰고 최고 조상 Object타입으로 업캐스팅
	}
}
/*======================================================================*/

Day12_java/RefCastEx02.java
/*
 * 자바에서 다운캐스팅은 자동형 변환이 안되기 때문에 명시적인 캐스팅 형변환 연산자를 사용해서 강제 다운캐스팅을 해야한다.
 * 그렇지 않으면 컴파일 에러가 발생한다.
 */

class Mother02{
	void m02(){
		System.out.println("부모클래스 메서드 m02()");
	}
}

class Son02 extends Mother02{

	void s02(){
		System.out.println("자식클래스 메서드 s02()");
	}
}

public class RefCastEx02{
	public static void main(String[] args){
		Mother02 m02; //부모타입으로 참조변수 선언
		m02 = new Son02(); //업캐스팅
		Son02 s02 = m02;// 명시적인 캐스팅 연산자를 사용하지 않고 다운캐스팅 시도해서 컴파일 에러가 발생
		//Son02 s02 = (Son02)m02;// 명시적인 캐스팅 연산자 사용
		s02.m02();
		s02.s02();
	}
}
/*======================================================================*/

Day12_java/RefCastEx03.java

/*
 * 자바의 레퍼런스간의 형변환 중 다운캐스팅 특징)
 *  1. 다운캐스팅은 부모 타입을 자손타입으로 내리는 것을 말한다.
 *  2. 다운캐스팅을 하려면 사전에 상속관계를 만들어야 한다.
 *  3. 다운캐스팅을 하려면 사전에 업캐스팅을 해야 한다.
 *  4. 다운캐스팅을 하러면 자동형 변환이 안되기 때문에 명시적인 형변환 즉 캐스팅 연산자를 사용해서 강제 다운캐스팅을 해야 한다.
 */

class Mother03{
	void m03(){
		System.out.println("부모클래스 메서드 m03()");
	}
}

class Son03 extends Mother03{
	void s03(){
		System.out.println("자손클래스 메서드 s03()");
	}
}
public class RefCastEx03{
	public static void main(String[] args){
		Object obj = new Son03();// 사전에 업캐스팅 -> 암묵적인 자동형 변환
		Mother03 m03 = (Mother03)obj;// 명시적인 캐스팅연산자를 사용한 다운캐스팅
		m03.m03();
		Son03 s03 = (Son03)obj; // 명시적인 다운캐스팅
		s03.m03(); // 상속받아서 호출
		s03.s03(); // 자신이 자손에서 정의된 메서드 호출
	}
}
/*======================================================================*/

Day12_java/RefCastEx04.java
/*
 * 레퍼런스간의 형변환 중 하나인 다운캐스팅을 할 때 사전에 업캐스팅을 하지 않고 명시적인 다운캐스팅을 하면
 * javac 컴파일 명령어에 의해서 정상적인 컴파일은 되지만 컴파일 된 바이트 코드 클래스 파일을 java 명령어 에 의해서
 * 실행시 캐스팅 연산 예외 오류를 발생시킨다. 그래서 나온 것이 instanceof 연산자이다.
 */

class Mother04 extends Object{// extends Object 은 생략 가능
	void m04(){
		System.out.println("부모클래스 메서드 m04()");
	}
}

class Child04 extends Mother04{
	void ch04(){
		System.out.println("첫번쨰 자손클래스 메서드 ch04()");
	}
}// 첫번째 자손클래스

class Child05 extends Mother04{
	void ch05(){
		System.out.println("두번째 자손클래스 메서드 ch05()");
	}
}// 두번째 자손클래스

public class RefCastEx04{
	public static void main(String[] args){

		//Mother04 m04 = new Mother04(); // 사전에 업캐스팅을 안함
		//Child04 ch01 = (Child04)m04; // 명시적인 다운캐스팅을 함 -> 하지만 사전에 업캐스팅을 하지 않아서
		                             // 컴파일된 클래스르르 실행시 캐스팅 연산 예외 오류가 발생

		System.out.println("\n ===============================>");

		Object obj = new Child05(); // 두번쨰 자손인 Child05를 사전에 업캐스팅을 함
		Mother04 mother05 = (Mother04)obj; // 명시적인 다운캐스팅
		mother04.m04();

		Child05 child05 = (Child05)obj;
		child05.m04(); // 상속받아서 호출
		child05.ch05(); // 두번째 자손에서 정의된 메서드 호출
	}
}
/*======================================================================*/

Day12_java/RefCastEx05.java
/*
 * instanceof 형변환(레퍼런스간의 업캐스팅과 다운캐스팅) 유무 판단 연산자
 */

class HandPhone06 extends Object{
	protected String model;//폰모델명
	protected String number;//폰번호

	public HandPhone06(){}// 기본 생성자

	public HandPhone06(String model, String number){
		this.model = model;
		this.number = number;
	}// 매개변수 개수가 다른 생성자 오버로딩
}

class DicaPhone06 extends HandPhone06{
	protected String pixel; //화소수

	public DiacaPhone06(String model, String number, String pixel){
		super(model, number);
		this.pixel = pixel;
	}

	public void printDicaPhone(){
		System.out.println("폰모델 : " + model + ", 폰번호 : " + number + ", 화소수 : " + pixel);
	}// 사용자 정의 메서드

}// DicaPhone06 자손클래스
public class RefCastEx05{
	public static void main(String[] args){

		DicaPhone06 dp = new DicaPhone06("아이폰", "010-7777-7777", "2056");
		// 매개변수 3개짜리 자손의 오버로딩 된 생성자 호출
		dp.printDicaPhone();

		if(dp instanceof HandPhone06){// dp는 HandPhone06 부모타입으로 업캐스티잉 가능한가? 참
			HandPhone06 hp = dp;//업캐스팅
			System.out.println("업캐스팅이 가능합니다.");
		}else{
			System.out.println("업캐스팅이 불가능 합니다.");
		}// if else

		System.out.println("\n =================================> \n");

		HandPhone06 hp = new HandPhone06(); // 사전에 업캐스팅을 안함
		if(hp instanceof DicaPhone06){// hp는 자손타입으로 다운캐스팅이 가능한가? 거짓
			DicaPhone06 dp05 = (DicaPhone06)hp;
			System.out.println("다운캐스팅이 가능합니다.");
		}else{
			System.out.println("사전에 업캐스팅을 하지 않아서 명시적인 다운캐스팅 불가능 합니다.");
		}
	}
}

/*======================================================================*/

Day12_java/RefCastEx06.java
/*
 * 업캐스팅 이후 오버라이딩 한 메서드를 호출한다.
 */

class Mother06{
	public void m06(){
		System.out.println("부모클래스 메서드 m06()");
	}
}

class Child06 extends Mother06{
	public void ch06(){
		System.out.println("자손클래스 메서드 ch06()");
	}

	@Override
	public void m06(){
		System.out.println("자손에서 오버라이딩 한 메서드 m06()");
	}
}
public class RefCastEx06{
	public static void main(String[] args){
		Mother06 m06 = new Child06();// 업캐스팅
		m06.m06()// 업캐스팅 이후 자손에서 오버라이딩 한 메서드 호출
		/*
		 * 메서드가 오버라이딩 한 경우 부모에도 동일 메서드 원혀잉 있고 자손에도 같은 메서드명이 있다.
		 * 이런 경우에는 참조변수 m06이 실제 가리키는 객체타입이 누구인지에 따라서 호출되는 메서드명이 결정된다.
		 * 여기서는 자손타입인 Child06 객체주소를 가리키고 있기 때문에 자손에서 오버라이딩한 메서드를 호출
		 */
	}
}
/*======================================================================*/

Day12_java/RefCastEx07.java

/*
 * instanceof 연산자는 레퍼런스간의 형변환(업캐스팅/다운캐스팅) 유무 판단 연산자이다.
 * 다운캐스팅을 할 때 캐스팅 연산 예외 오류가 나는 것을 방지하기 위해서는 if조건문과 함께 사용한다.
 */

class Car07 extends Object {

}

class FireEngine07 extends Car07 {

}

public class RefCastEx07 {

	public static void main(String[] args) {

		FireEngine07 fe = new FireEngine07();

		if (fe instanceof Car07) {// fe가 부모타입 Car07로 업캐스팅이 가능한가? 참
			Car07 car = fe;// 업캐스팅
			System.out.println("업캐스팅이 가능합니다.");
		}

		if (fe instanceof Object) {// fe가 최고 조상 Object타입으로 업캐스팅이 가능한가? 참
			Object obj = fe;
			System.out.println("Object타입으로 업캐스팅이 가능합니다.");
		}

		Object obj = new FireEngine07();// 사전에 업캐스팅 함

		if (obj instanceof FireEngine07) {// obj가 FireEngine07 자손타입으로 다운캐스팅이 가능한가? 참 ->
										  // 사전에 업캐스팅을 했기 때문에 다운캐스팅 가능함
			FireEngine07 fe07 = (FireEngine07) obj;
			System.out.println("명시적인 다운캐스팅이 가능합니다.");
		}else {
			System.out.println("다운캐스팅이 불가능합니다.");
		}//if else
	}

}

/*======================================================================*/

Day12_java/RefCastEx08.java

/*
 * 1. 부모와 자손에서 동일한 멤버변수명이 정의된 경우에 호출되는 변수 결정은 참조변수 타입에 의해서 결정된다.
 * 2. 업캐스팅 이후 오버라이딩 한 메서드 호출은 참조변수가 실제 가리키는 객체 타입에 의해서 결정된다.
 */

class Mother08{
	int x = 100;

	void m08(){
		System.out.println("부모클래스 메서드 m08()");
	}
}

class Child08 extends Mother08{
	int x = 200; // 부모와 동일 멤버변수명 정의

	@Override
	void m08(){
		System.out.println("오버라이딩 한 메서드 m08()");
	}
}
public class RefCastEx08{
	public static void main(String[] args){

		Mother08 m = new Child08();// 업캐스팅

		System.out.println("m.x = " + m.x);
		// 100 -> 부모와 자손에서 동일한 멤버변수명이 정의된 경우에는
		// 호출되는 멤버변수 결정은 참조변수 m에 의해서 결정된다. 여기에서 부모타입인
		// Mother08이기 때문에 부모에서 정의되 멤버변수명이 호출된다.

		m.m08();// 업캐스팅 이후 오버라이딩 한 메서드 호출은 참조변수 m이 실제 가리키는 객체타입에 의해서
		        // 결정된다. 여기서는 자손 Child08이기 때문에 오버라이딩 한 메서드를 호출한다.

		Child08 ch = (Child08)m; // 명시적인 다운캐스팅
		System.out.println("ch.x = " + ch.x); //200
		ch.m08();// 오버라이딩 한 메서드 호출


	}
}
/*======================================================================*/

Day12_java/Ex17_01.java

/*
 * 17장.레퍼런스 형 변환.pdf No.19쪽 2번 문제)
 *  소스는 강의 교안을 참조하고 명시적인 다운캐스팅을 할 때 if 조건문과 instanceof 연산자를 추가하여 true인 경우만 안전하게
 *  명시적인 다운캐스팅이 되게 소스를 변경해 본다. 이렇게 하면 보다 더 자바 OOP(객체지향프로그래밍)에 가까운 코드가 된다.
 *  SubClass 부모클래스에 리턴타입이 없는 void형 pr(){} 메서드를 정의하고 다운캐스팅한 foo로 해당 메서드를 호출해서 
 *  멤버변수 i 값을 출력되게 해 본다.
 */

class SubClass{
	int i = 3;
	
	void pr() {
		System.out.println("i = " + i);
	}
}

public class Ex17_01 {

	public static void main(String[] args) {
		
		Object obj = new SubClass(); // 사전에 업캐스팅 함
		if (obj instanceof SubClass) { // obj가 SubClass 자손타입으로 다운캐스팅이 가능한가? 참 ->
			                         // 사전에 업캐스팅을 했기 때문에 다운캐스팅 가능함
			SubClass foo = (SubClass)obj; // 명시적인 다운캐스팅
			foo.pr();
		}

	}

}

/*======================================================================*/

Day12_java/Ex17_02.java

/*
 * 17장.레퍼런스 형 변환.pdf No.20쪽 3번 문제)
 * 상속관계에서 업캐스팅 이후 오버라이딩 한 메서드를 호출에 관한 문제이다. 출력 결과물을 주석문 처리해서 보여주고
 * 어떤 부분만 추가해서 보다 더 나은 자바 OOP에 근접한 코드로 변경해 본다.
 * 
 */

class Super {
	public int getNumber(int a) {
		return a + 1;
	}
}

class CastingEx03 extends Super {

	@Override
	public int getNumber(int a) {
		return a + 2;
	}

}

public class Ex17_02 {

	public static void main(String[] args) {

		Super a = new CastingEx03();
		System.out.println(a.getNumber(0)); // 2

	}

}