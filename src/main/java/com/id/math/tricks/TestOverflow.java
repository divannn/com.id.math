package com.id.math.tricks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOverflow {

    /**
     * Safely adds wo integers by throwing exception if overflow occurs
     *
     * @throws ArithmeticException if addinf causes overflow
     */
    public int safeAdd(int l, int r) {
        int result = l + r;
        if (l > 0 && r > 0 && result < 0) {
            throw new ArithmeticException("Integer overflow");
        }
        if (l < 0 && r < 0 && result > 0) {
            throw new ArithmeticException("Integer overflow");
        }
        return result;
    }

    public int safeSub(int l, int r) {
        int result = l - r;
        if (l > 0 && r < 0 && result < 0) {
            throw new ArithmeticException("Integer overflow");
        }
        if (l < 0 && r > 0 && result > 0) {
            throw new ArithmeticException("Integer sub overflow");
        }
        return result;
    }

    @Test
    public void testAddOk() {
        assertEquals(1, safeAdd(0, 1));
        assertEquals(11, safeAdd(10, 1));
        assertEquals(-1, safeAdd(0, -1));
        assertEquals(-11, safeAdd(-10, -1));

        assertEquals(Integer.MAX_VALUE, safeAdd(Integer.MAX_VALUE, 0));
        assertEquals(-Integer.MAX_VALUE, safeAdd(-Integer.MAX_VALUE, 0));

        assertEquals(0, safeAdd(Integer.MAX_VALUE, -Integer.MAX_VALUE));
        assertEquals(-1, safeAdd(Integer.MAX_VALUE, -Integer.MIN_VALUE));
    }

    @Test(expected = ArithmeticException.class)
    public void testAddFail1() {
        safeAdd(Integer.MAX_VALUE, 1);
    }

    @Test(expected = ArithmeticException.class)
    public void testAddFail2() {
        safeAdd(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test(expected = ArithmeticException.class)
    public void testAddFail3() {
        safeAdd(Integer.MIN_VALUE, -1);
    }

    @Test(expected = ArithmeticException.class)
    public void testAddFail4() {
        safeAdd(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Test(expected = ArithmeticException.class)
    public void testSubFail1() {
        safeSub(Integer.MAX_VALUE, -1);
    }

    @Test(expected = ArithmeticException.class)
    public void testSubFail2() {
        safeSub(Integer.MAX_VALUE, -Integer.MAX_VALUE);
    }

    @Test(expected = ArithmeticException.class)
    public void testSubFail3() {
        safeSub(Integer.MIN_VALUE, 1);
    }

    @Test(expected = ArithmeticException.class)
    public void testSubFail4() {
        safeSub(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public static void main(String[] args) {
        int r = new TestOverflow().safeAdd(Integer.MIN_VALUE, Integer.MIN_VALUE);
        System.err.println("r" + r);
    }
}
