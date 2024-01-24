package Enum;

import java.util.Arrays;

public class Ex12_0
{
    /*
    열거형(enum)
        # 관련된 상수들을 같이 묶어 놓은 것, Java는 타입에 안전한 열거형을 제공
        ex)
            class Card {
                static final int CLOVER = 0;
                static final int HEART = 1;
                static final int DIAMOND = 2;
                static final int SPADE = 3;

                static final int TWO = 0;
                static final int THREE = 1;
                static final int FOUR = 2;

                final int kind;
                final int num;
            }

            class Card {      0       1       2       3
                enum Kind { CLOVER, HEART, DIAMOND, SPADE }
                              0     1      2
                enum Value { TWO, THREE, FOUR }
                final Kind kind;
                final Value value;
            }

             if(Card.CLOVER == CARD.TWO) // 이론상 true이지만 (값만 체크한 결과)
                                            우리가 원하는것은 모양과 숫자가 달라야하기 때문에 false이다 .
                                            C에서는 값만 Check, JAVA에서는 타입과 값 모두 체크하기때문에
                                            java에서는 이것을 지원함으로서 False가 출력된다.

       # 열거형을 정의하는 방법
            enum 열거형 이름 { 상수명1, 상수명2, ... }
            ex) enum Direction { EAST, SOUTH, WEST, NORTH }

       # 열거형 타입의 변수를 선언하고 사용하는 방법
            ex)
               class Unit {
                    int x, y;
                    Direction dir;

                    void int() {
                        dir = Direction.EAST
                    }
               }

       # 열거형 상수의 비교에는 ==와 compareTo() 사용가능
            ex)
                if(dir == Direction.EAST)
                {
                    x++;
                }
                else if(dir > Direction.WEST) // Error. 열거형 상수에 비교연산자 사용불가.
                {
                    ...
                }
                else if(dir.compareTo(Direction.WEST) > 0)
                {
                    ...
                }
       # Enum클래스 = 모든 열거형은 Enum의 자손이며, 아래의 메서드를 상속받는다.
            String name() : 열거형 상수의 이름을 문자열로 반환
            int ordinal() : 열거형 상수가 정의된 순서를 반환(0부터 시작)
            T valueOf(Class<T> enumType, String name) : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환

            - values(), valueOf()는 컴파일러가 자동으로 추가
            static E[] values()
            static E valuesOf(String name)

            Direction[] dArr = Direction,values();

            for(Direction d : dArr)
                System.out.printf("%s = %d%n", d.name(), d.ordinal());

     */
    enum Direction { EAST, WEST, SOUTH, NORTH }
    public static void main(String[] args)
    {
//        System.out.println(Arrays.stream(Direction.values()).map(a -> String::valueOf()));

        Direction d1 = Direction.EAST;  //열거형타입.상수이름
        Direction d2 = Direction.valueOf("WEST"); //열거형타입.valueOf("문자열")로 상수이름을 얻을수있다.
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        System.out.println("d3=" + d3);

        System.out.println("d1 == d2 ? " + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
        System.out.println("d1.equls(d3) ? " + d1.equals(d3));
//        System.out.println("d1 > d3 ? " + (d1 > d3)); //에러
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
        System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d3));

        switch (d1)
        {
            case EAST: // Direction.EAST라고 쓸 수 없다.
                System.out.println("The direction is EAST.");
                break;
            case WEST: // Direction.EAST라고 쓸 수 없다.
                System.out.println("The direction is WEST.");
                break;
            case SOUTH: // Direction.EAST라고 쓸 수 없다.
                System.out.println("The direction is SOUTH.");
                break;
            case NORTH: // Direction.EAST라고 쓸 수 없다.
                System.out.println("The direction is NORTH.");
                break;
            default:
                System.out.println("Invalid direction.");
                break;
        }

        Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환.
        for(Direction d : dArr)
        {
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        }

    }
}
