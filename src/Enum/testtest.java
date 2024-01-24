package Enum;

import java.util.Arrays;

/**
 * @author : ljw6398@nets.co.kr
 * @TeskContents :
 */
public class testtest
{
    public static void main(String[] args)
    {
        System.out.println(EpNGEnum.checkGradeCode("POS"));
    }

    enum EpNGEnum
    {
        POS,TIT,WOR,BRA,JOB,LCL,CRP;

        private static boolean checkGradeCode(String label)
        {
            EpNGEnum e = Arrays.stream(values())
                    .filter(value -> value.name().equals(label))
                    .findAny()
                    .orElse(null);

            return e == null ? false : true;
        }
    }
}
