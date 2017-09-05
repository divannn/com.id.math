import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PowerOf3 {

    //via multiplication
    public boolean isPowerOfThree1(int n) {
        long r = 1;
        while (r < n) {
            r *= 3;
        }
        return r == n;
    }

    //via division
    public boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //division via recursion.
    public boolean isPowerOfThree3(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0) {
            return isPowerOfThree3(n / 3);
        }
        return false;
    }

    @Test
    public void test1() {
        assertTrue(new PowerOf3().isPowerOfThree1(1));
        assertTrue(new PowerOf3().isPowerOfThree1(3));
        assertTrue(new PowerOf3().isPowerOfThree1(27));
        assertFalse(new PowerOf3().isPowerOfThree1(0));
        assertFalse(new PowerOf3().isPowerOfThree2(2));
        assertFalse(new PowerOf3().isPowerOfThree1(62));
        assertFalse(new PowerOf3().isPowerOfThree1(-3));
    }


    @Test
    public void test2() {
        assertTrue(new PowerOf3().isPowerOfThree2(1));
        assertTrue(new PowerOf3().isPowerOfThree2(3));
        assertTrue(new PowerOf3().isPowerOfThree2(27));
        assertFalse(new PowerOf3().isPowerOfThree2(0));
        assertFalse(new PowerOf3().isPowerOfThree2(2));
        assertFalse(new PowerOf3().isPowerOfThree2(62));
        assertFalse(new PowerOf3().isPowerOfThree2(-3));
    }


    @Test
    public void test3() {
        assertTrue(new PowerOf3().isPowerOfThree3(1));
        assertTrue(new PowerOf3().isPowerOfThree3(3));
        assertTrue(new PowerOf3().isPowerOfThree3(27));
        assertFalse(new PowerOf3().isPowerOfThree3(0));
        assertFalse(new PowerOf3().isPowerOfThree2(2));
        assertFalse(new PowerOf3().isPowerOfThree3(62));
        assertFalse(new PowerOf3().isPowerOfThree3(-3));
    }
}