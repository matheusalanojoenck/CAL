package com.company;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Util {
    public static int BIT_LENGTH = 56;
    private static final Random rand = new SecureRandom();

    /**
     * Algoritmo de Euclides Estendido, para achar o maior divisor comum entre dois números
     * @param (a, b), sao os números que vao ser comprados
     * @param (x, y) sao variáveis auxiliares para o calculo de gcd
     * @return gcd, o maior divisor comum
     */
    public static BigInteger gcdExtended(BigInteger a, BigInteger b, BigInteger x, BigInteger y){
        if(a.equals(BigInteger.ZERO)){
            x = BigInteger.ZERO;
            y = BigInteger.ONE;
            return b;
        }
        BigInteger x1 = new BigInteger("1");
        BigInteger y1 = new BigInteger("1");
        BigInteger gcd = gcdExtended(b.mod(a), a, x1, y1);
        x = y1.subtract(b.divide(a).multiply(x1));
        y = x1;
        return gcd;
    }

    /**
     * Método de fermat para determinar a primalidade de número (O(k log n)
     * @param n, o número que está sendo feito os teste de primalidade
     * @param k, a quantidade de vez que o teste vai ser executado (quando maior o k, maior a chance de um resultado certo)
     * @return true ou false, caso a variável n seja ou não um numero primo
     */
    public static boolean fermat(BigInteger n, int k){
        for(int i = 0; i < k; i++){
            BigInteger a = new BigInteger("" + rand.nextInt());
            //System.out.println(a.toString() + " " + n);
            BigInteger ans = a.modPow(n.subtract(BigInteger.ONE), n);
            if(!ans.equals(BigInteger.ONE))
                return false;
        }
        return true;
    }

    /**
     * Método utilizado para gerar um numero que seja um primo relativo a variavel do argumento da funcao
     * @param phi, numero ao qual queremos encontrar um primo relativo
     * @return numero que é primo relativo a phi
     */
    public static BigInteger randomCoprime(BigInteger phi){
        BigInteger x = BigInteger.ONE;
        BigInteger y = BigInteger.ONE;
        BigInteger e;
        do{
            e = new BigInteger(phi.bitLength(), rand);
        }while (!gcdExtended(e, phi, x, y).equals(BigInteger.ONE));
        return e;
    }

    /**
     * Loop que gera um numero aleatório primo
     * @return numero primo aleatório
     */
    public static BigInteger randomPrimeBigInteger(){
        BigInteger n;
        do{
            n = new BigInteger(BIT_LENGTH /2, rand).abs();
            if(n.compareTo(BigInteger.ZERO) == 0) n = n.add(BigInteger.ONE);
        }while (!fermat(n, 60));
        return n;
    }
}
