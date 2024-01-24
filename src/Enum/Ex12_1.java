package Enum;

public class Ex12_1
{
    /*
    열거형에 멤버 추가하기
        # 불연속적인 열거형 상수의 경우, 원하는 값을 괄호()안에 적는다.
        enum Direction { EAST(1), SOUTH(5), WEST(-1), NORTH(10) }

        # 위 와 같이 괄호()를 사용하려면, 인스턴스 변수와 생성자를 새로 추가해줘야한다.
        enum Direction
        {
            EAST(1), WEST(-1), SOUTH(5), NORTH(10);
            private final int value; // 정수를 저장할 필드(인스턴스 변수)를 추가해줘야한다. + IV라고 명칭
            Direction(int value) { this.value=value); ★열거형 생성자는 항상 private로 묵시적★
            public int getValue() { return value }
        }
    */
    enum Direction2
    {
        EAST(1, "→"), WEST(2, "←"), SOUTH(3,"↓"), NORTH(4,"↑");
        private static final Direction2[] DIR_ARR = Direction2.values();
        private final int value;
        private final String symbol;

        Direction2(int value, String symbol)
        {
            this.value = value;
            this.symbol = symbol;
        }

        public int getValue()
        {
            return value;
        }

        public String getSymbol()
        {
            return symbol;
        }

        public static Direction2 of (int dir)
        {
            if(dir < 1 || dir > 4)
                    throw new IllegalArgumentException("Invalid value :" + dir);

            return DIR_ARR[dir - 1];
        }

        // 방향을 회전시키는 메서드. num의 값만큼 90도씩 시계방향으로 회전한다.
        public Direction2 rotate(int num)
        {
            num = num % 4;
            if(num < 0) num += 4; // num이 음수일 때는 시계반대 방향으로 회전

            return DIR_ARR[(value-1 + num) % 4];
        }

        @Override
        public String toString()
        {
            return name() + getSymbol();
        }
    }
    public static void main(String[] args)
    {
        for(Direction2 d : Direction2.values())
            System.out.printf("%s = %d%n", d.name(), d.getValue());

        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.EAST.rotate(2));
        System.out.println(Direction2.EAST.rotate(-1));
        System.out.println(Direction2.EAST.rotate(-2));
        System.out.println();

    }
}
