package Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Ex11_0
{
    public static void main(String[] args)
    {
        Integer abc = 5;
        System.out.println(abc);
        System.out.println(abc.intValue());

        /*
        Comparator a = new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2) // o1, o2 두 객체를 비교 후 정수값으로 출력
            {
                return 0;
            }
        }

        Comparator는 인터페이스로서
        기본 정렬기준 외에 다른 기준으로 정렬하고자할 떄 사용
        위와같이 compare이라는 메소드를 가지고 있고
        결과값으로는
        양수 : 왼쪽이 크다
        0 : 같다
        음수 : 오른쪽이 크다
        */

        /*
        Comparable a = new Comparable()
        {
            @Override
            public int compareTo(Object o)
            {
                return 0;
            }
        }

        Comparable도 인터페이스로서
        기본 정렬기준을 구현하는데 사용한다.
        위와 같이 CompareTo는 매개변수가 한개로서 [주어진 객체(o)를 자기 자신(this)과 비교] 하는 메소드

        즉 compare은 o1과 o2를 비교
        compareTo는 o와 자기자신을 비교

        정렬 sort()는 자리바꿈이다.
        순서는 1. 두 대상비교 0 -> 2. 자리바꿈 이다
        */

        String[] strArr = {"cat", "Dog", "lion", "tiger"};
        Arrays.sort(strArr);    // String의 Comparable구현에 의한 정렬
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분안함
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("strArr=" + Arrays.toString(strArr));
    }
}

class Descending implements Comparator
{

    @Override
    public int compare(Object o1, Object o2)
    {
        if(o1 instanceof Comparable && o2 instanceof Comparable)
        {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1; // -1을 곱해서 기본 정렬방식의 역으로 변경한다.
            //또는 c2.compareTo와 같이 순서를 바꿔도 된다.
        }
        return -1;
    }
}
