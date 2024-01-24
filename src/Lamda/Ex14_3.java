package Lamda;

import java.util.function.Predicate;

public class Ex14_3
{
    public static void main(String[] args)
    {
        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;

        Predicate<Integer> notP = p.negate(); // i >= 100
        Predicate<Integer> all = notP.and(q).or(r); // i >= 100 && i < 200 || i % 2 == 0
        Predicate<Integer> all2 = notP.and(q.or(r)); // i >= 100 && (i < 200 || i % 2 ==0)
        
        System.out.println(all.test(199)); // true
        System.out.println(all.test(51)); // false
        System.out.println(all.test(50)); // true
        System.out.println(all2.test(2)); // false
        System.out.println(all2.test(122)); // true


        // 등가 비교(== 또는 !=)를 위한 Predicate의 작성에는 isEqual()를 사용(static 메서드)
        String str1 = "hi";
        String str2 = "hi";
        /*
        Predicate<String> pp = Predicate.isEqual(str1);
        Boolean result = pp.test(str2);
        밑과 같음
        */
        Boolean result = Predicate.isEqual(str1).test(str2);
        System.out.println(result);
    }
}
