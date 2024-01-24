package Steam;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_6_RandomStreamMaking
{
    public static void main(String[] args)
    {
        /*
        * 스트림 만들기 - 임의의 수

        * 난수를 요소로 갖는 스트림 생성하기
        IntStream intStream = new Random().ints();           // 무한스트림
        IntStream.limit(5).forEach(System.out::println);    // 5개의 요소만 출력한다.
        IntStream intStream = new Random().ints(5);         // 크기가 5인 난수 스트림을 반환

        ints(), longs(), doubles()는 Random클래스에 정의되어있는 메소드로서
        스트림에는 유한, 무한 스트림으로 나뉘는데
        위 3개 메소드들은 무한 스트림을 생성한다.

        Integer.MIN.VALUE <= ints() <= Integer.MAX_VALUE
        Long.MIN.VALUE <= longs() <= Long.MAX_VALUE
        0.0 <= double() < 1.0

        * 지정된 범위의 난수를 요소로 갖는 스트림을 생성하는 메서드(Random클래스)
        IntStream ints(int begin, int end)                      // 무한 스트림
        LongStream longs(long begin, long end)
        DoubleStream doubles(double begin, double end)

        IntStream ints(long streamSize, int begin, int end)     // 유한 스트림
        LongStream longs(long streamSize, long begin, long end)
        DoubleStream doubles(long streamSize, double begin, double end)
        */

        IntStream intStream = new Random().ints();
//        intStream.forEach(System.out::println);             // 무한 스트림으로 쭈루룩 계속 나온다.

        IntStream intStream1 = new Random().ints(5); // intStream.limit(5).forEach(System.out::println) 와 같다
//        intStream1.forEach(System.out::println);              결과값 : 5개의 난수
//        intStream.limit(5).forEach(System.out::println);      결과값 : 5개의 난수

        IntStream intStream2 = new Random().ints(5, 10); // 범위가 5부터 10까지 무한스트림이 나온다.
//        intStream2.forEach(System.out::println);              결과값 : 5~10범위 무한스트림

        IntStream intStream3 = new Random().ints(10,5, 10); // 범위가 5부터 10까지 무한스트림이 나온다.
//        intStream3.forEach(System.out::println);              결과값 : 5~10범위 10개 출력
//        intStream2.limit(10).forEach(System.out::println);    결과값 : 5~10범위 10개 출력



        Stream<Integer> evenStream = Stream.iterate(0, n->n+2);
        Stream<Double> randomStream = Stream.generate(Math::random);


    }
}
