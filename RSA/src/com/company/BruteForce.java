package com.company;

import java.math.BigInteger;

public class BruteForce {
    public static BigInteger sqrtF(BigInteger x){
        // if x==0 or x==1
        if (x.equals(BigInteger.ZERO)
                || x.equals(BigInteger.ONE)) {
            return x;
        }

        BigInteger two
                = BigInteger.valueOf(2L);
        BigInteger y;

        // run a loop
        y = x.divide(two);
        while (y.compareTo(x.divide(y)) > 0)
            y = ((x.divide(y)).add(y))
                    .divide(two);
        return y;
    }
    public static BigInteger sqrtC(BigInteger x){
        BigInteger y = sqrtF(x);

        if (x.compareTo(y.multiply(y)) == 0) {
            return y;
        }
        else {
            return y.add(BigInteger.ONE);
        }
    }

    static String FermatFactors(BigInteger n){
        // constants
        BigInteger ONE = new BigInteger("1");
        BigInteger ZERO = new BigInteger("0");
        BigInteger TWO = new BigInteger("2");

        // if n%2 ==0 then return the factors
        if (n.mod(TWO).equals(ZERO)) {
            return n.divide(TWO)
                    .toString()
                    + ", 2";
        }

        // find the square root
        BigInteger a = sqrtC(n);

        // if the number is a perfect square
        if (a.multiply(a).equals(n)) {
            return a.toString()
                    + ", " + a.toString();
        }

        // else perform factorisation
        BigInteger b;
        while (true) {
            BigInteger b1 = a.multiply(a)
                    .subtract(n);
            b = sqrtF(b1);

            if (b.multiply(b).equals(b1))
                break;
            else
                a = a.add(ONE);
        }

        return a.subtract(b).toString()
                + ", " + a.add(b).toString();
    }

}
