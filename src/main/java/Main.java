import AES_crypto.AES;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static help.Utils.readFromFile;
import static help.Utils.splitBy128Bits;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        int mode = 128; //count of bits (could be 128; 192; 256)

        AES AesInstance = new AES(mode);
        String pathToKey = "src/main/resources/keyToTest" + mode + ".txt";

        String keyString = readFromFile(pathToKey).trim();

        String filePath = "src/main/resources/video.mov"; //big file    //not included due to github rules
        //String filePath ="src/main/resources/textToTest.txt"; //simple text


        File file = new File(filePath);
        byte[] inputBytes = FileUtils.readFileToByteArray(file);
        byte[][] blocks = splitBy128Bits(inputBytes);


        long startTime = System.nanoTime();

        AesInstance.encrypt(blocks, keyString);

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("Encryption is finished for "+mode+" bits mode.");
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);

    }


}