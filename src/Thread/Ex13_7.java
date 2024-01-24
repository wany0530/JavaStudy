package Thread;

//TODO :: Daemon 쓰레드
public class Ex13_7 implements Runnable
{
    static boolean autoSave = false;
    public static void main(String[] args)
    {
        Thread t = new Thread(new Ex13_7()); // Thread(Runnable r)
        t.setDaemon(true); // 이 부분이 없으면 종료 되지 않는다(계속 autoSave()가 돌아간다). + TODO :: 절대 start()보다 늦게 실행되면 안된다.
        t.start();

        for(int i=1; i <= 10; i++)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {}
            System.out.println(i);

            if(i==5) autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");

    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(3 * 1000);//3초마다
            }
            catch (InterruptedException e) {}

            // autoSave의 값이 true이면 autoSave()를 호출한다.
            if(autoSave) autoSave();
        }
    }

    public void autoSave()
    {
        System.out.println("작업파일이 자동저장 되었습니다.");
    }
}
