package iterator;

import java.util.*;

public class Ex11_0
{
    /*
        Iterator, ListIterator, Enumeration
        # 컬렉션에 저장된 데이터를 접근하는데 사용되는 인터페이스
            ※ 메소드
              boolean hasNext() : 읽어 올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환 // 즉 확인용
              Object next() : 다음요소를 읽어온다. next()를 호출하기 전에 hasNext()를 호출해서 // 즉 읽기
                                읽어 올 요소가 있는지 확인하는 것이 안전하다.
              void remove() : next()로 읽어 온 요소를 삭제한다. next() 호출한 다음에 remove()를 호출해야한다.
            Enumeration은 Iterator의 구 version 이다.
            ListIterator는 next()-[단방향]와 previous()-[양방향]이 존재한다.

        # Iterator를 쓰는이유. 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 것.
          컬렉션에서 iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
          ex)
            List list = new ArrayList();
            Iterator it = list.iterator();

            while(it.hasNaext())
            {
                System.out.println(it.next());
            }

         # Iterator도 Stream과 마찬가지로 1회용이라 최종연산처럼 한번 사용하면 다시 생성해야한다.
     */
    public static void main(String[] args)
    {
        List list = new ArrayList();
        for(int i = 1; i<=5; i++)
        {
            list.add(i);
        }

        Iterator it = list.iterator();
        while(it.hasNext())
        {
            Object obj = it.next();
            System.out.println(obj);
        }
        System.out.println();


        /**
         * 여기서 만약 list를 HashSet으로 변경했을때는 밑의 코드가 낭비가된다.
         * 고로 Iterator를 사용하면 Collection에서 다 호환이 되기때문에
         * Iterator를 사용한다.
         */
        for(int i=0; i<list.size(); i++)
        {
            Object obj = list.get(i);
            System.out.println(obj);
        }
    }
}
