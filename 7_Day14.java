/*
InterEx01

자바의 인터페이스 특징)
 1. 인터페이스는 interface 예약어로 정의하고 implements 키워드로 자손클래스에서 구현 상속한다.
 2. 자손클래스에서 하나 이상 부모 인터페이스로 부터 다중 상속을 받을 수 있다.
 3. 인터페이스에 오는 추상메서드는 public abstract 키워드로 정의한다. 이 키워드는 생략가능하다.
 4. 부모 인터페이스를 구현 상속한 자손클래스에서 부모의 모든 추상메서드를
    반드시 오버라이딩을 해야 한다는 강제성이 부여된다. 그래야만 자손클래스 객체 생성이 가능하다.    
*/

interface IHello01{// 최초 작성한 인터페이스에서 명시적인 다른 부모 인터페이스로 부터 상속받지 않으면 부모는 없다.
	public abstract void sayHello(String name);// public abstract 는 생략가능함. 추상메서드 정의
}

class Hello01 implements IHello01{// implements 키워드로 자손클래스에서 구현상속한다.
	@Override
	public void sayHello(String name){
		System.out.println(name + "씨 안녕!");
	}
}
public class InterEx01{
	public static void main(String[] args){
		IHell01 ih; // 부모 인터페이스 타입으로 참조변수 ih 선언
		ih = new Hello01(); // 업캐스팅
		ih.sayHello("홍길동");// 업캐스팅 이후 오버라이딩 한 메서드 호출
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx02

일반 클래스나 추상 클래스는 하나 이상의 부모 클래스로 부터 다중 상속을 받을 수 없다. 오직 하나의 부모로 부터
단일 상속만 가능하다.
*/
class Hello02{
	public void sayHello(String name){
		System.out.println(name + "씨 반가워요!");
	}
}

abstract class GoodBye02{
	public abstract void bye(String name);//추상메서드 정의
}

class SubClass02 extends Hello02, GoodBye02{
	// 클래스나 추상클래스는 오직 하나의 부모클래스로 부터 단일상속만 가능하다.
}
public class InterEx02{
	public static void main(String[] args){
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx03

인터페이스 특징)
 1. 인터페이스는 하나 이상의 부모 인터페이스로 부터 다중상속을 받을 수 있다.
 2. 자손 클래스에서 부모 인터페이스를 implements 키워드로 구현 상속한다.
*/

interface IHello03{
	void hello(String name);// public abstract 가 생략된 추상메서드
}

interface IGoodBye03{
	void bye(String name);
}

class SubClass03 implements IHello03, IGoodBye03{
	@Override
	public void hello(String name){
		System.out.println(name + "씨 안녕하세요!");
	}
	
	@Override
	public void bye(String name){
		System.out.println(name + "씨 잘가세요!");
	}
}
public class InterEx03{
	public static void main(String[] args){
		
		SubClass03 sub = new SubClass03();
		sub.hello("홍길동");
		sub.bye("이순신");
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx04

class 자손클래스 extends 부모클래스 implements 부모인터페이스{
	
}
부모클래스와 부모 인터페이스를 자손클래스에서 동시 상속받는 법)
*/

interface IHello04{
	public void sayHello(String name);//추상메서드 정의 -> abstract 키워드 생략함
}

abstract class GoodBye04{
	public abstract void goodBye(String name);// 추상 클래스에서는 인터페이스와는 다르게 추상메서드를 정의할 때
											  // abstract 키워드 생략 불가
}

class SubClass04 extends GoobBye04 implements IHello04{
	@Override
	public void sayHello(String name){
		System.out.println(name + "씨 안녕!");
	}
	
	@Override
	public void goodBye(String name){
		System.out.println(name + "씨 잘가!");
	}
}
public class InterEx04{
	public static void main(String[] args){
		
		SubClass04 sub = new SubClass04();
		sub.sayHello("을지문덕");
		sub.goodBye("강감찬");
		
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx05

인터페이스에서 인터페이스 간 상속은 extends 예약어를 사용한다. 그리고 인터페이스 간 상속도 다중상속이 가능하다.
*/

interface IHello05{
	void hello(Stirng name);// public abstract 키워드가 생략된 추상메서드
}

interface GoodBye05{
	void bye(String name);
}

interface ITotal extends IHello05, GoodBye05{
	public abstract void greeting(String name);
}

class SubClass05 implements ITotal{
	@Override
	public void hello(Stirng name){
		System.out.println(name + "씨 안녕!");
	}
	@Override
	public void bye(Stirng name){
		System.out.println(name + "씨 잘가!");
	}
	@Override
	public void greeting(Stirng name){
		System.out.println(name + "씨 방가!");
	}
}

public class InterEx05{
	public static void main(String[] args){
		
		ITotal it = new SubClass05();//업캐스팅
		it.hello("홍길동");// 업캐스팅 이후 오버라디이 한 메서드 호출
		it.bye("이순신");
		it.greeting("신사임당");
	}
}
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx06

인터페이스 오는 모든 변수는 public static final 로 인식되는 정적상수만 올 수 있다.
*/

interface IColor06{
	int RED = 1; //public static final 이 생략된 정적상수 RED
	
	public static final int ORANGE = 2;
	int BLUE = 3;
	
	void setColor(int color);//public abatract 가 생략된 추상메서드
	
	public abstract int getColor();// 추상메서드
}

abstract class AbsColor06 implements IColor06{
	int color = ORANGE; //추상클래스에 일반 변수가 올 수 있다. 2가 저장됨
	
	@Override
	public setColor(int color){
		this.color = color;
	}
}

class SubClass06 extends AbsColor06{
	@Override
	public int getColor(){
		return color;
	}
}
public class InterEx06{
	public static void main(String[] args){
		SubClass06 sub = new SubClass06();
		sub.setColor(IColor06.RED);
		System.out.println(sub.getColor());
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx07

클래스와 클래스 간 직접연결하는 방식 -> 자바 프로젝트나 스프링 프로젝트 개발에서 별로 권하고 싶지 않은 방식
*/

class A07{
	public void methodA(B07 b){// B07 b = new B07()
		b.methodB();
	}
}

class B07{
	public void methodB(){
		System.out.println("methodB() 호출~");
	}
}

public class InterEx07{
	public static void main(String[] args){
		A07 a = new A07();
		a.methodA(new B07());
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx08

클래스 대 클래스 간 직접연결 보다는 중간에 인터페이스를 끼어 넣어서 간접 연결하는 방식
-> 스프링 자바 프로젝트 등 개발에서 권장하는 방식
*/

interface I08{
	public abstract void play();// 추상메서드 정의
}

// 첫번째 자손클래스
class B08 implements I08{
	@Override
	public void play(){
		System.out.println("B08 class play() 메서드");
	}
}

// 두번쨰 자손클래스
class C08 implements I08{
	@Override
	public void play(){
		System.out.println("C08 class play() 메서드");
	}
}

class A08{
	void autoplay(I08 i){// 매개변수 타입이 부모 인터페이스 타입으로 선언
						 // -> 매개변수 다형성(상속 + 업캐스팅: 모든자손을 받을 수 있다.)
		i.play();//업캐스팅 이후 오버라이딩 한 메서드 호출 -> i가 실제 가리키는 객체타입에 의해서 호출되는 메서드 결정된다.
	}
}

public class InterEx08{
	public static void main(String[] args){
		A08 a08 = new A08();
		a08.autoplay(new B08);// 매개변수 인자값이 업캐스팅 됨
		a08.autoplay(new C08);
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
/*
InterEx09

부모 인터페이스에 추가된 추상메서드는 반드시 이를 구현 상속한 자손클래스에서 오버라이딩을 해야 한다.
그래야만 자손클래스 객체 생성이 가능하다. 하지만 이런 경우에는 불필요한 부모의 추상메서드까지 무조건 오버라이딩을
해야하는 불편함이 존재한다. 이를 해결하기 위해서 자바 8버전에서 추가된 것이 디폴트 메서드이다.
이 디폴트 메서드는 부모 인터페이스에 추가되어도 자손에서 반드시 오버라이딩을 하지 않아도 된다.
필요하면 오버라이딩을 하고 불필요하면 오버라이딩을 하지 않아도 된다. 결국 자손에서 선택적 오버라이딩을 하면 된다.
하지만 부모 인터페이스에 추가된 추상메서드는 꼭 자손에서 무조건 오버라이딩을 해야 한다.
*/
interface ParentInter09{
	void absMethod();// public abstract 가 생략된 추상메서드
	
	public default void defaultMethod(){//디폴트 메서드 정의 -> public 생략가능
		System.out.println("부모 인터페이스에 디폴트 메서드 정의");
	}
}

class ChildClass09 implements ParentInter09{
	@Override
	public void absMethod() {
		System.out.println("부모 인터페이스의 추상메서드가 오버라이딩 됨.");
	}

	@Override// 디폴트 메서드는 선택적 오버라이딩
	public void defaultMethod() {
		System.out.println("부모 인터페이스의 디폴트 메서드가 자손에서 선택적 오버라이딩 함.");
	}
}
public class InterEx09{
	public static void main(String[] args){
		
		ParentInter09 p09 = new ChildClass09();
		
		p09.absMethod();// 업캐스팅 이후 오버라이딩 한 메서드 호출
		p09.defaultMethod();
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx10

두 부모 인터페이스의 디폴트 메서드명이 동일한 경우 다중 상속한 자손클래스에서 디 디폴트 메서드를 오버라이딩을 해야 한다.
*/

interface InterA{
	default void display(){// 디폴드 메서드
		System.out.println("InterA 디폴트 메서드");
	}
	
	static void staticMethod(){// 자바 8버전에서 인터페이스에도 정적메서드가 올 수 있게 되었다.
		System.out.println("InterA 정적메서드");
	}
}

interface InterB{
	default void display(){
		System.out.println("InterB 디폴트 메서드");
	}
}

class ChildClass10 implements InterA, interB{
	@Override
	public void display(){
		InterA.super.display();
		InterB.super.display();
	}
}

public class InterEx10{
	public static void main(String[] args){
		
		ChildClass10 child10 = new ChildClass10();
		
		child10.display();//오버라이딩 한 메서드 호출
		InterA.staticMethod(); // 인터페이스명.정젝메서드() 호출
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterEx11

부모 인터페이스의 디폴트 메서드명과 부모 클래스의 일반 메서드명이 동일한 경우 부모 인터페이스의 디폴트 메서드는
자손에서 상속되지 않고 부모 클래스의 일반 동일 메서드가 상속되어 진다.
*/
class ParentClass11{
	public void display(){
		System.out.println("부모클래스 일반 메서드");
	}
}

interface ParentInter11{
	default void display(){
		System.out.println("부모 인터페이스 디폴트 메서드");
	}
}

class ChildClass11 extends ParentClass11 implements ParentInter11{
}

public class InterEx11{
	public static void main(String[] args){
		
		ChildClass11 child11 = new ChildClass11();
		child11.display();// 부모클래스의 동일 일반메서드만 상속된다.
		
	}

}
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
InterfaceA

sealed 키워드로 봉인된 인터페이스 InterfaceA 정의 -> permits 키워드 다음에 오는 InterfaceB 만
자손 인터페이스로 정의 가능하다.
*/
public sealed interface InterfaceA permits InterfaceB{
	public abstract void methodA();// 추상메서드 정의 -> public abstract 키워드 생략가능
}


/*
InterfaceB

InterfaceB 는 non-sealed 키워드로 비봉인 인터페이스로 정의 -> 다른 자손 인터페이스를 생성할 수 있다.
*/
public non-sealed interface InterfaceB extends InterfaceA{
	void methodB();// 추상메서드 정의 -> public abstrarct 키워드가 생략됨.
}

/*
InterfaceC

비봉인 부모 인터페이스 InterfaceB 를 상속받은 자손 인터페이스 InterfaceC
*/
public interface InterfaceC extends InterfaceB{
	void methodC();// 추상메서드 정의 -> public abstract 키워드가 생략됨.
}

/*
ImpClass
*/

public class ImpClass implements InterfaceC{
	@Override
	public void methodA(){
		System.out.println("methodA() 실행");
	}
	@Override
	public void methodB(){
		System.out.println("methodB() 실행");
	}
	@Override
	public void methodA(){
		System.out.println("methodC() 실행");
	}
}

/*
InterEx12
*/
public class InterEx12{
	public static void main(String[] args){
		
		ImpClass imp = new ImpClass();
		
		InterfaceA ia = imp;//최상위 부모 인터페이스 타입으로 업캐스팅 함
		ia.methodA();//업캐스팅 이후 오버라이딩 한 메서드 호출
		System.out.println("\n ========= \n");
		
		InterfaceB ib = imp;
		ib.methodA();
		ib.methodB();
		System.out.println("\n ========= \n");
		
		InterfaceC ic = imp;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
Ex19_01

자바 인터페이스.pdf No.24쪽 1번 문제)
1. net.daum.model01 패키지를 생성하고 부모 인터페이스 IShapeClass.java를 만들고 추상메서드 void draw();를 정의한다.
2. new.daum.model02 패키지를 생성하고 부모 인터페이스 IShapeClass를 구현 상속한 자손 클래스
   Circ.java, Rect.java, Tria.java를 생성하고 부모의 추상메서드 draw()를 각각 오버라이딩 한다.
   각 오버라이딩 된 출력 실행문장으로 "타원을 그린다", "사각형을 그린다", "삼각형을 그린다"가 출력되게 하는 자바 코드를 기술한다.
   
그런 다음 다음과 같은 출력 결과물이 나오게 한다.
타원을 그린다.
사각형을 그린다.
삼각형을 그린다.
===========================
*/

import net.daum.model01.IShapeClass;
import net.daum.model02.Circ;
import net.daum.model02.Rect;
import net.daum.model02.Tria;

public class Ex19_01{
	static void pr(IShapeClass ish){// 매개변수 다형성(업캐스팅과 상속 -> 모든 자손 타입을 받을 수 있다.)
		ish.draw();
	}
	public static void main(String[] args){
		IShapeClass ref;// 부모 인터페이스 타입으로 ref 참조변수 선언
		ref = new Circ();// 업캐스팅
		ref.draw();// 업캐스팅 이후 오버라이딩 한 메서드 호출
		
		ref = new Rect();
		ref.draw();
		
		ref = new Tria();
		ref.draw();
		System.out.println("=========================== \n");
		
		pr(new Circ()); pr(new Rect()); pr(new Tria());
		System.out.println("=========================== \n");
	}
}

/*
net.daum.model01.IShapeClass
*/
package net.daum.model01;

public interface IShapeClass{
	void draw();
}

/*
net.daum.model02.Circ
*/
package net.daum.model02;

import net.daum.model01.IShapeClass;

public class Circ implements IShapeClass{
	@Override
	public void draw(){
		System.out.println("타원을 그린다.");
	}
}

/*
net.daum.model02.Rect
*/
package net.daum.model02;

import net.daum.model01.IShapeClass;

public class Rect implements IShapeClass{
	@Override
	public void draw(){
		System.out.println("사각형을 그린다.");
	}
}

/*
net.daum.model02.Tria
*/
package net.daum.model02;

import net.daum.model01.IShapeClass;

public class Tria implements IShapeClass{
	@Override
	public void draw(){
		System.out.println("삼각형을 그린다.");
	}
}
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/*
Ex19_02

자바 인터페이스.pdf No.25쪽 2번 문제)
 소스는 강의교안을 참조하고 이 소스는 컴파일 에러가 난다. 에러가 나는 이유에 대해서 주석문 처리한다.
 그리고 에러 부분을 수정해서 에러가 안나게 한다.
*/

abstract class Test{
	public abstract void methodA();
	
	//public abstract void methodB();
	public void methodB() {
		System.out.println("methodB() 메서드");
	};
	
	/*
	 * 추상 클래스는 abstract class 키워드로 정의한다.
	 * 
	 * 추상 메서드는 {}가 없고, 실행문장이 없고, 호출이 불가능하다.
	 */
}

class ChildClass02 extends Test{

	@Override
	public void methodA() {
		System.out.println("오버라딩 한 methodA()");
	}
	
}

public class Ex19_02 {

	public static void main(String[] args) {
		
		Test t = new ChildClass02();
		t.methodA();//업캐스팅 이후 오버라이딩 한 메서드 호출
		t.methodB();

	}

}