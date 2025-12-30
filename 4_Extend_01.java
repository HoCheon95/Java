
Day11_java/ExtendEx01.java

/*
자바 클래스 상속문법 형식)
class 자손클래스 extends 부모클래스{

} 클래스 상속은 하나의 부모로부터 단일 상속만 가능하다.
*/

class Parent01{	// extends Object 이 생략됨. 자바 클래스는 명시적인 상속을 받지 않으면 묵시적으로
				// 최상위 부모클래스 Object로 부터 상속받는다.
	public void parentPrn(){
		System.out.println("부모 클래스 Parent01의 메서도 parentPrn() 호출");
	}
}

class Child01 extends Parent01{

	public void childPrn(){
		System.out.println("자손 클래스 Child01의 메서드 childPrn() 호출");
	}
}

public class ExtendEx01{
	public static void main(String[] args){

		Child01 child = new Child01();
		child.parentPrn();	// 부모로부터 상속받아서 호출
		child.childPrn();	// 자손에서 정의된 메서드 호출

		Parent01 p = new Parent01();
		p.parentPrn();	// 부모 클래스에서 정의된 메서드 호출
						// 부모클래스 객체로 자손 클래스에서 정의된 메서드 호출 불가
	}
}

/*======================================================================*/

Day11_java/ExtendEx02.java

class Point2D extends Object{ // extends Object은 묵시적 생략 가능
	public int getX() { // 값 반환 getter() 메서드 정의 || setter getter 단축키 알트 ins
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	private int x;
	private int y;
	
}

class Point3D extends Point2D{
	private int z;
	
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
public class ExtendEx02 {

	public static void main(String[] args) {
		
		Point3D pt = new Point3D();
		pt.setX(100);
		pt.setY(200);
		pt.setZ(300);
		
        System.out.println("x 좌표값: " + pt.getX());  // 상속받아서 사용
        System.out.println("y 좌표값: " + pt.getY());  // 상속받아서 사용
        System.out.println("z 좌표값: " + pt.getZ());		
		
	}

}


/*======================================================================*/

Day11_java/ExtendEx03.java

/*
 * 메서드 오버라이딩과 오버로딩의 차이점)
 * 1. 오버러딩 이란?
 *  상속과 관련이 없다. 동일한 같은 클래스내에서 같은 이름의 메서드명을 중복해서 여러번 정의하는 것을 말한다.
 * 
 * 2. 오버라이딩?
 *  - 오버라이딩을 하기 위해서 사전에 반드시 상속관계를 만들어야한다.
 *  - 상속관계에서 부모의 메서드명, 메서드 리턴타입, 매개변수 타입과 개수 모두 동일한 원형을 자손에서 상속받은 상태에서
 *  - 자손에 맞게 {} 중괄호 내의 본문 실행문장을 변경 수정하는 것을 메서드 오버라이딩이라고 한다.
 *  
 *  주의할 것은 생성자는 상속되지 않는다. 그러므로 생성자 오버로딩 문법은 존재하지만 오버라이딩 문법은 없다.
 * 
 * 3. 상속관계에서 자손에서 부모의 메서드를 호출할 때는 super.메서드();를 사용 한다.
 */

class Parent03 {
	public void parent03() {
		System.out.println("부모클래스 메서드 parent03()");
	}// parent03 부모 클래스
}

class Child03 extends Parent03{
	public void child03() {
		System.out.println("자손클래스 메서드 child93()");
	}
	@Override // 부모 클래스 parent03 메서드 호출 (alt ins overriding)
	public void parent03() {
		super.parent03();
		System.out.println("오버라이딩 한 메서드 parent03()");
	}
}// Child03 자손 클래스

public class ExtendEx03 {

	public static void main(String[] args) {
		Child03 child03 = new Child03();
		child03.child03(); // 자손에서 정의된 메서드 호출
		child03.parent03(); // 오버라이딩 메서드 호출
		
		Parent03 p = new Parent03();
		p.parent03(); // 부모에서 정의된 메서드 호출
		//p.child03(); // 부모클래스 객체로 자손에서 정의된 메서드 호출 불가
	}

}

/*======================================================================*/

Day11_java/ExtendEx04.java

/*
 * 부모클래스의 멤버변수 중 인스턴스 변수(속성)명과 동일한 변수명이 자손에서 정의된 경우 부모로부터 상속받은
 * 해당 멤버변수명에 접근할 때는 super.변수명으로 하고, 자손에서 정의된
 * 동일 멤버변수명에 접근할 때는 this.명수명 으로 사용한다.
 */

class Parent04{
	protected int a = 100;
	protected int b = 200;
}

class Child04 extends Parent04{
	protected int a = 400;
	protected int b = 500;
	protected int c = 300;
	
