package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    /**
     *
     * @param n chave publica
     * @param e chave publica
     * @param c mensagem criptografada
     */
    public static void primeFactors(BigInteger n, BigInteger e, BigInteger c){
        List<BigInteger> primeFactors = new ArrayList<>();
        BigInteger d;

        //
        while (n.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
            primeFactors.add(BigInteger.TWO);
            //System.out.print(2 + " ");
            n = n.divide(BigInteger.TWO);
        }

        for (BigInteger i = BigInteger.valueOf(3);
            i.compareTo(n.sqrt()) <= 0;
            i = i.add(BigInteger.TWO)){
            while (n.mod(i).compareTo(BigInteger.ZERO) == 0){
                primeFactors.add(i);
                n = n.divide(i);
            }
        }

        if (n.compareTo(BigInteger.TWO) > 0){
            primeFactors.add(n);
            //System.out.print(n);
        }
        if(primeFactors.size() != 2){
            System.out.println("Nao foram encontrados dois números primos de " + n);
        }else{
            BigInteger phi = primeFactors.get(0).subtract(BigInteger.ONE).multiply(primeFactors.get(1).subtract(BigInteger.ONE));
            d = e.modInverse(phi);
            BigInteger decript = c.modPow(d, n);
//            System.out.println("Mensagem interceptada: " + c +
//                            "\nMensagem descriptografa por forca bruta: " + decript);
        }
        //System.out.println(primeFactors);
    }
}
