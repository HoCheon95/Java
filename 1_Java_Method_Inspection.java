자바의 OOP에서 메서드 오버로딩이란?
 동일한 같은 클래스내에서 같은 이름의 메서드를 여러 번 중복해서 정의하는 것을 말한다.

오버로딩 된 메서드 구분 요건)
1. 매개변수 '타입'을 다르게 한다.
2. 매개변수 '개수'를 다르게 한다.
3. 매개변수 '순서'를 다르게 한다.

매개변수 '타입'을 다르게
int abs(int data)
double abs(double data)

매개변수 '개수'를 다르게
void pr(int a, int b)
void pr(int a)

매개변수 '순서'를 다르게
public void print(int a, int b, String c)
public void print(String c, int a, int b)

4. 매서드명 앞의 리턴타입을 다르게 한 매서드 오버로딩은 허용하지 안는다.
void print(int a)
int print(int a)	// print() 메서드 앞의 리턴타입을 다르게 한 오버로딩은 안된다.


/*======================================================================*/

ObjEx04.java
가변인자(Varargs)
- 매개변수 개수가 다른 메서드가 오버로딩 되면 그 개수만큼 메서드를 정의해야 한다.
  이 부분을 해결하기 위해서 자바 5에서 가변인자 문법이 추가됨
  형식은 메서드명(타입... 매개변수) 형태로 하면서 배열로 처리된다.

