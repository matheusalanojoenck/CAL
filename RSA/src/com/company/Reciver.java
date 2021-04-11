package com.company;

import java.math.BigInteger;

public class Reciver {

    private final BigInteger p = Util.randomPrimeBigInteger();
    private final BigInteger q = Util.randomPrimeBigInteger();
    //(p-1)*(q-1)
    private final BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

    private final BigInteger n = p.multiply(q);
    private final BigInteger e = Util.randomCoprime(phi);

    //e^-1 % phi
    private final BigInteger d = e.modInverse(phi);


    Reciver(){
        System.out.printf("Números privasos criados! \np: %s\nq: %s\n", p.toString(), q.toString());
        System.out.printf("chaves_privadas(%s, %s)\n\n", d.toString(), n.toString());
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    //m^e % n
    public BigInteger encode(BigInteger m){
        return m.modPow(e, n);
    }

    //c^d % n
    public BigInteger decode(BigInteger c){
        return c.modPow(d, n);
    }

}
