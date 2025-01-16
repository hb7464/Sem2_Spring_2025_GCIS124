public class FirstClasTest {
    @Test
    public void test(){

        double num1 = 2.0;
        int num2 = 6;
        double expect = 4.0;

        double actual = Main.calculate(num1,num2);

        assertEquals(expect,actual);
    }
}