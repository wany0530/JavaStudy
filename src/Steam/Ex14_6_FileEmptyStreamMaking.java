package Steam;

import java.util.stream.Stream;

public class Ex14_6_FileEmptyStreamMaking
{
    public static void main(String[] args)
    {
        /*
            # 파일을 소스로 하는 스트림 생성하기
        Stream<Path> Files.list(Path dir)       //Path는 파일 또는 디렉토리
        Stream<String> Files.lines(Path path)   //파일 내용을 라인 단위로 읽어서 StringStream으로 만들어줌
        Stream<String> Files.lines(Path path, Charset cs)
        Stream<String> lines()      // BufferedReader클래스의 메서드. BufferdReader은 텍스트파일 읽을때 편리한 클래스

            # 비어있는 스트림 생성하기
        Stream emptyStream = Stream.empty();    // empty()는 빈 스트림을 생성해서 반환한다.
        long count = emptyStream.count();       // count의 값은 0

        */
        Stream emptyStream = Stream.empty();    // empty()는 빈 스트림을 생성해서 반환한다.
        long count = emptyStream.count();       // count의 값은 0
    }
}
