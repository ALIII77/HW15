package Q2test;

import Q5.Convert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


public class ConvertTest {

    @Test
    public void LeggalArgument(){
        String s1 ="125";
        String s2 ="12 5";
        String s3 ="12r";
        String s4 ="32769";
        String s5 ="-32769";
        String s6 ="-";
        Assertions.assertEquals(125,Convert.convert(s1));
        Assertions.assertThrows(IllegalArgumentException.class,()-> Convert.convert(s2));
        Assertions.assertThrows(IllegalArgumentException.class,()-> Convert.convert(s3));
        Assertions.assertThrows(IllegalArgumentException.class,()-> Convert.convert(s4));
        Assertions.assertThrows(IllegalArgumentException.class,()-> Convert.convert(s5));
        Assertions.assertThrows(IllegalArgumentException.class,()-> Convert.convert(s6));

    }

}
