package Steam;

import java.util.stream.Stream;

public class Ex14_6_LambdaStreamMaking
{
    public static void main(String[] args)
    {
        /*
        스트림 만들기 - 람다식 iterate(), generate()
        * 람다식을 소스로 하는 스트림 생성하기                      [요 두놈들은 무한스트림이다]

        static <T> Stream<T> iterate(T seed [초기값] , UnaryOperator<T> f [람다식])    // 이전 요소에 종속적
        핵심은 iterate(T seed, UnaryOperator f) 단항 연산자(즉 하나를 넣은 결과가 하나 나오는것).
        ex) ＃iterate()는 이전 요소를 seed로 해서 다음 요소를 계산한다.
            Stream<Integer> evenStream = Stream.iterate(0, n->n+2);

            result)              무한스트림
                                0 -> 0 + 2
                                2 -> 2 + 2
                                4 -> 4 + 2
                                6 -> 6 + 2
                                    ...

        static <T> Stream<T> generate(Supplier<T> s)                // 이전 요소에 독립적
        핵심은 안에 Supplier 공급자!! 주기만 하는 것 입력 X, 출력 O
        ex) ＃ generate()는 seed를 사용하지 않는다.
            Stream<Double> randomStream = Stream.generate(Math::random);
            Stream<Integer> oneStream = Stream.generate(()->1); // 존나 계속 1이 나온다.
         */

        Stream<Integer> intStream = Stream.iterate(0, n->n+2);
        intStream.limit(10).forEach(System.out::println);

        Stream<Integer> oneStream = Stream.generate(() -> 1);
        oneStream.limit(10).forEach(System.out::println);
    }
}
