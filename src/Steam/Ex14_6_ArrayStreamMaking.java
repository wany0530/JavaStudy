package Steam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_6_ArrayStreamMaking
{
    public static void main(String[] args)
    {
         /*
        객체 배열로 부터 스트림 생성하기
        Stream<T> Stream.of(T...values) // 가변인자
        Stream<T> Stream.of(T[])
        Stream<T> Arrays.stream(T[])
        Stream<T> Arrays.stream(T[] array(배열), int startInclusive(시작), int endExclusive(끝)) 범위 ※끝의 번호는 들어가지않는다
        ex) (strArr, 1, 4)이면 1,2,3을 뜻함

        기본형 배열로부터 스트림 생성하기
        IntStream IntStream.of(int... values)
        IntStream IntStream.of(int[])
        IntStream Arrays.stream(T[])
        IntStream Arrays.stream(T[] array(배열), int startInclusive(시작), int endExclusive(끝)) 범위 ※끝의 번호는 들어가지않는다
        */



        System.out.println("--------------냥냥펀치---------------");


        Stream<String> strStream1 = Stream.of("a", "b", "c");
        strStream1.forEach(System.out::print);
        System.out.println();
        Stream<String> strStream2 = Stream.of(new String[] {"a", "b", "c"});
        strStream2.forEach(System.out::print);
        System.out.println();
        Stream<String> strStream3 = Arrays.stream(new String[]{"a", "b", "c"});
        strStream3.forEach(System.out::print);
        System.out.println();
        Stream<String> strStream4 = Arrays.stream(new String[]{"a","b","c"}, 0, 3); // 0, 1, 2 범위다!! 헷갈리지않기
        strStream4.forEach(System.out::print);
        System.out.println();

        int[] intArr = {1,2,3,4,5};
        IntStream intStream01 = Arrays.stream(intArr);
//        intStream01.forEach(System.out::print);
//        System.out.println(intStream01.sum());
        System.out.println(intStream01.average());
        System.out.println();

        Integer[] intArr2 = {1,2,3,4,5};
        Stream<Integer> intStream02 = Arrays.stream(intArr2);
//        intStream01.forEach(System.out::print);
        System.out.println(intStream02.count());
//        System.out.println(intStream02.sum());          //에러 IntStream에서는 가능하지만 Stream<Integer>에서는 못한다.
//        System.out.println(intStream02.average());      //에러 IntStream에서는 가능하지만 Stream<Integer>에서는 못한다.
        System.out.println();

    }
}
