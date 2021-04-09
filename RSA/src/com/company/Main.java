package com.company;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static List<BigInteger> bruteForce(BigInteger number){
        BigInteger n = number;
        List<BigInteger> factors = new ArrayList<BigInteger>();
        for (BigInteger i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)){
            while (n.mod(i).equals(BigInteger.ZERO)){
                factors.add(i);
                n = n.divide(i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        Reciver reciver = new Reciver();
        System.out.printf("chaves_publicas(%s, %s)\n", reciver.getE().toString(),  reciver.getN().toString());

        BigInteger msg = new BigInteger("92");
        System.out.println("Mensagem original: " + msg);
        BigInteger crip = reciver.encode(msg);
        System.out.println("Menssagem criptografada: " + crip);
        BigInteger decrip = reciver.decode(crip);
        System.out.println("Menssagem descriptografada: " + decrip);

    }
}
