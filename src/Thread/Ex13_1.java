package Thread;

public class Ex13_1
{
    public static void main(String[] args)
    {
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)

        t1.start(); // start()메소드 = 쓰레드 시작하는 메소드.
        t2.start();
// 위의 방식은 2개의 쓰레드를 만든놈이기 떄문에 멀티 쓰레드(값이 섞인다.)


//  밑의 방식은 하나의 쓰레드로 돌아가는것
//  (왜냐하면 1. 앞의 for문이 끝나고 난 뒤
//           2. 뒤의 for문이 돌아가서 [값이 섞이지 않는다.]

//        for(int i=0; i < 500; i++)
//        {
//            System.out.println(t1.getName()); // 조상인 Thread의 getName()을 호출
//        }
//        for(int i=0; i<500; i++)
//        {
//            System.out.println(Thread.currentThread().getName());
//        }

    }
}

class ThreadEx1_1 extends Thread
{
    @Override
    public void run() // run()이란 쓰레드가 수행할 작업을 작성
    {
        for (int i = 0; i < 500; i++)
        {
            System.out.println(getName()); // 조상인 Thread의 getName()을 호출
        }
    }
}

class ThreadEx1_2 implements Runnable
{
    @Override
    public void run() // run()이란 쓰레드가 수행할 작업을 작성
    {
        for (int i = 0; i < 500; i++)
        {
//            Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}