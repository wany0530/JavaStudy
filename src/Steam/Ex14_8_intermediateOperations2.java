package Steam;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ex14_8_intermediateOperations2
{
    /*
        # 스트림의 요소 변환하기 - map()
        Stream<R> map(Function<? super T, ? extends R> mapper) // Stream<T> => Stream<R>

        Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1")
            new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));

        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println); // 스트림의 모든 파일의 이름을 출력

                Stream<File>        map(File::getName)         Stream<String>
                                ------------------------->


        # 스트림의 요소를 소비하지 않고 엿 보기 - peek()
        Stream<T> peek(Consumer<? super T> action)  // 중간 연산(스트림을 소비x)
        void    forEach(Consumer<? super T> action) // 최조 연산(스트림을 소비O)

        FileStream.map(File::getName) // Stream<File> -> Stream<Spring>
            .filter(s -> s.indexOf('.') != 1)
            .peek(s -> System.out.printf("filename.%s%n", s))


        # 스트림의 스트림을 스트림으로 변환 - flatMap()
            Stream<String[]> strArrStm = Stream.of(new String[] {"abc", "def", "ghi"}
                                                 , new String[] {"ABC", "GEI", "JKLMN"});

            Stream<Stream<String>> strStrStrm = strArrStrm.map(Arrays::stream);

            map을 사용하면 이렇게 스트림 안에 스트림(String)이 생겨버리니 조심하자. 우리가 원하는것은 하나씩
            ---------------------스트림---------------------------
            - ----Stream<String>----   -----Stream<String>----- -
            - -                    -   -                      - -
            - - "abc","def","ghi"  -   - "ABC", "GEI", "JKLMN"- -
            - -                    -   -                      - -
            - ----------------------   ------------------------ -
            -----------------------------------------------------

            flatMap()을 사용하면
            Stream<String> strStrStrm = strArrStrm.flatMap(Arrays::stream); // Arrays.stream(T[])

            각 배열의 각각의 요소들을 하나의 스트림에 넣는것.
            ----------------Stream--------------------
            - "abc","def","ghi","ABC"."GEI", "JKLMN" -
            ------------------------------------------
     */
    public static void main(String[] args)
    {
        /**
         * map() 메소드 연습. 즉 파일타입을 변환하는 메소드,
         */
        System.out.println("--------------map() 시작-----------------");
        File[] fileArr = {new File("Ex1.java"),new File("Ex1.bak"),new File("Ex2.java"),new File("Ex1"),new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(fileArr);

        //map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameStream = fileStream.map((f) -> f.getName());
        filenameStream.forEach(System.out::println);

        fileStream = Stream.of(fileArr);
        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1)
                .map(s -> s.substring(s.indexOf('.') + 1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::print);
        System.out.println();
        System.out.println("--------------map() 끝-----------------");

        /**
         * peek 스트림의 요소를 소비하지 않고 엿보는 메소드,
         */
        System.out.println("--------------peek() 시작-----------------");
        File[] fileArr2 = {new File("Ex1.java"),new File("Ex1.bak"),new File("Ex2.java"),new File("Ex1"),new File("Ex1.txt")};
        Stream<File> fileStream2 = Stream.of(fileArr2);

        fileStream2.map(File::getName)
                .filter(s -> s.indexOf('.') != -1)
                .peek(s-> System.out.printf("filename=%s%n", s))
                .map(s -> s.substring(s.indexOf('.') + 1))
                .peek(s-> System.out.printf("extension=%s%n", s))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::print);
        System.out.println("--------------peek() 끝-----------------");

        /**
         * flatMap 스트림의 스트림을 스트림으로 변환.
         */
        System.out.println("--------------flatMap() 시작-----------------");

        Stream<String[]> strArrStrm = Stream.of(
          new String[]{"abc", "def", "ghi"},
          new String[]{"ABC", "GHI", "JKL"}
        );

//        Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // " +" 의 뜻은 하나 이상의 공백을 의미하는 정규식 기호이다. 즉 띄어쓰기가 "  " 두개여도 인식하게끔.
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------------flatMap() 끝-----------------");

    }
}
