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

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/


