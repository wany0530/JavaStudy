package EffectiveJava.Item_one.Advantage.Ex2;

/**
 * @author : ljw6398@nets.co.kr
 * @TeskContents :
 *
 * 장점 2 : 반드시 새로운 객체를 만들 필요가 없다.
 * 불변 클래스인 경우나 매번 새로운 객체를 만들 필요가 없는 경우에
 * 미리 만들어둔 인스턴스 또는 캐시해둔 인스턴스를 반환할 수 있다
 * Bollean.valueOf(boolean) 메소드도 그 경우에 해당한다.
 */
public class Adavantage2
{
    private static final Adavantage2 advSecond = new Adavantage2();

//    public Adavantage2() {} // 생성자를 public일 경우 사용자( 작성자가 아닌 Adavantage2 클래스를 사용하는 사용자)들이 얼마든지 생성할수있지만,
    private Adavantage2(){} // 생성자가 private일 경우

    public static Adavantage2 getAdvSecond()
    {
        return advSecond;
    }

    public static Adavantage2 newInstance()
    {
        return advSecond;
    }

    public static void main(String[] args)
    {
        Adavantage2 advS = Adavantage2.getAdvSecond();
        Adavantage2 advS1 = Adavantage2.newInstance();
        Adavantage2 advS2 = Adavantage2.newInstance();
        Adavantage2 advS3 = Adavantage2.newInstance();
        System.out.println(advS);
        System.out.println(advS1);
        System.out.println(advS2);
        System.out.println(advS3);

        // 처음은 새로운 객체겠지만 이전에 사용했다면 미리 생성했던 객체.
        // 즉 객체를 재사용.
    }
}