	public void print() {
		System.out.println("super.a = " + super.a + ", super.b = " + super.b + ", super.c = " + this.c); //c변수명 앞의 this.는 생략가능
		System.out.println("this.a = " + this.a + ", this.b = " + this.b + ", this.c = " + this.c);
	}
}
public class ExtendEx04 {

	public static void main(String[] args) {
		Child04 child = new Child04();
		child.print();

	}

}

/*======================================================================*/

Day11_java/ExtendEx05.java

/*
 * 1. 생성자는 상속되지 않는다.
 * 2. 상속관계에서 부모클래스의 기본 생성자를 호출할 때는 super();를 사용한다.
 */

class Parent05 extends Object { // extends Object은 생략가능
	protected int x = 10;
	protected int y = 20;

	public Parent05() { // 매개변수가 없는 기본 생성자
		super(); // 생략 가능, 항상 첫줄에 와야 함. 최고 조상 Object 클래스의 기본 생성자를 호출하면서 생성자 호출은 끝이 남.
		System.out.println("부모 Parent05 기본생성자 호출");
	}
}// Parent05 부모 클래스

class Child05 extends Parent05 {
	protected int z = 30;

	public Child05() {
		// super(); 생략됨. 부모클래스 Parent05의 기본생성자 호출
		System.out.println("자손 Child05의 기본생성자 호출");
	}

	public void pr() {
		System.out.println("x = " + x + ", y = " + y + ", z = " + z);
	}
}// Child05 자손 클래스

public class ExtendEx05 {

	public static void main(String[] args) {

		Child05 child = new Child05(); // new Child05(); 에 의해 자손클래스 Child05 기본생성자 호출
		child.pr();

	}

}

/*======================================================================*/

Day11_java/ExtendEx06.java

/*
 * 상속에서 생성자 호출문제)
 * 부모클래스 생성자가 오버로딩이 되면 부모의 기본생성자 묵시적 제공을 하지 않는다.
 * 이런 경우 자손에서 부모의 기본 생성자를 호출하려다가 컴파일 에러가 발생하는 소스 예이다.
 */
class Parent06 { // extends Object 이 생략됨
	protected int a = 10;
	protected int b = 20;

	// 부모클래스 생성자가 오버로딩이 되면 매개변수가 없는 기본생성자 묵시적 제공 안함.

	public Parent06(int a, int b) {
		super(); // 생략가능, 최고 조상 부모클래스 Object의 기본생성자를 먼저 호출한다.
		this.a=a;
		this.b=b;
	}// 매개변수 개수가 다른 생성자 오버로딩
}// 부모클래스 Parent06

class Child06 extends Parent06 {
	protected int c = 30;

	public Child06() {
		// super(); 가 생략됨. 부모클래스 Parent06기본생성자를 먼저 호출할려다가 컴파일 에러가 발생
	}

	public void pr() {
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
	}
}

public class ExtendEx06 {

	public static void main(String[] args) {
		Child06 ch06 = new Child06();
		ch06.pr();

	}

}

/*======================================================================*/

Day11_java/ExtendEx07.java

/*
 * 상속에서 부모클래스의 생성자가 오버로딩이 되면 부모의 기본생성자를 묵시적 제공을 하지 않는다. 그러다 보니
 * 자손에서 부모의 묵시적으로 제공하지 않는 기본생성자를 호출할려다가 에러가 발생한다. 이를 해결하는 합리적 방법)
 * 	1. 부모의 기본생성자를 명시적 코드를 한다.
 * 	2. 자손에서 부모의 오버로딩 된 생성자를 호출하면 된다. 이것이 가장 합리적 해결법이다.
 */
class Parent07 {
	protected int a = 10;
	protected int b = 20;

	// public Parent07(){} // 기본생성자 명시적 코드

	public Parent07(int a, int b) {
		// super();가 생략
		this.a = a;
		this.b = b;
	}

}

class Child07 extends Parent07 {
	protected int c = 30;

	public Child07() {
		super(100, 200); // 부모클래스 오버로딩 된 생성자 호출
		this.c = 300;
	}
	
	public Child07(int a, int b, int c) {
		super(a,b);
		this.c=c;
	}// 매개변수 개수가 다른 자손의 생성자 오버로딩
	
