import AES_crypto.AES_ECB;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static help.Utils.removeSpaces;
import static help.Utils.toHex;
import static org.junit.Assert.assertEquals;

public class AES_ECB_tests {

    @Test
    public void testAES_ECB_Encrypt128() throws IOException {
        {
            AES_ECB AesECB128 = new AES_ECB(128);
            String key = "Thats my Kung Fu";
            String plainTextFile = "src/main/resources/textToTest.txt";
            String cipherText = AesECB128.encrypt(plainTextFile, key).trim();
            assertEquals("29 c3 50 5f 57 14 20 f6 40 22 99 b3 1a 2 d7 3a 29 c3 50 5f 57 14 20 f6 40 22 99 b3 1a 2 d7 3a", cipherText);

        }
    }

    @Test
    public void testAES_ECB_Decrypt128() throws IOException {
        {
            AES_ECB AesECB128 = new AES_ECB(128);
            String key = "Thats my Kung Fu";
            String cipherTextFile = "src/main/resources/cryptedTextECB_128.txt";
            String decryptedText = AesECB128.decrypt(cipherTextFile, key).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }


    @Test
    public void testAES_ECB_Encrypt192() throws IOException {
        {
            AES_ECB AesECB128 = new AES_ECB(192);
            String key = "Thats my Kung Fu 1234567";
            String plainTextFile = "src/main/resources/textToTest.txt";
            String cipherText = AesECB128.encrypt(plainTextFile, key).trim();
            assertEquals("7b c2 94 c8 61 6a a6 84 f8 5c ef bd be 36 e7 2b 7b c2 94 c8 61 6a a6 84 f8 5c ef bd be 36 e7 2b", cipherText);

        }
    }
//
//    @Test
//    public void testAES_ECB_Decrypt192() throws IOException {
//        {
//            AES_ECB AesECB128 = new AES_ECB(192);
//            String key = "Thats my Kung Fu 1234567";
//            String cipherTextFile = "src/main/resources/cryptedTextECB_192.txt";
//            String decryptedText = AesECB128.decrypt(cipherTextFile, key).trim();
//            Assert.assertEquals(toHex("Two One Nine Two"),(removeSpaces(decryptedText)));
//
//        }
//    }

    @Test
    public void testAES_ECB_Encrypt256() throws IOException {
        {
            AES_ECB AesECB256 = new AES_ECB(256);
            String key = "Thats my Kung Fu 123456789qwerty";
            String plainTextFile = "src/main/resources/textToTest.txt";
            String cipherText = AesECB256.encrypt(plainTextFile, key).trim();
            assertEquals("44 46 44 6 f2 49 f1 50 4d 5c 7e 8b 1 39 85 4 44 46 44 6 f2 49 f1 50 4d 5c 7e 8b 1 39 85 4", cipherText);

        }
    }
//
//    @Test
//    public void testAES_ECB_Decrypt256() throws IOException {
//        {
//            AES_ECB AesECB256 = new AES_ECB(256);
//            String key = "Thats my Kung Fu 123456789qwerty";
//            String cipherTextFile = "src/main/resources/cryptedTextECB_256.txt";
//            String decryptedText = AesECB256.decrypt(cipherTextFile, key).trim();
//            Assert.assertEquals(toHex("Two One Nine Two"),(removeSpaces(decryptedText)));
//
//        }
//    }


}
