Day10_java/ConsEx01.java
클래스 초기화 블록 static{}

import java.util.Random;

public class ConsEx01{
	static int[] arr = new int[10];
	static int[] arr02 = new int[10];

	static{
		/*
		 * 문제01) 1부터 10까지 정수 난수로 일반 for반복문을 사용해서 정적배열 arr 배열원소값을 초기화 해보자.
		 * 단, Math.random() 정적 내장메서드를 활용해야 한다.
		 */

		 //arr 배열원소 초기화

		 for(int i =0; i<arr.length; i++){
			 arr[i] = (int)(Math.random()*10) + 1;
		 }

		/*
		 * 문제02) java.util 패키지인 Random 내장클래스를 활용해서 1부터 10사이의 정수난수로 
		 * arr02 정적배열원소값을 초기화를 해보자. 물론 for반복문을 사용한다.
		 */

		 // arr02 배열원소 초기화
		 Random random = new Random();
		 for(int i =0; i < arr02.length; i++){
			 arr02[i] = random.nextInt(10) + 1;
		 }
	}
	public static void main(String[] args){

		// 첫번째 정적배열 arr원소값을 향상된 for반복문으로 출력
		for(int a : arr) {
			System.out.print(" " + a);
		}// for
		System.out.println("\n\n ============================== \n");
		
		// 두번째 정적배열 arr02 원소값을 일반 for반복문으로 출력
		for(int i = 0; i<arr02.length; i++) {
			System.out.print(" " + arr02[i]);
		}// 
	}
}

/*======================================================================*/

Day10_java/ConsEx02.java
1. static 키워드로 정의된 변수 count를 정적변수라고 한다. 정적변수는 클래스 변수로 해당 클래스로 직접 접근가능하다.
2. 인스턴스 초기화 블록{} 을 사용해서 정적변수와 인스턴스 변수 초기화를 해보고 그 차이점에 대해서 알아 본다.

class Product{
	static int count = 0; // 정적변수 | 멤버변수(속성) 중 정적변수
	int serialNo; // 인스턴스 변수 -> 생성된 객체마다 따로 관리한다.(생성된 객체마다 주소값이 다르다
	// 그러므로 다른값을 가진다.) 명시적인 초기화를 하지 않아서 기본값 0으로 초기화가 된다.
	// 멤버젼수(속성) 중 인스턴스 변수

	{// 인스턴스 초기화 블록
		++count; // 생산대수를 카운터(생상된 객체마다 값을 공유가능 하다. -> 누적 생산대수
		serialNo = count; // 생성된 객체마다 값이 다르다. 이유는 객체주소가 달라서이다.
	}

	public Product(){

	}// 기본 생성자
}
public class ConsEx02{
	public static void main(String[] args){
		Product p01 = new Product(); // 먼저 인스턴스 초기화 블록을 호출하고 그 다음에 생성자를 호출
		Product p02 = new Product(); // new Product(); 할 때 마다 생성자와 인스턴스 초기화 블록을 호출 실행
		Product p03 = new Product(); // p01,p02,p03 각 객체주소가 다르다. 그러므고 다른 고유한 값을 가진다.

		System.out.println("p01 제품번호(시리얼 번호) : " + p01.serialNo);
		System.out.println("p02 제품번호 : " + p02.serialNo);
		System.out.println("p03 제품번호 : " + p03.serialNo);
		
		System.out.println("총 생산대수 : " + Product.count + "대");
	}
}

/*======================================================================*/

Day10_java/ConsEx03.java
생성자 오버로딩, this()에 의한 같은 클래스내에서 오버로딩 된 다른 생성자를 호출, 생정자의 주된 기능인 인스턴스 변수
초기화등에 대해서 알 수 있다.

class Document{
	ststic int count = 0; // 멤버변수(속성) 중 정적변수
	String name; // 멤버변수(속성) 중 인스턴스 변수 -> null기본값으로 초기화

	Document(){ // 매개변수가 없는 기본 생성자
		this("제목없음" + ++count); // 같은 클래스내의 오버로딩 된 다른 생성자 호출
	}

	Document(String name){
		this.name = name;
		System.out.println("문서 " + this.name + "가 생성"); 
	}// 생성자 오버로딩
}
public class ConsEx03{
	public static void main(String[] args){
		new Document(); // 기본 생성자 호출
		new Document("자바.txt"); // 오버로딩 된 생성자 호출
		new Document();
	}
}

/*======================================================================*/

Day10_java/Ex13_01.java
/*
 * 13장.생성자.pdf No.19쪽 1번문제)
 * Animal 클래스에 생성자를 추가해 본다.(생성자 오버로딩)
 */

class Animal{
	String name; // 클래스 소속 멤버변수(중) 인스턴스 변수
	int age; // 클래스 소속 멤버변수(중) 인스턴스 변수

