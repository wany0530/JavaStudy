package Thread;

public class Ex13_2
{
    public static void main(String[] args)
    {
        // 싱글쓰레드 (Single Thread)로 작성
        long startTime = System.currentTimeMillis();

        for(int i =0; i < 300; i++)
        {
            System.out.printf("%s", new String("-"));
        }

        System.out.println("소요시간1 : " + (System.currentTimeMillis() - startTime));

        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("|"));

        System.out.print("소요시간2 : " + (System.currentTimeMillis() - startTime));
    }
}
