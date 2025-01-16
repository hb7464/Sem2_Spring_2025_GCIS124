import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstClasTest {

    @Test
    public void test2(){

        String s1 = "ABC";
        String rs1 = "CBA";

        String actual = Main.reversestring(s1);

        assertEquals(rs1, actual);
    }
    public void test3(){

        double num1 = 4.0;
        int num2 = 12;
        double expect = 12;

        double actual = Main.calculate(num1,num2);

        assertEquals(expect,actual,0.001);
    }
}