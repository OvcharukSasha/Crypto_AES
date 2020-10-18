import AES_crypto.*;

import java.io.IOException;

import static help.Utils.readFromFile;


public class Main {

    private static final int[][] ivMatrix = {
            {0x7a, 0x89, 0x2b, 0x3d},
            {0x9f, 0xd5, 0xef, 0xca},
            {0x10, 0xf5, 0xfd, 0x4e},
            {0x27, 0x0b, 0x9f, 0xa7}};

    public static void main(String[] args) throws InterruptedException, IOException {

        int mode = 128; //count of bits (could be 128; 192; 256)

        String pathToKey = "src/main/resources/keyToTest" + mode + ".txt";
        String keyString = readFromFile(pathToKey).trim();
       // String filePath = "src/main/resources/sample-large-text-file.txt"; //big file    //not included due to github rules
        String filePath ="src/main/resources/textToTest.txt"; //simple text


        long startTime, endTime, timeElapsed;

        //executing AES ECB encryption
        AES_ECB aes_ecb = new AES_ECB(mode);
        startTime = System.nanoTime();
        aes_ecb.encrypt(filePath, keyString);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Encryption is finished for AES ECB " + mode + " bits mode.");
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        System.out.println("Execution time in seconds : " +
                timeElapsed / 1000000000);
        System.out.println();


        //executing AES CBC encryption
        AES_CBC aes_cbc = new AES_CBC(mode);
        startTime = System.nanoTime();
        aes_cbc.encrypt(filePath, keyString, ivMatrix);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Encryption is finished for AES CBC " + mode + " bits mode.");
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        System.out.println("Execution time in seconds : " +
                timeElapsed / 1000000000);
        System.out.println();


        //executing AES CFB encryption
        AES_CFB aes_cfb = new AES_CFB(mode);
        startTime = System.nanoTime();
        aes_cfb.encrypt(filePath, keyString, ivMatrix);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Encryption is finished for AES CFB " + mode + " bits mode.");
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        System.out.println("Execution time in seconds : " +
                timeElapsed / 1000000000);
        System.out.println();


        //executing AES OFB encryption
        AES_OFB aes_ofb = new AES_OFB(mode);
        startTime = System.nanoTime();
        aes_ofb.encrypt(filePath, keyString, ivMatrix);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Encryption is finished for AES OFB " + mode + " bits mode.");
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        System.out.println("Execution time in seconds : " +
                timeElapsed / 1000000000);
        System.out.println();


        //executing AES CTR encryption
        AES_CTR aes_ctr = new AES_CTR(mode);
        startTime = System.nanoTime();
        aes_ctr.encrypt(filePath, keyString, ivMatrix);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Encryption is finished for AES CTR " + mode + " bits mode.");
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        System.out.println("Execution time in seconds : " +
                timeElapsed / 1000000000);
        System.out.println();
    }

}