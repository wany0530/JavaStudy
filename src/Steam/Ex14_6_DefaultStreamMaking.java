package Steam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex14_6_DefaultStreamMaking
{
    public static void main(String[] args)
    {
        //다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
        //컬렉션 List, Set, Map, 배열 로부터 stream을 만들수있다.
        // 1. 스트림 만들기
        // 2. 중간 연산(0~n번)
        // 3. 최종 연산(한번)
        // 스트림이란 데이터의 흐름?
        // 스트림이 제공하는 기능 - 중간 연산과 최종연산

        /**
         *  Collection으로 stream을 만드려면 stream()메소드를 이용하고
         *  배열로 stream을 만드려면 .of() 또는 Arrays.stream(T[])한다.
         */

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream(); // list를 Stream으로 새롭게 생성
        intStream.forEach(System.out::print);
        System.out.println();
//      intStream.forEach(System.out::print); // 한번더 출력하면 Error 왜냐하면 Stream은 일회용이기때문에 새로 생성해서 만들어야한다.
//      stream은 1회용, stream에 대해 최종연산을 수행하면 stream이 닫힌다.
        intStream = list.stream(); // list로 부터 stream을 다시 생성
        intStream.forEach(System.out::print); //다시 출력
        System.out.println();

        /*
        1. 스트림 만들기
        2. 중간연산(0~n번)
            - 종류
                1. 스트림 필터링 : filter(), distinct()
                2. 스트림 변환 : map(), flatMap()
                3. 스트림 제한 : limit(), skip()
                4. 스트림 정렬 : sorted()
                5. 스트림 연산 결과 확인 : peek()
            - 연산결과가 스트림인 연산. 반복적으로 적용 가능
                    중복제거    5개자르기   정렬              출력
            stream.distinct().limit(5).sorted().forEach(System.out::println)
                      중간      중간      중간                최종
            String[] strArr = {"dd", "aaa", "CC", "cc", "b"};
            Stream<String> stream = Stream.of(strArr);// 문자열 배열이 소스인 스트림
            Stream<String> filteredStream = stream.filter(); // 걸러내기 (중간연산)
            Stream<String> distinctedStream = stream.distinct(); // 중복제거 (중간 연산)
            Stream<String> sortedStream = stream.sorted(); // 정렬(중간연산)
            Stream<String> limitedStream = stream.limit(5);
            long total = stream.count(); // 요소 개수 세기(최종연산)

        */

        /*
        3. 최종 연산
            - 연산결과가 스트림이 아닌 연산. 단 한번만 적용가능(스트림의 요소를 소모)
            - 종류 :
                1. 요소의 출력 : forEach()
                2. 요소의 소모 : reduce()
                3. 요소의 검색 : findFirst(), findAny()
                4. 요소의 검사 : anyMatch(), allMatch(), noneMatch()
                5. 요소의 통계 : count(), min(), max()
                6. 요소의 연산 : sum(), average()
                7. 요소의 수집 : collect()
        */


//            스트림의 특징(1/3)
//            1. 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않는다.
            List<Integer> list01 = Arrays.asList(3,1,5,4,2);
            List<Integer> sortedList = list.stream().sorted() // list를 정렬해서
                    .collect(Collectors.toList()); //새
            System.out.println(list01);
            System.out.println(sortedList);

//            2. 스트림은 Iterator처럼 일회용이다.(필요하면 다시 스트림을 생성해야함)
//            strStream.forEach(System.out::println); // 모든 요소를 화면에 출력(최종연산);
//            int numOfStr = strStream.count(); //에러. 스트림이 이미 닫혀있음.
//
//            3. 최종 연산 전까지 중간연산이 수행되지 않는다. -지연된 연산
//            IntStream intStream = new Random().ints(1, 46);
//            intStream.distinct().limit(6).sorted().forEach(i->System.out.print(i+","));
//
//            4. 스트림은 작업을 내부 반복으로 처리한다.
//            for(String str : strList) System.out.println(str);
//                            ↓↓↓↓↓↓↓↓↓
//            stream.forEach(System.out::println); //성능은 비효율적이지만? 코드가 간결해진다.
//                            ↓↓↓↓↓↓↓↓↓
//            void forEach(Consumer<? super T> action)
//            {
//                Objects.requireNonNull(action);//매개변수의 널 체크
//
//                for(T t: src)   // 내부 반복(for문을 메서드 안으로 넣음)
//                    action.accept(T);
//            }
//
//
//            5. 스트림의 작업을 병렬로 처리 - 병렬 스트림
//                Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
//                int sum = strStream.parallel() // 병렬 스트림으로 전환(속성만 변경) => 즉 parallel메소드는 병렬 스트림으로 변환하는 메소드.
//                            .mapToInt(s -> s.length()).sum();
//            6. 기본형 스트림 - IntStream, LongStream, DoubleStream
//            - 오토박싱&언박싱의 비효율이 제거됨(Stream<Integer> 대신 IntStream사용)
//            - 숫자와 관련된 유용한 메서드를 Stream<T>보다 더 많이 제공

    }
}
