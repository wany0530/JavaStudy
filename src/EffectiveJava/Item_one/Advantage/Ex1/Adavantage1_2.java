package EffectiveJava.Item_one.Advantage.Ex1;

/**
 * @author : ljw6398@nets.co.kr
 * @TeskContents :
 *
 * 생성자는 시그니처에 제약이 있다.
 * 똑같은 타입을 파라미터로 받는 생성자 두개를 만들 수 없으니까 그런 경우에도 public static 팩토리 메소드를 사용하는것이 유용하다.
 *
 *
 * EX)  밑의 코드와 같이 매개변수가 1개인 생성자를 만들수가 없으니.
 *
 * public Adavantage1_2(String name)
 * {
 *         this.name = name;
 * }
 *
 * public Adavantage1_2(String address)
 * {
 *         this.address = address;
 * }
 */
public class Adavantage1_2
{
    String name;
    String address;

    public Adavantage1_2() {}

    public Adavantage1_2(String name)
    {
        this.name = name;
    }


    public static Adavantage1_2 withName(String name)
    {
        return new Adavantage1_2(name);
    }

    public static Adavantage1_2 withAddress(String address)
    {
        Adavantage1_2 item = new Adavantage1_2();
        item.address = address;
        return item;
    }

    public static void main(String[] args)
    {
        Adavantage1_2 item = new Adavantage1_2("이재완");

        Adavantage1_2 item1 = Adavantage1_2.withName("이재완");  // 즉 이게 좀 더 명확하다.
        Adavantage1_2 item2 = Adavantage1_2.withAddress("경기도 하남시");
    }
}
