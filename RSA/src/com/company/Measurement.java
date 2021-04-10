package com.company;

import java.io.*;
import java.math.BigInteger;

public class Measurement {
    private static final int RUN = 100;


    public static void timeEverthing(){
        long start, finish, total;
        for (int i = 0; i < RUN; i++){
            start = System.nanoTime();
            final BigInteger p = Util.randomPrimeBigInteger();
            finish = System.nanoTime();
            total = finish - start;
            try {
                FileWriter myWriter = new FileWriter("timeRandomPrime.txt", true);
                myWriter.write(total+"\n");
                myWriter.close();
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }

            final BigInteger q = Util.randomPrimeBigInteger();
            //(p-1)*(q-1)
            final BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
            final BigInteger n = p.multiply(q);

            start = System.nanoTime();
            final BigInteger e = Util.randomCoprime(phi);
            finish = System.nanoTime();
            total = finish - start;
            try {
                FileWriter myWriter = new FileWriter("timeRandomCoPrime.txt", true);
                myWriter.write(total+"\n");
                myWriter.close();
                //System.out.println("Successfully wrote to the file.");
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }

            final BigInteger d = e.modInverse(phi);

            //Novo caractere a ser criptografado
            BigInteger m = new BigInteger("21");

            start = System.nanoTime();
            BigInteger encode = m.modPow(e, n);
            finish = System.nanoTime();
            total = finish - start;
            try {
                FileWriter myWriter = new FileWriter("timeEncode.txt", true);
                myWriter.write(total+"\n");
                myWriter.close();
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }

            start = System.nanoTime();
            BigInteger decode = encode.modPow(d, n);
            finish = System.nanoTime();
            total = finish - start;
            try {
                FileWriter myWriter = new FileWriter("timeDecode.txt", true);
                myWriter.write(total+"\n");
                myWriter.close();
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }
        }
    }
}
