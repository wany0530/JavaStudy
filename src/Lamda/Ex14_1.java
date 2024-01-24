package Lamda;

public class Ex14_1
{
    static void execute(MyFunction2 f) // 매개 변수 타입이 MyFunction2인 메서드
    {
        f.run();
    }

    static MyFunction2 getMyFunction() // 변환 타입이 MyFunction인 메서드
    {
//        MyFunction2 f = () -> System.out.println("f3.run()");
//        return f;
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args)
    {
        //람다식으로 MyFunction2의 run()을 구현
        MyFunction2 f1 = () -> System.out.println("f1.run()");

        MyFunction2 f2 = new MyFunction2() // 익명클래스로 run()을 구현
        {
            @Override
            public void run()   // public을 반드시 붙여야 함
            {
                System.out.println("f2.run()");
            }
        };

        MyFunction2 f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();
        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}
@FunctionalInterface
interface MyFunction2
{
    void run(); // public abstract void run(); ::: public abstart는 생략해도 알아서 인식을한다.
}