	// 생성자가 오버로딩이 되면 매개변수가 없는 기본생성자는 더 이상 묵시적 제공이 되지 않는다. 즉 생략불가

	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}// 매개변수가 다른 생성자 오버로딩

	public void show(){
		System.out.println(name + "는(은)" + age + "살 입니다.");
	}// 사용자 정의 메서드
}

public class Ex13_01{
	public static void main(String[] args){
		Animal a1 = new Animal("원숭이", 26); // 오버로딩 된 생성자 호출
		a1.show();
	}
}

/*======================================================================*/

Day10_java/Ex13_02.java
/*
 * 13장.생성자.pdf No.20쪽 2번문제)
 * Product 클래스를 Product02 클래스로 변경해서 한다. 이 클래스에 생성자를 추가해 본다.(생성자 오버로딩)
 */

class Product02{
	String name; // 클래스 소속 멤버변수(속성) 중 인스턴스 변수
	int price; // 클래스 소속 멤버변수(속성) 중 인스턴스 변수

	public Product02(){ }// 기본 생성자

	public Product02(String name){
		this.name = name;
		this.price = 800;
	}// 매개변수가 다른 생성자 오버로딩

	public Product02(int price){
		this.name = "물";
		this.price = price;
	}// 매개변수가 다른 생성자 오버로딩

	public Product02(String name, int price){
		this.naem = name;
		this.price = price;
	}// 매개변수가 다른 생성자 오버로딩
}
public class Ex13_02{
	public static void main(String[] args){
		Product02 p01 = new Product02("웰치스", 700);
		Product02 p02 = new Product02("커피");
		Product02 p03 = new Product02(500);
		System.out.println(p01.name + "," + p01.price);
		System.out.println(p02.name + "," + p02.price);
		System.out.println(p03.name + "," + p03.price);		

	}
}

/*======================================================================*/

Day10_java/Ex13_02_sol.java
/*
 * 교수님 풀이
 */

class Product02{
	String name; // 클래스 소속 멤버변수(속성) 중 인스턴스 변수
	int price; // 클래스 소속 멤버변수(속성) 중 인스턴스 변수

	public Product02(){} // 기본 생성자

	public Product02(String name){
		this(name,500); // 같은 클래스내의 매개변수 2개짜리 오버로딩 된 생성자를 호출
	}

	public Product02(int price){
		this("커피",price);
	}// 매개변수 타입이 다른 생성자 오버로딩

	public Product02(String name, int price){
		this.name = name;
		this.price = price;
	}// 매개변수가 다른 생성자 오버로딩

	public void pr(){
		System.out.println(name + ", " + price);
	}// 사용자 정의 메서드
}
public class Ex13_02_sol{
	public static void main(String[] args){

		Product02 p01 = new Product02("물");
		Product02 p02 = new Product02(800);
		Product02 p03 = new Product02("웰치스", 700);
		p01.pr();
		p02.pr();
		p03.pr();
	}
}

/*======================================================================*/

Day10_java/ConsEx04.java
클래스 소속의 멤버변수 중 정적변수와 인스턴스 변수의 차이점)

class St04{
	static int a = 10; // static 키워드로 정의 변수 a를 정적변수(클래스 변수)라고 한다.
	// 정적변수는 해당클래스로 직접 접근할 수 있다(St04.a)
	// 클래스 소속 내의 멤버변수(속성) 중 정적(static)변수
	int b = 20;// 클래스 내의 멤버변수(속성) 중 인스턴스 변수
	/*
	1. 인스턴스 변수
	2. 정적변수(static)
	*/
}
public class ConsEx04{
	public static void main(String[] args){
		System.out.println("St04.a = " + St04.a);
		
		St04 s01 = new St04();
		St04 s02 = new St04();
		
		System.out.println("s01.a = " + s01.a + ", s02.a = " + s02.a);// 생성된 객체로 정적변수 접근 가능
		System.out.println("s01.b = " + s01.b + ", s02.b = " + s02.b);
		
		s01.a = 100;// 변경된 정적변수 a값은 객체에 의해서도 공유된다.
		System.out.printf("s01.a = %d \t s02.a = %d \n", s01.a, s02.a); // 100, 100
		s01.b = 200;// 인스턴스 변수 b는 생성된 객체마다 따라 관리한다. 그러므로 객체주소값이 다르다. 다른값을 가진다.
		System.out.println("s01.b = " + s01.b + "\t s02.b = " + s02.b);// 200, 20 \t는 탭키만큼 수평으로 띄운다.
	}
}

/*======================================================================*/

Day10_java/ConsEx05.java
static 키워드로 정의된 메서드를 정적메서드라고 한다. 정적메서드는 해당 클래스로 직접 접근 가능하다.

class St05{
	private static int a = 10; // 정적변수
	private int b = 20; // 인스턴스 변수

