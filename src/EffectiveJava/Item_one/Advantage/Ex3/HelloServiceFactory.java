package EffectiveJava.Item_one.Advantage.Ex3;

/**
 * @author : ljw6398@nets.co.kr
 * @TeskContents :
 * 장점3 : 리턴 타입의 하위 타입 인스턴스를 만들수도 있다.
 *
 * 클래스에서 만들어 줄 객체의 클래스를 */
public class HelloServiceFactory
{
    public static HelloService of(String lang)
    {
        if(lang.equals("ko"))
        {
            return new KoreanHelloService();
        }
        else
        {
            return new EnglishHelloService();
        }
    }
}
