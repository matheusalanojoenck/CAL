package com.company;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Reciver reciver = new Reciver();
        System.out.printf("chaves_publicas(%s, %s)\n", reciver.getE().toString(),  reciver.getN().toString());

        BigInteger msg = new BigInteger("65");
        System.out.println("Mensagem original: " + msg);
        BigInteger crip = reciver.encode(msg);
        System.out.println("Menssagem criptografada: " + crip);
        BigInteger decrip = reciver.decode(crip);
        System.out.println("Menssagem descriptografada: " + decrip);
        BruteForce.primeFactors(reciver.getN(), reciver.getE(), crip);
    }
}
