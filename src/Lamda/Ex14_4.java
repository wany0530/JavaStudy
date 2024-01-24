package Lamda;

import java.util.*;

public class Ex14_4
{

    public static void main(String[] args)
    {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add(i);
        }

        //list의 모든 요소 출력
        //1번째 방법
        list.forEach(a -> System.out.print(a + ","));
        //2번째 방법
        Iterator it = list.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next());
        }

        //3번째 방법
        for(int a : list)
        {
            System.out.println(a);
        }
        System.out.println();

        // list에서 2또는 3의 배수를 제거한다.
        list.removeIf(x -> x%2 == 0 || x%3 == 0);
        System.out.println(list);

        list.replaceAll(i->i*10); // list의 각 요소에 10을 곱한다.
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        map.replace("1", "1", "7");
        System.out.println(map.get(1) + "냥냥펀치");
        // map의 모든 요소를 {k,v}의 형식으로 출력한다.
        map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}, "));
        System.out.println();

        //2번째 방법
        Iterator it2 = map.entrySet().iterator();
        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }
        System.out.println();
    }
}
