package Thread;

public class Ex13_11
{
    static long startTime = 0;

    public static void main(String[] args)
    {
        ThreadEx11_1 th1 = new ThreadEx11_1();
        ThreadEx11_2 th2 = new ThreadEx11_2();
        th1.start();
        th2.start();

        startTime = System.currentTimeMillis();

        try
        {
            th1.join(); // join()는 main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join(); // join()는 main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        }
        catch (InterruptedException e) {}

        // 15~20번째 line을 주석처리하고 실행하면 결과로 소요시간:***뜨고 |||----||-(블라블라)가 실행된다.
        // 왜냐하면 위의 join()메소드는 특정Thread.join()을 하면 (해당Thread)가 모두 끝날때가지 main쓰레드를 종료X
        // (기다려라)라는 기능을 가지고 있기 때문.


        // TODO :: 즉 여기서 말하고싶은건 main메소드가 끝나도 프로그램이 종료되지않는다는 점이다.
        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }

}

class ThreadEx11_1 extends Thread
{
    @Override
    public void run()
    {
        for(int i=0; i < 300; i++)
        {
            System.out.print(new String("-"));
        }
    } // run()
}

class ThreadEx11_2 extends Thread
{
    @Override
    public void run()
    {
        for(int i=0; i < 300; i++)
        {
            System.out.print(new String("|"));
        }
    } // run()
}