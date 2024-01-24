package Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2
{
    public static void main(String[] args)
    {
        // Supplier = 입력 X 반환 O
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1; //1부터 100사이의 난수
        // Consumer = 입력 O 반환 X
//        Consumer<Integer> c = i -> System.out.print(i + ", "); // 콘솔에 출력
        Consumer<Integer> c = i -> System.out.print(i + ", "); // 콘솔에 출력
        // Predicate = 조건식이며 입력 O 반환 (Boolean)
        Predicate<Integer> p = i -> i % 2 == 0; // 짝수인지 검사
        // Function = 입력 O 반환 O ::: 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환
        Function<Integer, Integer> f = i -> i / 10 * 10; // i의 일의 자리를 없앤다.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list); // list를 랜덤값으로 채운다
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSometing(f, list);
        System.out.println(newList + "Function");
    }

    static <T> List<T> doSometing(Function<T, T> f, List<T> list)
    {
        List<T> newList = new ArrayList<T>(list.size());

        for (T i : list)
        {
            newList.add(f.apply(i));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list)
    {
        System.out.print("[");
        for (T i : list)
        {
            if (p.test(i)) // 짝수인지 검사
                c.accept(i); // true일때 accept
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list)
    {
        for (int i = 0; i < 10; i++)
        {
            list.add(s.get());
        }
    }

}
