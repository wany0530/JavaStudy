package Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class LambdaPractice
{
    public static void main(String[] args)
    {
        String[] strArr = {"aaa", "bb", "c", "dddd"};
        int a = Arrays.stream(strArr).mapToInt(String::length).sum();
    }
}
/*
1번문제 : (a, b) -> a > b ? a : b;
2번문제 : (String name, int i) -> System.out.println(name + "=" + i);
3번문제 : x -> x*x
4번문제 : () -> (int)(Math.random() * 6);
5번문제 : String :: length
*/