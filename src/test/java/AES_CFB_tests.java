import AES_crypto.AES_CBC;
import AES_crypto.AES_CFB;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static help.Utils.removeSpaces;
import static help.Utils.toHex;
import static org.junit.Assert.assertEquals;

public class AES_CFB_tests {
    private final int[][] ivMatrix = {
            {0x7a, 0x89, 0x2b, 0x3d},
            {0x9f, 0xd5, 0xef, 0xca},
            {0x10, 0xf5, 0xfd, 0x4e},
            {0x27, 0x0b, 0x9f, 0xa7}};

    @Test
    public void testAES_CFB_Encrypt128() throws IOException {
        {
            AES_CFB AesCFB128 = new AES_CFB(128);
            String key = "Thats my Kung Fu";
            String plainTextFile = "src/main/resources/textToTest.txt";

            String cipherText = AesCFB128.encrypt(plainTextFile, key, ivMatrix).trim();
            assertEquals("7d 65 47 a5 cc 73 42 63 32 90 55 13 5e c7 58 90 93 90 8e 62 29 7d 7f ba bc ea 95 1a aa 2b fd 3", cipherText);

        }
    }

    @Test
    public void testAES_CFB_Decrypt128() throws IOException {
        {
            AES_CFB AesCFB128 = new AES_CFB(128);
            String key = "Thats my Kung Fu";
            String cipherTextFile = "src/main/resources/cryptedTextCFB_128.txt";
            String decryptedText = AesCFB128.decrypt(cipherTextFile, key, ivMatrix).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }

    @Test
    public void testAES_CFB_Encrypt192() throws IOException {
        {
            AES_CFB AesCFB192 = new AES_CFB(192);
            String key = "Thats my Kung Fu 1234567";
            String plainTextFile = "src/main/resources/textToTest.txt";

            String cipherText = AesCFB192.encrypt(plainTextFile, key, ivMatrix).trim();
            assertEquals("61 5a 6d 6a 23 87 9c 60 6a 36 c0 c3 3e bf ad 95 fb 6c 87 d6 ba 56 c0 b 96 db 61 85 6a f3 28 a6", cipherText);

        }
    }

    @Test
    public void testAES_CFB_Decrypt192() throws IOException {
        {
            AES_CFB AesCFB192 = new AES_CFB(192);
            String key = "Thats my Kung Fu 1234567";
            String cipherTextFile = "src/main/resources/cryptedTextCFB_192.txt";

            String decryptedText = AesCFB192.decrypt(cipherTextFile, key, ivMatrix).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }
}