class Mt04{
	void pr(int...arr){// int... arr이 가변인자이다. arr은 배열로 처리된다.
		for(int i =0; arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
}
public static void main(String[] args){
	Mt04 mt = new Mt04();
	mt.pr(100);
	mt.pr(100, 200);
	mt.pr(100, 20, 30, 50, 60);
}

/*======================================================================*/

ObjEx05.java
참조(레퍼런스)변수만 선언하고 객체주소가 저장 안된 상태에서 해당 참조변수는 클래스 내의 멤버변수(속성)에 접근 못 한다.

class Board05{
	String writer = "홍길동";
	String title = "게시판 글제목";
	String content = "게시판 글내용";
}
public class ObjEx05{
	public static void main(String[] args){
		Board05 board;	// 객체주소가 저장 안된 참조변수
		System.out.println(board.writer + "," + board.title + "," + board.content);
		// 에러발생

		board = new Board05();	// 객체주소가 저장된 참조변수 board -> 객체명이라고도 한다. | 객체생성
		System.out.println(board.writer + "," + board.title + "," + board.content);
	}
}

/*======================================================================*/

ObjEx06.java
자바의 기본자료형과 레퍼런스 참조형의 차이점 01)
 기본타입(자료형)으로 선언된 변수는 값을 저장하고, 참조타입으로 선언된 변수에는 객체주소를 저장해서 주소값을 공유해서
 값도 함께 공유 수정가능하다.

class MyDate06{
	int year = 2024;
	int month = 12;
	int date = 22;
} // MyDate06 class

public class ObjEx06{
	public static void main(String[] args){

		int x = 7;
		int y = x;

		MyDate06 d = new MyDate06();	// 객체생성
		MyDate06 t = d; // t참조변수에 d객체주소를 대입. 결국 t와 d는 같은 객체주소를 가진다. 즉 같은 값을 가지게 된다.

		System.out.println("x = " + x + ", y = " + y); // 7, 7
		System.out.println(d.year + "년 " + d.month + "월 " + d.date + "일"); // 2024년 12월 22일
		System.out.println(t.year + "년 " + t.month + "월 " + t.date + "일"); // 2024년 12월 22일

		y = 10;
		System.out.printf("x = %d, y = %d \n", x, y); //7, 10
		
		t.year = 2025; t.month = 10; t.date = 31; // t와 d는 같은 객체주소를 공유해서 값도 공유한다.
		System.out.printf("%d년 %d월 %d일 \n", d.year, d.month, d.date); // 2025년 10월 31일
		System.out.println(t.year + "년 " + t.month + "월 " + t.date + "일"); // 2025년 10월 31일
	}
}

/*======================================================================*/

ObjEx07.java
레퍼런스(참조) 타입 변수가 같은 객체주소를 공유하여도 new 키워드로 새로운 객체를 만들면 새로운 객체주소가 대입된다.
그러므로 주소값이 달라서 값도 공유 하지 못한다.

Mydate07 d = new MyDate07();	// d객체 생성
Mydate07 t = d; // t참조변수에 d객체주소를 대입, 결국 t와 d는 같은 객체주소를 가진다.

/*
참조변수 d 선언
new MyDate07() 힙 객체 생성
= 생성된 객체의 주소를 대입
*/

t = new MyDate07();
// new 키워드에 의해서 새로운 객체주소가 대입된다.
// 그러므로 t와 d는 서로 다른 주소값을 가지게 되어서 값을 공유 못한다.

/*======================================================================*/

ObjEx08.java
매개변수 타입이 기본타입이면 값이 전달된다. 이것은 값에 의한 전달방식이다. 그러므로 객체주소를 공유하지 못한다.
결국 메서드 호출 후 변경된 값도 공유하지 못한다.

class Vm08(){
	void changeNum(int y){ // int y는 매개변수 타입이 기본타입이다. 값만 전달된다.
		y = 2000;
	}
}

Vm08 vm = new Vm08(); // 참조변수 vm | Vm08() 객체 생성
int x = 1000;
System.out.println("changeNum() 메서드 호출전 : " + x); // 1000
vm.changeNum(x);
System.out.println("changeNum() 메서드 호출후 : " + x); // 1000

이 예제는 메서드를 호출한다고해서 x의 값이 바뀌지 않는 것을 보여주는 예제이다.

/*======================================================================*/

ObjEx09.java
메서드 매개변수 타입이 참조타입이면 객체주소값 전달된다. 그러므로 메서드 호출 후 같은 객체주소를 공유하기 때문에 변경된
값도 공유한다. 이것을 레퍼런스(Referenc, 참조변수)에 의한 전달된다.

class MyDate09{
	int year = 2025;
	int month = 12;
	int date = 22;
}

class ReMethod{
	void change(MyDate09 t){ // 매개변수 타입이 참조타입이다. MyDate09 t = d; 매개변수에 d객체주소가 대입된다.
							 // 그러므로 같은 주소를 공유한다.
		t.year = 2026;
		t.month = 1;
		t.date = 1;
	}
}

ReMethod rm = new ReMethod();	// rm 참조변수 | 객체생성
MyDate09 d = new MyDate09();	//  d 참조변수 | 객체생성
// 2025년 12월 22일

re.change(d);
// 2026년 1월 1일 -> t와 d는 같은 객체주소를 공유한다. 그러므로 변경된 년원일 값도 함께 공유된다.

/*======================================================================*/

ObjEx10.java
참조변수만 선언하고 객체주소를 대입 안하면 초기화가 되지 않아서 해당 클래스의 멤버변수(속성)에 접근 못한다.

class Member10{
	String mem_id = "abc"
	String mem_name = "홍길동"
}

Member10 member; // 메인 메서드 안에서 선언한 참조변수는 '지역변수'이다.

참조변수 member만 선언하고 객체주소를 대입하지 않으면 해당 변수는 지역변수라서 클래스 소속의 멤버변수처럼
기본값 null로 초기화가 안된다. 이런 경우 해당 참조변수 member로 Member10 클래스 소속의 멤버변수인 속성에
접근하면 초기화가 되지 않아서 컴파일 에러가 발생한다.
만약 클래스 소속의 멤버변수라면 기본값 null로 초기화가 되고 해당 멤버변수로 접근하면 컴파일은 되지만
예외 오류가 발생한다.
지역변수는 기본 초기값이 없다. 그러므로 선언과 동시에 명시적인 코드로 초기화를 해야 한다.

/*======================================================================*/

ObjEx11.java
기본 타입 매개변수는 값만 전달된다. 객체주소를 공유하지 않아서 값도 공유 못 한다.

class Data11{
	int x; // 클래스 소속의 멤머변수가 int 타입이면 명시적인 초기화를 하지 않아도 기본값 0으로 초기화가 된다.
}

static void change(int a){ // 정젝 메서드
	a = 1000;
}
Data11 d = new Data11();
d.x = 100;
change(d.x);
// 100
객체 주소를 공유 하지 않아서 d.x의 값은 100이다.

/*======================================================================*/

ObjEx12.java
레퍼런스 변수(참조변수)만 선언하고 null만 대입된 상태에서 클래스 소속의 멤버변수에 접근하며 NullPointerException
예외 오류가 발생한다. 이런 경우 정상적인 컴파일은 되고 바이트코드 클래스파일도 만들어 진다. 하지만 이 클래스가
실행시 예외오류가 난다.

class MyDate12{
	int year = 2026;
	int month = 1;
	int date = 1;
}

MyDate12 d = new null;

/*======================================================================*/

ObjEx13.java
참조타입 매개변수는 객체 주소값이 전달되어져서 주소값을 공유한다. 그러므로 변경된 값도 공유할 수 있다.

class Data13{
	int x;
}

static void change(Data13 d2){ // 참조타입 매개변수 d2 -> 객체주소가 전달외어져서 공유된다.
	d2.x = 1000;
	System.out.println(d2.x); // 1000
}

Data13 d = new Data13();
d.x = 100;
System.out.println(d.x); // 100

change(d); // d객체주소가 전달
System.out.println(d.x) // 1000
// 객체주소값이 공유되어서 메서드 호출 후 변경된 값 1000도 공유된다.

/*======================================================================*/

ObjEx14.java
매개변수가 int[] arr이면 이것은 배열이라서 참조타입에 해당된다. 주소값을 공유해서 배열원소값도 공유할 수 있다.

static void change(int[] arr){// int[] arr 배열 참조타입 매개변수
	arr[0] = 1000; // 첫번쨰 배열원소값을 100에서 1000으로 변경
	System.out.println(a[0]); // 1000
}

int[] x = { 100 };
System.out.println(x[0]); // 100
change(x);
System.out.println(x[0]); // 1000

/*======================================================================*/

ObjEx15.java
/**
 * 개발일자 2025년 12월 22일 
 * 오후 12월 31분 
 * 개발자 : 홍길동 
 * 참조타입 배열 배개변수
 */
public class ObjEx15 {
	
	
	public static void main(String[] args) {

		int[] arr = { 3, 2, 1, 6, 5, 4 };
		
		printArr(arr);
		/*
		 * 문제01) 자바5에서 추가된 향상된 확장 for 반복문을 사용해서 다음과 같이 배열원소값이 출력되게 static void
		 * printArr(int[] arr){ } 정적메서드를 작성한다.
		 * 
		 * 출력 예) [3,2,1,6,5,4]
		 *        =============
		 *        
		 */
		
		ObjEx15 obj15 = new ObjEx15();
		int total = obj15.getTotal(arr);
		/*
		 * 문제02) 일반 for반복문을 사용해서 배열원소 총합을 구해서 반환하는 코드를 int getTotal(int[] arr){}
		 * 블록내에 작성해본다.
		 */
		
		System.out.printf("arr배열원소 총합 = %d \n", total);

	}
	
	// 1번 답안코드
	static void printArr(int[] arr) {
		System.out.print("[");
		int i =0;
		
		for(int k:arr) {	// 향상된 for 반복문
			System.out.print(k);	// 숫자 출력
			if(i < arr.length - 1) {	// 배열의 마지막 인덱스-1 보다 i가 작을 경우
				System.out.print(", ");
			}
			i++;	// i증감
		}
		
		System.out.println("]");
		
		System.out.println("\n ============================ \n");
	}
	
	// 2번 답안코드
	int getTotal(int[] arr) {	// 총 합을 구해서 반환이니 return 이 있어야된다.
		int total = 0;
		
		for(int i =0; i<arr.length; i++) {
			total+=arr[i];
		}
		return total;
	}

}


'참고 소스'
Day08_java/src/
ObjEx01.java
ObjEx02.java
ObjEx03.java
ObjEx04.java