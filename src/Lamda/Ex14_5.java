package Lamda;

import java.util.function.Function;
import java.util.function.Supplier;

public class Ex14_5
{
    /**
     *
     * 메서드 참조 => 클래스이름 :: 메서드이름
     * 개중요함.
     *
     */
    //1. static 메소드 참조

    //Function<String, Integer> f = (String s) -> Integer.parseInt(s);
    // 위에 놈은 String s를 생략할수있다 왜냐하면 <String, Integer>에서 입력은 String이라고 이미 선언을 했기때문에
    Function<String, Integer> f = Integer::parseInt; //이놈이 메소드 참조

    public static void main(String[] args)
    {
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;
        System.out.println(f1.apply("100") + 200);
        System.out.println(f2.apply("300") + 200);

        // Supplier는 입력 X, 출력 O
//        Supplier<MyClass> s = () -> new MyClass();
//        Supplier<MyClass> s = MyClass::new; // Myclass에서 생성자에 int iv값을 줘야하니 더이상 Supplier가 아니다.
        Function<Integer, MyClass> ff1 = (i) -> new MyClass(1);
        Function<Integer, MyClass> ff2 = MyClass::new;

        /*
        MyClass mc = s.get();
        System.out.println(mc);
        System.out.println(s.get());
        */
        MyClass mc2 = ff2.apply(100);
        System.out.println(mc2);
        System.out.println(ff2.apply(101));
        System.out.println(mc2.iv);
        System.out.println(ff2.apply(101).iv);

//        Function<Integer, int[]> f01 = (i) -> new int[];
        Function<Integer, int[]> f01 = int[]::new;
//        Function<Integer, int[]> f02 = 클래스이름::메서드이름;
//          배열 생성은 꼭 Function으로 해야한다. 왜냐하면 입력으로 배열의 크기를 줘야하기때문.

        int[] arr = f01.apply(100);
        System.out.println("arr.length=" + arr.length);




    }
    //2. 인스턴스 메소드 참조
//    생성자와 메서드참조
//      Supplier<MyClass> s = () -> new MyClass(); 는 Function<X, MyClass>와 똑같다
//      Supplier<MyClass> s = MyClass::new;
//      다시 : Function<Integer, MyClass> s = (i) -> new MyClass(i);
//      Function<Integer, MyClass> s = MyClass::new;
//      BiFunction<T,U,R> 일떄 T,U가 입력이다.
//      ex) Function<Integer, int[]> f = x -> int[x]; // 여기서 Integer는 배열 길이이다.
//      Function<Intger, int[]> f2 = int[]::new;// 메서드 참조.

}

class MyClass{
    int iv;
    MyClass(int iv){
        this.iv = iv;
    }

}