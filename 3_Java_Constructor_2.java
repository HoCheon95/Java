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

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/

/*======================================================================*/
