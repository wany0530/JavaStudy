package EffectiveJava.Item_one.Advantage.Ex1;

/**
 * @author : ljw6398@nets.co.kr
 * @TeskContents :
 * 생성자에 제공하는 파라미터가 거기서 반환하는 객체를 잘 설명하지 못할 경우에,
 * 잘만든 이름을 가진 static 팩토리를 사용하는것이 사용하기보다 더 쉽고(해당 팩토리 메소드의 클라이언트 코드를) 읽기 편하다.
 */
public class Adavantage1_1
{
    String name;

    public Adavantage1_1(String name)
    {
        this.name = name;
    }

    public static Adavantage1_1 withName(String name)
    {
        return new Adavantage1_1(name);
    }

    public static void main(String[] args)
    {
        Adavantage1_1 adv = new Adavantage1_1("이재완");

        Adavantage1_1 adv1 = Adavantage1_1.withName("이재완");
    }
}
