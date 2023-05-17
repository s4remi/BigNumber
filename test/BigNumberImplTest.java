import bignumber.BigNumber;
import bignumber.BigNumberImpl;

import java.math.BigInteger;
import java.util.Random;
import bignumber.BigNumber;
import bignumber.BigNumberImpl;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

public class BigNumberImplTest {
    BigNumberImpl bigNumb=new BigNumberImpl("1678");
    String ali= "1678";
    public void setup() {
        BigNumberImpl bigNumb=new BigNumberImpl("1678");
        //BigNumberImpl b1=new BigNumberImpl("1234");
    }

//    @org.junit.Test
//    public void length() {
//        setup();
//        int val=bigNumb.length();
//        assertEquals(4,val);
//    }

//    @org.junit.Test
//    public void shiftLeft() {
//        setup();
//        bigNumb.shiftLeft(1);
//        assertEquals("16780",bigNumb.toString());
//    }

//    @org.junit.Test
//    public void shiftRight() {
//        setup();
//        bigNumb.shiftRight(1);
//        assertEquals("167",bigNumb.toString());
//    }
//
//    @org.junit.Test
//    public void addDigit() {
//        setup();
//        bigNumb.addDigit(0);
//        assertEquals("1678",bigNumb.toString());
//    }
//
//    @org.junit.Test
//    public void getDigitAt() {
//        setup();
//        assertEquals(7,bigNumb.getDigitAt(1));
//    }
//
//    @org.junit.Test
//    public void copy() {
//        setup();
//        assertEquals("1678",bigNumb.copy().toString());
//    }
//
//    @org.junit.Test
//    public void add() {
//        BigNumberImpl b1=new BigNumberImpl("1000");
//        BigNumberImpl b2= new BigNumberImpl("0");
//        BigNumberImpl b3= (BigNumberImpl) b1.add(b2);
//        assertEquals("1000",b3.toString());
//    }
//
//    @org.junit.Test
//    public void addNode() {
//    }
//
//    @org.junit.Test
//    public void makeString() {
//    }
//
//    @org.junit.Test
//    public void testToString() {
//    }
//
//    @org.junit.Test
//    public void reverse() {
//        BigNumberImpl b1=new BigNumberImpl("1234");
//        assertEquals("1234",b1.toString());
//    }
//
//    @org.junit.Test
//    public void getHead() {
//    }
//
//    @org.junit.Test
//    public void main() {
//    }
//    @org.junit.Test
//    public void compareTo(){
//        BigNumberImpl ali=new BigNumberImpl("8761");
//        BigNumberImpl b3=new BigNumberImpl("1678");
//        int val=ali.compareTo(b3);
//        assertEquals(1,val);
//    }
    /** Testing. */
    @Test(timeout = 1000)
   // @TestWeight(weight = 1)
    public void testInvalidCreationByString() {
        String[] inputs = { "1234543a", "a123432", "1332 324", "-12345" };

        for (String s : inputs) {
            try {
                new BigNumberImpl(s);
                fail("Should have failed to create number " + s + " but did not.");
            } catch (IllegalArgumentException e) {
                // should continue;
            }
        }
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1.5)
    public void testLength() {
        Random r = new Random(200);
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            int digit = Math.abs(r.nextInt()) % 10;
            if ((i == 0) && (digit == 0)) {
                digit = Math.abs(r.nextInt()) % 9 + 1;
            }
            if ((expected.toString().length() != 0) || (digit != 0)) {
                expected.append(digit);
            }
            BigNumber number = new BigNumberImpl(expected.toString());
            assertEquals("Length of number is not correct", (i + 1), number.length());
        }
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1.5)
    public void testNumberCreationByShiftingAndAdding() {
        Random r = new Random(200);
        for (int trial = 0; trial < 50; trial++) {
            BigNumber number = new BigNumberImpl();
            int ai=number.length();
            StringBuilder expected = new StringBuilder();
            for (int i = 0; i < 500; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }
                number.shiftLeft(1);
                number.addDigit(digit);
            }
            assertEquals(expected.toString(), number.toString());
        }
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1.5)
    public void testNumberCreationByString() {
        Random r = new Random(200);
        for (int trial = 0; trial < 50; trial++) {
            StringBuilder expected = new StringBuilder();
            for (int i = 0; i < 500; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }
            }
            BigNumber number = new BigNumberImpl(expected.toString());

            assertEquals(expected.toString(), number.toString());
        }
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1.5)
    public void testRightShifting() {
        Random r = new Random(100);
        BigNumber number = new BigNumberImpl();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            int digit = Math.abs(r.nextInt()) % 10;
            if ((i == 0) && (digit == 0)) {
                digit = Math.abs(r.nextInt()) % 9 + 1;
            }
            if ((expected.toString().length() != 0) || (digit != 0)) {
                expected.append(digit);
            }
            number.shiftLeft(1);
            number.addDigit(digit);
            // assertEquals(expected.toString(),number.toString());
        }

        String expectedString = expected.toString();
        for (int i = 1; i < 1000; i++) {
            number.shiftRight(1);
            expectedString = expectedString.substring(0, expectedString.length() - 1);
            assertEquals(expectedString, number.toString());
        }

        for (int i = 0; i < 10; i++) {
            number.shiftRight(1);
            assertEquals("0", number.toString());
        }
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1.5)
    public void testGetDigitAt() {
        Random r = new Random(200);
        BigNumber number = new BigNumberImpl();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            int digit = Math.abs(r.nextInt()) % 10;
            if ((i == 0) && (digit == 0)) {
                digit = Math.abs(r.nextInt()) % 9 + 1;
            }
            if ((expected.toString().length() != 0) || (digit != 0)) {
                expected.append(digit);
            }
            number.shiftLeft(1);
            number.addDigit(digit);
            assertEquals(expected.toString(), number.toString());
        }

        for (int i = 0; i < 500; i++) {
            assertEquals("" + expected.charAt(expected.toString().length() - 1 - i),
                    "" + number.getDigitAt(i));

            try {
                number.getDigitAt(-(i + 1));
                fail("getDigitAt should have failed for position " + (-(i + 1)) + " but " + "does not.");
            } catch (IllegalArgumentException e) {
                // should continue;
            }
        }

        try {
            // test a digit that is beyond the length of the number
            number.getDigitAt(10000);
            fail("getDigit for a position greater than length does not work");
        } catch (IllegalArgumentException e) {
            // should continue
        }
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1.5)
    public void testShifts() {
        Random r = new Random(200);
        BigNumber number = new BigNumberImpl();
        StringBuilder expected = new StringBuilder();
        number.addDigit(3);
        expected.append("3");
        for (int i = 0; i < 500; i++) {
            int numShifts = r.nextInt(10);
            for (int j = 0; j < numShifts; j++) {
                expected.append("0");
            }
            number.shiftLeft(numShifts);
            assertEquals("Left shifting by " + numShifts + " does not work.", expected.toString(),
                    number.toString());
            int digit = Math.abs(r.nextInt()) % 10;
            if ((i == 0) && (digit == 0)) {
                digit = Math.abs(r.nextInt()) % 9 + 1;
            }
            if ((expected.toString().length() != 0) || (digit != 0)) {
                expected.append(digit);
            }
            number.shiftLeft(1);
            number.addDigit(digit);
            assertEquals(expected.toString(), number.toString());
        }
        String currentString = expected.toString();

        while (currentString.length() > 0) {
            int numShifts;
            if (currentString.length() < 5) {
                numShifts = currentString.length();
            } else {
                numShifts = r.nextInt(currentString.length());
            }
            currentString = currentString.substring(0, currentString.length() - numShifts);

            number.shiftRight(numShifts);
            if (currentString.length() > 0) {
                assertEquals("Right shifting by " + numShifts + " does not work.", currentString,
                        number.toString());
            } else {
                assertEquals("Right shifting by " + numShifts + " does not work.", "0", number.toString());
            }

        }
    }

    /** Testing. */
    @Test(timeout = 1000)
    //@TestWeight(weight = 1)
    public void testShiftsOnZero() {
        BigNumber number = new BigNumberImpl();
        for (int i = 0; i < 100; i++) {
            number.shiftLeft((i + 1));
            assertEquals("Left shift does not work", "0", number.toString());

        }

        for (int i = 0; i < 100; i++) {
            number.shiftRight((i + 1));
            assertEquals("Right shift does not work", "0", number.toString());

        }

        number = new BigNumberImpl("1234567890");
        number.shiftRight(10);
        assertEquals("Right shift does not work", "0", number.toString());

        number = new BigNumberImpl("0").add(new BigNumberImpl("0"));
        assertEquals("Right shift does not work", "0", number.toString());
    }

    /** Testing. */
    @Test(timeout = 1000)
    //@TestWeight(weight = 1)
    public void testAddDigit() {
        BigNumber number = new BigNumberImpl();
        Random r = new Random(100);
        for (int i = 0; i < 10000; i++) {
            int num = r.nextInt(10);
            try {
                number.addDigit(num + 10);
                fail("Should have failed to add digit " + (num + 10) + " but did not.");
            } catch (IllegalArgumentException e) {
                // should continue;
            }

            try {
                number.addDigit(-(num + 1));
                fail("Should have failed to add digit " + (-num) + " but did not.");
            } catch (IllegalArgumentException e) {
                // should continue;
            }
        }
        try {
            number.addDigit(10);
            fail("Should have failed to add digit 10 but did not.");
        } catch (IllegalArgumentException e) {
            // should continue;
        }
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1)
    public void testAddNumbers() {
        Random r = new Random(200);
        BigNumber num1;
        BigNumber num2;
        BigNumber result;

        BigInteger n1;
        BigInteger n2;
        BigInteger expectedResult;

        for (int trial = 0; trial < 20; trial++) {

            StringBuilder expected = new StringBuilder();
            int l = r.nextInt(500);
            for (int i = 0; i < l; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }

                // assertEquals(expected.toString(),number.toString());
            }
            num1 = new BigNumberImpl(expected.toString());
            if (expected.toString().length() > 0) {
                n1 = new BigInteger(expected.toString());
            } else {
                n1 = new BigInteger("0");
            }
            expected = new StringBuilder();
            l = r.nextInt(5000);
            for (int i = 0; i < l; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }

                // assertEquals(expected.toString(),number.toString());
            }
            num2 = new BigNumberImpl(expected.toString());
            if (expected.toString().length() > 0) {
                n2 = new BigInteger(expected.toString());
            } else {
                n2 = new BigInteger("0");
            }

            result = num1.add(num2);
            expectedResult = n1.add(n2);

            assertEquals(
                    "Adding the numbers " + n1.toString() + " and " + n2.toString()
                            + " did not produce the correct result",
                    expectedResult.toString(), result.toString());

            assertEquals("Adding 0 to a number does not produce the number itself",
                    num1.add(new BigNumberImpl("0")).toString(), num1.toString());

        }

        // trying the case where there is an overflow carry
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            string.append("9");
        }
        num1 = new BigNumberImpl(string.toString());
        num2 = new BigNumberImpl(string.toString());
        result = num1.add(num2);

        n1 = new BigInteger(string.toString());
        n2 = new BigInteger(string.toString());
        expectedResult = n1.add(n2);

        assertEquals("Adding the numbers " + n1.toString() + " and " + n2.toString()
                + " did not produce the correct result", expectedResult.toString(), result.toString());
    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1)
    public void testCompareTo() {
        Random r = new Random(200);
        BigNumber num1;
        BigNumber num2;

        BigInteger n1;
        BigInteger n2;

        for (int trial = 0; trial < 100; trial++) {

            StringBuilder expected = new StringBuilder();
            int l = r.nextInt(1000) + 1;
            for (int i = 0; i < l; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }

                // assertEquals(expected.toString(),number.toString());
            }
            // System.out.println("String is "+expected.toString());
            num1 = new BigNumberImpl(expected.toString());
            if (expected.toString().length() > 0) {
                n1 = new BigInteger(expected.toString());
            } else {
                n1 = new BigInteger("0");
            }
            expected = new StringBuilder();
            l = r.nextInt(1000) + 1;
            for (int i = 0; i < l; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }

                // assertEquals(expected.toString(),number.toString());
            }
            num2 = new BigNumberImpl(expected.toString());
            if (expected.toString().length() > 0) {
                n2 = new BigInteger(expected.toString());
            } else {
                n2 = new BigInteger("0");
            }

            int r1 = n1.compareTo(n2);
            int r2 = num1.compareTo(num2);
            if (r1 == 0) {
                assertTrue("Comparison does not work correctly", r2 == 0);
            } else {
                if (r1 * r2 <= 0) {
                    r2 = num1.compareTo(num2);
                }
                assertTrue("Comparison does not work correctly for " + num1.toString() + " and \n"
                        + num2.toString(), r1 * r2 > 0);
            }

            assertEquals("Comparison does not work correctly", 0, num1.compareTo(num1));

            assertEquals("Comparison does not work correctly", 0, num2.compareTo(num2));

        }

        // same length numbers
        for (int trial = 0; trial < 100; trial++) {

            StringBuilder expected = new StringBuilder();
            int l = r.nextInt(1000) + 1;
            for (int i = 0; i < l; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }

                // assertEquals(expected.toString(),number.toString());
            }
            num1 = new BigNumberImpl(expected.toString());
            if (expected.toString().length() > 0) {
                n1 = new BigInteger(expected.toString());
            } else {
                n1 = new BigInteger("0");
            }
            expected = new StringBuilder();
            for (int i = 0; i < l; i++) {
                int digit = Math.abs(r.nextInt()) % 10;
                if ((i == 0) && (digit == 0)) {
                    digit = Math.abs(r.nextInt()) % 9 + 1;
                }
                if ((expected.toString().length() != 0) || (digit != 0)) {
                    expected.append(digit);
                }

                // assertEquals(expected.toString(),number.toString());
            }
            num2 = new BigNumberImpl(expected.toString());
            if (expected.toString().length() > 0) {
                n2 = new BigInteger(expected.toString());
            } else {
                n2 = new BigInteger("0");
            }

            int r1 = n1.compareTo(n2);
            int r2 = num1.compareTo(num2);
            if (r1 == 0) {
                assertTrue("Comparison does not work correctly", r2 == 0);
            } else {
                assertTrue("Comparison does not work correctly", r1 * r2 > 0);
            }
        }

    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1)
    public void testCopy() {
        Random r = new Random(200);
        BigNumber number = new BigNumberImpl();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            int digit = Math.abs(r.nextInt()) % 10;
            if ((i == 0) && (digit == 0)) {
                digit = Math.abs(r.nextInt()) % 9 + 1;
            }
            if ((expected.toString().length() != 0) || (digit != 0)) {
                expected.append(digit);
            }
            number.shiftLeft(1);
            number.addDigit(digit);
            // assertEquals(expected.toString(),number.toString());
        }

        for (int i = 0; i < 500; i++) {
            assertEquals("getDigitAt does not return the correct digit",
                    "" + expected.charAt(expected.toString().length() - 1 - i), "" + number.getDigitAt(i));
        }
        // create a copy
        BigNumber copy = number.copy();
        for (int i = 0; i < 500; i++) {
            assertEquals("Copy is not identical",
                    "" + expected.charAt(expected.toString().length() - 1 - i), "" + copy.getDigitAt(i));
        }

        copy.shiftRight(100);

        for (int i = 0; i < 500; i++) {
            assertEquals("Copy is not independent",
                    "" + expected.charAt(expected.toString().length() - 1 - i), "" + number.getDigitAt(i));
        }

    }

    /** Testing. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 1.5)
    public void testNegativeShifts() {
        Random r = new Random(200);
        BigNumber number = new BigNumberImpl();
        StringBuilder expected = new StringBuilder();
        number.addDigit(3);
        expected.append("3");
        for (int i = 0; i < 500; i++) {
            int numShifts = r.nextInt(10);
            for (int j = 0; j < numShifts; j++) {
                expected.append("0");
            }
            number.shiftRight(-numShifts);
            assertEquals("Right shifting by " + (-numShifts) + " does not work.", expected.toString(),
                    number.toString());
            int digit = Math.abs(r.nextInt()) % 10;
            if ((i == 0) && (digit == 0)) {
                digit = Math.abs(r.nextInt()) % 9 + 1;
            }
            if ((expected.toString().length() != 0) || (digit != 0)) {
                expected.append(digit);
            }
            number.shiftRight(-1);
            number.addDigit(digit);
            assertEquals(expected.toString(), number.toString());
        }
        String currentString = expected.toString();

        while (currentString.length() > 0) {
            int numShifts;
            if (currentString.length() < 5) {
                numShifts = currentString.length();
            } else {
                numShifts = r.nextInt(currentString.length());
            }
            currentString = currentString.substring(0, currentString.length() - numShifts);

            number.shiftLeft(-numShifts);
            if (currentString.length() > 0) {
                assertEquals("Left shifting by " + (-numShifts) + " does not work.", currentString,
                        number.toString());
            } else {
                assertEquals("Left shifting by " + (-numShifts) + " does not work.", "0",
                        number.toString());
            }

        }

    }


}


/*


    public static void main(String[] args) {
        BigNumber bigNumber;
        //bigNumber= new bignumber.BigNumberImpl('7');
//        System.out.println(bigNumber.length());
//        System.out.println(bigNumber.toString());
//        System.out.println("---------");
        String ali= "1678";
//        System.out.println("string size is "+ali.length());//4
//        System.out.println("*******");
        BigNumber ali1= new BigNumberImpl(ali);
//        System.out.println("list size is "+ali1.length());
        System.out.println(ali1.toString());//3

        System.out.println("checking the add function");
        ali1.addDigit(7);
        System.out.println("test");
        System.out.println(ali1.toString());
        BigNumber newnum= new BigNumberImpl("2034");
        int hello=newnum.getDigitAt(2);
        System.out.println("test here"+hello);
        BigNumber cc= newnum.copy();
        System.out.println("+999999999999999");

        System.out.println(cc.toString());
        System.out.println("--------");

        System.out.println(newnum.getHead());
        System.out.println(cc.getHead());


        //System.out.println(ali1.getDigitAt(2));

        //ali1.addDigit(2);
        System.out.println("heeeereeee "+ali1.toString());
        //ali1.add(cc);
        //ali1 = 2007

        System.out.println("\n"+ali1.add(cc));
        //System.out.println(ali1.toString());


    }
}
 */