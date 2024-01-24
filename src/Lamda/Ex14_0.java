package Lamda;

public class Ex14_0
{
    public static void main(String[] args)
    {
//        Object obj = (a, b) -> a > b ? a : b; //람다식, 익명객체

//        익명 객체
//        메서드만 존재할수 없기때문에 이렇게 익명 객체 안에 넣어서 표현해야한다.
        Object obj = new Object()
        {
            int max(int a, int b)
            {
                return a > b ? a : b;
            }
        };

//        int value = obj.max(3,5); // 여기서 필요한게 함수형 인터페이스

        MyFunction myFun = new MyFunction()
        {
            @Override
            public int max(int a, int b)
            {
                return a > b ? a : b;
            }
        };

        MyFunction myFun2 = (a, b) -> a > b ? a : b;

        int value = myFun.max(3, 5);
        int value2 = myFun2.max(7, 9);

        System.out.println("value 최대값 : " + value);
        System.out.println("value2 최대값 : " + value2);
    }
}

@FunctionalInterface //함수형 인터페이스라고 선언해주는거 ::: 이걸 해주면 메서드가 2개면 에러처리해줌
interface MyFunction
{
    public abstract int max(int a, int b);
}