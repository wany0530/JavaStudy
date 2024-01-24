package Lamda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Ex14_3_main
{
    public static void main(String[] args)
    {
        Function<String, Integer> f = s -> Integer.parseInt(s, 16); // 입력을 String 출력을 Integer
        Function<Integer, String> g = i -> Integer.toBinaryString(i);
        // andThen 함수는 f함수와 g 함수를 합치는것 => f를 적용하고나서 g를 적용해라.
        // f를 보면 입력이 String / 출력이 Integer인데 g함수가 입력이 integer / 출력이 String
        // 그래서 h함수가 <String, String>이다.
        Function<String, String> h = f.andThen(g);

        Function<Integer, Integer> h2 = f.compose(g); // g.andthen(f) 와 똑같다.

        System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2)); // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x; // 항등함수(identity function)
        System.out.println(f2.apply("AAA")); // AAA가 그대로 출력됨

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();

        Predicate<Integer> all = notP.and(q.or(r)); // i >= 100 && (i < 200 ||
        System.out.println(all.test(150));

        String str1 = new String("abc");
        String str2 = new String("abc");

        // str1과 str2가 같은지 비교한 결과를 반환
        /*
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        */
        boolean result = Predicate.<String>isEqual(str1).test(str2);
        System.out.println(result);
    }
}
