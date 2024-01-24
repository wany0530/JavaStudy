package Thread;

public class Ex13_6_1
{
    //TODO :: 쓰레드 그룹 관련 예제
    public static void main(String[] args)
    {
        ThreadGroup main = Thread.currentThread().getThreadGroup(); // 메인쓰레드 그룹에 속하겠쥬?
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

//        ThreadGroup(ThreadGroup parent, String name)
        ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
        grp1.setMaxPriority(3); // 쓰레드 그룹 qrp1의 최대우선순위를 3으로 변경.

        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(1000);
                }catch (InterruptedException e){}
            }
        };
//        Thread(ThreadGroup tg, Runnable r, String name)
        new Thread(grp1, r, "th1").start();
        new Thread(subGrp1, r, "th2").start();
        new Thread(grp2, r, "th3").start();

        StringBuilder sb = new StringBuilder();
        sb.append(">>List of ThreadGroup : ").append(main.getName()).append(", Active ThreadGroup: ").append(main.activeGroupCount()).append(", Active Thread: ").append(main.activeCount());
        System.out.println(sb);
        main.list();
    }
}
