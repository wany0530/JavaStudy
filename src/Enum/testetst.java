package Enum;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : ljw6398@nets.co.kr
 * @TeskContents :
 */
public class testetst
{
    enum Direction {
        EAST("동쪽", "1"), SOUTH("남쪽", "3"), WEST("서쪽", "2"), NORTH("북쪽", "4");

        private final String title;
        private final String cnt;

        Direction(String title, String cnt)
        {
            this.title = title;
            this.cnt = cnt;
        }

        public static Direction valueOfLabel(String label) {
            return Arrays.stream(values())
                    .filter(value -> value.name().equals(label))
                    .findAny()
                    .orElse(null);
        }
    };

    public static void main(String[] args)
    {
//        if(Enum.valueOf(Direction.class, "hihi") == null)
//        {
//            System.out.println("hihi");
//        }


        EnumSet<Direction> enumSet = EnumSet.allOf(Direction.class);
        EnumSet<Direction> enumSet2 = EnumSet.copyOf(EnumSet.of(Direction.EAST, Direction.SOUTH));

        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        System.out.println("d3=" + d3);

        System.out.println("d1==d2 ? " + (d1 == d2));
        System.out.println("d1==d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ?" + d1.equals(d3)); // Direction의 각 값이 단순한 상수가 아니라 객체이기 때문에 equals로 비교 가능
//        System.out.println("d2 > d3 ?" + (d1 > d3)); // 에러
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

        switch (d1) {
            case EAST: // Direction.EAST 라고 쓸 수 없다.
                System.out.println("The direction is EAST.");
                break;
            case WEST:
                System.out.println("The direction is WEST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH.");
                break;
            case NORTH:
                System.out.println("The direction is NORTH.");
                break;
            default:
                System.out.println("Invalid Direction.");
        }

        Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환

        for (Direction d : dArr) { // 상수의 이름, 상수의 순서(!= 값)
            // 부여한 상수와 순서값이 일치하지 않을 수 있다.
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        }
    }
}