	public void print() {
		System.out.println("a = " + a + ", b = " + b + ", C = " + c);
	}
}

public class ExtendEx07 {

	public static void main(String[] args) {
		
		Child07 child01 = new Child07();	//자손의 기본생성자 호출
		child01.print(); // 100, 200, 300
		
		Child07 child02 = new Child07(1000, 2000, 3000);	// 자손의 매개변수 3개짜리 오버로딩 된 생성자 호출
		child02.print(); // 1000, 2000, 3000

	}

}

/*======================================================================*/

Day11_java/ExtendEx08.java

/*
 * 부모클래스와 동일한 멤버변수명이 자손에서 정의된 경우 부모로 부터 상속받은 멤버변수명에 접근할 때는
 * super.변수명으로 하고, 자손에서 정의된 멤버변수명에 접근할 때는 this.변수명 또는 this.은 생략하고
 * 변수명으로 접근한다.
 */
class Parent08{// extends Object 이 생략됨
	int a = 10;
}// Parent08 부모클래스

class Child08 extends Parent08{
	int a = 20;
	
	void pr() {
		System.out.println("a = " + a); // this.이 생략됨. 20이 출력
		System.out.println("this.a = " + this.a); // 20 
		System.out.println("super,a = " + super.a); // 10
	}
}// Child08 자손클래스
public class ExtendEx08 {

	public static void main(String[] args) {
		Child08 child = new Child08();
		child.pr();

	}

}

/*======================================================================*/

Day11_java/ExtendEx09.java

/*
 * this() : 상속과 관련이 없다. 같은 클래스내에서 다른 생성자를 호출할 떄 사용한다. 주로 동일 클래스내에서
 * 오버로딩 된 다른 생성자를 주로 호출한다.
 * 
 * super() : 상속관계에서 자손에서 부모의 생성자를 호출할 때 사용한다.
 */

class Parent09 {
	int x = 10;	// 멤버변수(속성) 중 인스턴스 변수
	int y = 20; // 멤버변수(속성) 중 인스턴스 변수

	// 기본생성자 묵시적 제공 안함

	Parent09(int x, int y) {
		this.x = x;
		this.y = y;
	}// 매개변수 개수가 다른 생성자 오버로딩
}//Parent09 부모 클래스

class Child09 extends Parent09{
	int z = 30; // 멤버변수(속성) 중 인스턴스 변수
	
	Child09(){
		this(100, 200, 300); // 같은 클래스내에서 매개변수 3개짜리 오버로딩 된 다른 생성자 호출
		/* 자바의 생성자 {} 중괄호 블록내에서 this() 또는 super()를 사용하는 경우 항상 첫줄에 와야 한다.
		 * 단 한번만 호출 가능하다.
		 * this() 와 super()는 동시에 사용할 수 없다.
		 * 생성자 {}내에서 super() or this()를 생략하면 자바컴파일러는 자동으로 super();를 추가한다.
		 */
	}// 기본 생성자
	
	Child09(int x, int y, int z){
		super(x,y);// 부모클래스의 매개변수 2개짜리 오버로딩 된 생성자호출
		this.z = z;
	}// 생성자 오버로딩
	
	void pr() {
		System.out.println("x = " + x + ", y = " + y);// 상속받아서 호출
		System.out.println("z = " + z);
	}// 사용자 정의 메서드 pr()
}// Child09 자손 클래스

public class ExtendEx09 {

	public static void main(String[] args) {
		
		Child09 child09 = new Child09();
		child09.pr();
		
		Child09 ch10 = new Child09(110, 120, 130); // 매개변수 3갲짜리 자손의 오버로딩 된 생성자 호출
		ch10.pr();

	}

}

/*======================================================================*/

Day11_java/ExtendEx10.java


/*
 *  static import 문)
 *   static import 문을 사용하면 static 멤버(정적변수, 정적메서드)를 호출할 때 클래스 이름을 생략할 수 있다.
 *   그만큼 코드 라인이 줄어들고 간결해 진다.
 */
import static java.lang.System.out;
import static java.lang.Math.*;
// java.lang 은 기본패키지 경로이다. 생략가능하다. import 키워드는 외부 패키지의 API를 읽어들일 때 사용한다.

public class ExtendEx10 {
	public static void main(String[] args) {

		out.println("난 수 : " + random()); // System.이 생략됨. Math.가 생략됨.
		out.println("원주율 : " + PI);

	}
}

