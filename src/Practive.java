import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Practive
{
    public static void main(String[] args)
    {
       int  []a = new int[8];
       int i = 0;
       int n = 10;

       while(i < a.length)
       {
           a[i++] = n % 2;
           n /= 2;
       }

       for(i=7; i >= 0; i--)
       {
           System.out.println(a[i]);
       }
    }
}
