import AES_crypto.AES_CBC;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static help.Utils.removeSpaces;
import static help.Utils.toHex;
import static org.junit.Assert.assertEquals;

public class AES_CBC_tests {
    private final int[][] ivMatrix = {
            {0x7a, 0x89, 0x2b, 0x3d},
            {0x9f, 0xd5, 0xef, 0xca},
            {0x10, 0xf5, 0xfd, 0x4e},
            {0x27, 0x0b, 0x9f, 0xa7}};

    @Test
    public void testAES_CBC_Encrypt128() throws IOException {
        {
            AES_CBC AesCBC128 = new AES_CBC(128);
            String key = "Thats my Kung Fu";
            String plainTextFile = "src/main/resources/textToTest.txt";

            String cipherText = AesCBC128.encrypt(plainTextFile, key, ivMatrix).trim();
            assertEquals("b7 2f 8a a9 e0 11 bd 16 ed 94 44 fa bb d7 ce 7b 22 a8 88 83 34 46 8 cb f9 9e 50 a a5 d0 a1 3", cipherText);

        }
    }

    @Test
    public void testAES_CBC_Decrypt128() throws IOException {
        {
            AES_CBC AesCBC128 = new AES_CBC(128);
            String key = "Thats my Kung Fu";
            String cipherTextFile = "src/main/resources/cryptedTextCBC_128.txt";

            String decryptedText = AesCBC128.decrypt(cipherTextFile, key, ivMatrix).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }


    @Test
    public void testAES_CBC_Encrypt192() throws IOException {
        {
            AES_CBC AesCBC192 = new AES_CBC(192);
            String key = "Thats my Kung Fu 1234567";
            String plainTextFile = "src/main/resources/textToTest.txt";

            String cipherText = AesCBC192.encrypt(plainTextFile, key, ivMatrix).trim();
            assertEquals("ba f6 d5 40 99 e1 ef b5 1c 54 66 7 f2 de 52 e9 f2 77 86 ff e6 a 79 ca 8f d9 ab a5 d0 ef 35 1f", cipherText);

        }
    }

    @Test
    public void testAES_CBC_Decrypt192() throws IOException {
        {
            AES_CBC AesCBC192 = new AES_CBC(192);
            String key = "Thats my Kung Fu 1234567";
            String cipherTextFile = "src/main/resources/cryptedTextCBC_192.txt";

            String decryptedText = AesCBC192.decrypt(cipherTextFile, key, ivMatrix).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }
    @Test
    public void testAES_CBC_Encrypt256() throws IOException {
        {
            AES_CBC AesCBC256 = new AES_CBC(256);
            String key = "Thats my Kung Fu 123456789qwerty";
            String plainTextFile = "src/main/resources/textToTest.txt";

            String cipherText = AesCBC256.encrypt(plainTextFile, key, ivMatrix).trim();
            assertEquals("22 b e7 13 aa d1 8b 48 52 c3 57 bf 8 b9 5f 98 b 73 5c 94 2c 87 86 1a f0 b7 42 d3 1 e5 96 ab", cipherText);

        }
    }

    @Test
    public void testAES_CBC_Decrypt256() throws IOException {
        {
            AES_CBC AesCBC256 = new AES_CBC(256);
            String key = "Thats my Kung Fu 123456789qwerty";
            String cipherTextFile = "src/main/resources/cryptedTextCBC_256.txt";

            String decryptedText = AesCBC256.decrypt(cipherTextFile, key, ivMatrix).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }


}