	public static setA(int new_a){ // 정적메서드 setA() 저으이
		a = new_a;
	}

	public static int getA(){ // 정적메서드 getA() 정의
		return a;
	}
}
public class ConsEx05{
	public static void main(String[] args){
		System.out.println("St05.getA() = " + St05.getA()); // 10
		
		St05 s01 = new St05();
		
		s01.setA(100); // 생성된 객체로도 정적메서드 호출가능 하다.
		int result = St05.getA();
		System.out.println("result = " + result); // 100
	}
}
/*======================================================================*/

Day10_java/ConsEx06.java

class St06{
	static int a = 10; // 멤버번수(속성) 중 정적변수
	int b = 20; // 멤버변수(속성) 중 인스턴스 변수

	public static void printA(){ // 정적메서드
		System.out.println(a);
		System.out.println(this.b); // 정적메서드 내에서는 this 사용 못함
		System.out.println(b); // 정적메서드 내에서는 인스턴스 변수 사용 못함
	}

	public void printB(){// 인스턴스 메서드
		System.out.println(a);
		System.out.println(b);
		System.out.println(this.b);
	}
	/*
	인스턴스 메서드내에서는 정적변수, 인스턴스 변수, this 모두 사용 가능하다.
	*/
}
public class ConsEx06{
	public static void main(String[] args){
	}
}
/*======================================================================*/

Day10_java/ConsEx07.java
Math 클래스 하위의 내장 정적메서드를 사용해서 두 수중 최대값과 최소값을 구해보고, static final로 선언된 정적 내장
상수 활용해서 원주율을 구해 본다. 원의 면저 = 반지름 * 반지름 * 원주율;

public class ConsEx07{
	public static void main(String[] args){
		
		int a = 40, b = 30, c = 10, r = 5;

		int result = 0;
		result = Math.max(a, b); // 40

		result = Math.min(b, c); // 10

		double area = 0.0;
		area = r * r * Math.PI;
		
	}
}

/*======================================================================*/

Day10_java/net.daum.dto/MemberDTO.java

package net.daum.dto;
// package 예약어로 net 패키지 폴더 하위에 daum 폴더 하위에 dto 폴더사 생성된다.
// daum 폴더는 도메인명이라서 중복 폴더가 생성되는 방지할 수 있다.

public class MemberDTO {// 회원관리 데이터 저장빈 클래스
	
	private String mem_id; // 아이디
	private String mem_pwd; // 비밀번호
	private String mem_name; //회원이름
	private String mem_phone; //폰번호
	private String mem_email; //이메일
	private String mem_addr; //집주소
	

	/*

	 우클릭 Source
	Generate Getters and Setter Methods

	Select All
	 ㄴ 전체 getter, setter 선택
	 Deselect All
	  ㄴ 전체 해제

	Select Getters
	 ㄴ Gettser 선택
	Select Setters
	 ㄴ Setter 선택

	*/

	// 매개변수가 없는 기본생성자가 생략됨.
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String meme_addr) {
		this.mem_addr = meme_addr;
	}
}
/*======================================================================*/

Day10_java/MemberMain.java

/*
 * net.daum.dto 패키지의 데이터 저장빈 클래스 MemberDTO.java를 임포트 해서 사용
 */

import net.daum.dto.MemberDTO;

public class MemberMain {

	public static void main(String[] args) {

		MemberDTO member = new MemberDTO();

		member.setMem_id("kkkkk");// 아이디 저장
		member.setMem_phone("010-9999-9999"); // 폰번호 저장
		member.setMem_name("홍길동"); // 회원이름 저장
		member.setMem_email("kkkkk@daum.net"); // 멜주소 저장
		member.setMem_addr("대전시"); // 주소 저장

		System.out.printf("아이디 : %s \n", member.getMem_id()); // %s 는 문자열 출력형태 지시자
		System.out.printf("회원이름 : %s \n", member.getMem_name());
		System.out.println("이메일 : " + member.getMem_email());
		System.out.printf("포번호 : %s \n", member.getMem_phone());
		System.out.printf("집주소 : %s \n", member.getMem_addr());

	}

}
/*======================================================================*/

Day10_java/BoardMain.java
/*
 * 람복 api를 사용한 데이터 저장빈 클래스 GuustBookDTO.java를 활용한 예제
 */

import net.daum.dto.GuestBookDTO;

public class BoardMain {

	public static void main(String[] args) {
		
		GuestBookDTO g = new GuestBookDTO("홍길동", "방명록 제목입니다.", "방명록 내용입니다.");
		//매개변수 3개짜리 오버로딩 된 생성자 호출
		
		System.out.println("글쓴이 : " + g.getWtiter());
		System.out.println("글제목 : " + g.getTitle());
		System.out.println("글내용 : " + g.getContent());

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


