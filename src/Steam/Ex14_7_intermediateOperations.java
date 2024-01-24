package Steam;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_7_intermediateOperations
{
    /*
        Stream<T> skip(long n)                              // 앞에서 부터 n개 건너뛰기
        Stream<T> limit(long maxSize)                       // maxSize 이후의 요소는 잘라냄 = maxSize갯수 만큼 출력
            ex)
            IntStream.rangeClosed(1, 10).skip(3).limit(5).forEach(System.out::println);
            4, 5, 6, 7, 8

        Stream<T> filter(Predicate<? super T> predicate)    // 조건에 맞지않는 요소 제거 = 조건에 true인놈들만 추출
        Stream<T> distinct()                                // 중복제거

        Stream<T> sorted()                                  // 스트림 요소의 기본 정렬(Comparable)로 정렬
        Stream<T> sorted(Comparator<? super T> comparator)  // 지정된 Comparator로 정렬

            # Comparator의 comparing()으로 정렬 기준을 제공
                comparing(Function<T, U> keyExtractor)
                comparing(Function<T, U> keyExtractor, Comparator<U> keyComparator)

            ex) studentStream.sorted(Comparator.comparing (Student::getBan)).forEach(System.out::println); // 반별로 정렬

            # 추가 정렬 기준을 제공할 때는 thenComparing()을 사용
                thenComparing(Comparator<T> other)
                thenComparing(Fucntion<T, U> keyExtractor)
                thenComparing(Function<T, U> keyExtractor, Comparator<U> keyComp)

            ex) studentStream.sorted(Comparator.comparing(Student::getBan)      // 반별로 정렬
                            .thenComparing(Student::getTotalScore)              // 총점별로 정렬
                            .thenComparing(Student::getName))                   // 이름별로 정렬
                            .forEach(System.out::println)


    */
    public static void main(String[] args)
    {
        IntStream intStream = IntStream.rangeClosed(1, 10); // rangeClosed는 x, y 범위 값중 끝의 value를 포함시키는 메소드 = 즉 : 1부터 10까지
        intStream.skip(3).limit(5).forEach(System.out::print);
        System.out.println();

        IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
        intStream2.distinct().forEach(System.out::print);
        System.out.println();

        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i -> i % 2 == 0).forEach(System.out::print);
        System.out.println("냥냥펀치");
        System.out.println();

        IntStream intStream4 = IntStream.rangeClosed(1, 10);
        intStream4.filter(i -> i % 2 != 0 && i % 3 != 0).forEach(System.out::print);
        System.out.println();

        IntStream intStream5 = IntStream.rangeClosed(1, 10);
        intStream5.filter(i -> i % 2 != 0).filter(i -> i % 3 != 0).forEach(System.out::print);
        System.out.println();

        Stream<Student> studentStream = Stream.of(
                new Student("김정한", 1, 290),
                new Student("김재호", 1, 230),
                new Student("이재완", 1, 300),
                new Student("오성택", 4, 300),
                new Student("김희민", 4, 190),
                new Student("홍성주", 2, 290),
                new Student("김성민", 2, 111),
                new Student("김도균", 3, 215),
                new Student("김민준", 3, 50),
                new Student("권기훈", 2, 140)
        );

//        studentStream.sorted(Comparator.comparing(Student::getBan) //1. 반별 정렬
        studentStream.sorted(Comparator.comparing((Student s) -> s.getBan()) //1. 반별 정렬
                        .reversed() // 1. 4반부터 ~ 1반까지
                        .thenComparing(Comparator.naturalOrder())) // 2. 기본 정렬 (Student 클래스 내에 compareTo메소드)
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student>
{
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore)
    {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString()
    {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName()
    {
        return name;
    }

    public int getBan()
    {
        return ban;
    }

    public int getTotalScore()
    {
        return totalScore;
    }

    //총점 내림차순을 기본 정렬로 한다.
    @Override
    public int compareTo(Student o)
    {
        return o.totalScore - this.totalScore;
    }
}
