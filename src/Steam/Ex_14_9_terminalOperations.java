package Steam;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex_14_9_terminalOperations
{
    /*
    Stream의 연산
        1. 중간 연산 : n번
            1-1 Stream을 반환
            1-2 종류 : limit(), skip(), filter(), distinct(), map(), flatMap()

        2. 최종 연산 : 1번
            2-1. 스트림이 닫힘
            2-2. 스트림 요소 소모
            2-3. int, boolean, Optional 반환
            2-4. 종류 : forEach(), allMatch(), anyMatch(), noneMatch(),
                        reduce()[핵심임], collect()[핵심임], find(), findAny(), findFirst()

        # 스트림의 모든 요소에 지정된 작업을 수행 - forEach(), forEachOrderd()
            void forEach(Consumer<? super T> action)                            // 병렬스트림인 경우 순서가 보장되지 않음
            void forEachOrdered(Consumer<? super T> action)                     // 병렬스트림인 경우에도 순서가 보장됨 (대신 성능이 느리겠쥬?)

            IntStream.range(1, 10).sequential().forEach(System.out::print);     // 123456789 (하나의 쓰레드가 처리하기때문에 순서대로)
            IntStream.range(1, 10).sequential().forEachOrderd(System.out:print);// 123456789

            sequential()은 직렬스트림이란 뜻이고 생략이 가능하다.

            IntStream.range(1, 10).parallel().forEach(System.out::print);     // 683295714 (여러 쓰레드가 처리하기때문에 섞여나온다)
            IntStream.range(1, 10).parallel().forEachOrderd(System.out:print);// 123456789

            parallel()은 병렬스트림이란 뜻이다.


        # 조건 검사 - allMatch(), anyMatch(), noneMatch()
            boolean allMatch (Predicate<? super T> predicate) // 모든 요소가 조건을 만족시키면 true
            boolean anyMatch (Predicate<? super T> predicate) // 한 요소라도 조건을 만족시키면 true
            boolean noneMatch (Predicate<? super T> predicate) // 모든 요소가 조건을 만족시키지 않으면 true

            boolean hasFailedStu = stuStream.anyMatch(s -> s.getTotalScore() <= 100); // 낙제자가 있는지?

        # 조건에 일치하는 요소 찾기 - findFirst(), findAny() ※ find함수는 filter랑 같이쓴다.
            - Optional은 결과가 null일수도 있어서~ 을 가지고있는 타입?

            Optional<T> findFirst()     //첫 번째 요소를 반환. 순차 스트림에 사용
            Optional<T> findAny()       //아무거나 하나를 반환. 병렬 스트림에 사용

            ex)
                Optional<Student> result = stuStream.filter(s->s.getTotalScore() <= 100).findFirst();
                Optional<Student> result = parallelStream.filter(s -> s.getTotalScore() <= 100).findAny();

        # 스트림의 요소를 하나씩 줄여가며 누적연산 수행 - reduce()
          누적 연산이란 accumulater라고 한다.

        Optional<T> reduce(binaryOperator<T> accumulator)
        T           reduce(T identity, BinaryOperator<T> accumulator)
        U           reduce(T identity, BinaryOperator<T> accumulator, BinaryOperator<U> combiner)

        ∞ identity - 초기값
        ∞ accumulator - 이전 연산결과와 스트림의 요소에 수행할 연산
        ∞ combiner - 병렬처리된 결과를 합치는데 사용할 연산 (병렬 스트림)

        int count = intStream1.reduce(0, (a,b) -> a+1);
        int sum = intStream2.reduce(0, (a,b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

     */

    /**
     * reduce(0, (a,b) -> a + b)는 아래를 의미한다.
     * -----------------------
     * - int a = identity;   -
     * -                     -
     * - for(int b: stream)  -
     * -    a = a + b;       -
     * -----------------------
     */

    public static void main(String[] args)
    {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream", "OptionalDouble", "IntStream", "count", "sum"
        };

//        Stream.of(strArr).forEach(System.out::println);
        Stream.of(strArr)
                .parallel() // 병렬로 처리
                .forEachOrdered(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
//        Optional<String> sWord = Stream.of(strArr).filter(s->s.charAt(0) == 's').findFirst();
        Optional<String> sWord = Stream.of(strArr).parallel().filter(s->s.charAt(0) == 's').findAny(); // 결과값이 stream일수도 sum일수도 있다!! 왜냐하면 병렬로 처리했기때문
        System.out.println("noEmptyStr=" + noEmptyStr);
        System.out.println("sWord=" + sWord.get());

        Stream<Integer> intstream0 = Stream.of(strArr).map(String::length);

        // Stream<String[]>을 IntStream으로 변환. IntStream 기본형 스트림 / 근본적으로 Stream<Integer>와 같지만? 성능이 더 좋다.
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a + 1);
        int sum = intStream2.reduce(0, (a,b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("count=" + count);
        System.out.println("sum=" + sum);
        System.out.println("max=" + max.getAsInt());
        System.out.println("min=" + min.getAsInt());
        System.out.println("max=" + max.orElse(0));
        System.out.println("min=" + min.orElse(0));
    }
}
