package com.company;

import java.math.BigInteger;

public class Reciver {

    private final BigInteger p = Util.randomPrimeBigInteger();
    private final BigInteger q = Util.randomPrimeBigInteger();
    //(p-1)*(q-1)
    private final BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

    private final BigInteger n = p.multiply(q);
    private final BigInteger e = Util.randomCoprime(phi);

    private final BigInteger d = e.modInverse(phi);


    Reciver(){
        System.out.printf("Números privados criados! \np: %s\nq: %s\nd: %s\n", p.toString(), q.toString(), d.toString());
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }


    public BigInteger encode(BigInteger m){
        return m.modPow(e, n);
    }

    public BigInteger decode(BigInteger c){
        return c.modPow(d, n);
    }

}
