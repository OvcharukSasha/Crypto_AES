import AES_crypto.AES_OFB;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static help.Utils.removeSpaces;
import static help.Utils.toHex;
import static org.junit.Assert.assertEquals;

public class AES_OFB_tests {
    private final int[][] ivMatrix = {
            {0x7a, 0x89, 0x2b, 0x3d},
            {0x9f, 0xd5, 0xef, 0xca},
            {0x10, 0xf5, 0xfd, 0x4e},
            {0x27, 0x0b, 0x9f, 0xa7}};

    @Test
    public void testAES_OFB_Encrypt128() throws IOException {
        {
            AES_OFB AesOFB128 = new AES_OFB(128);
            String key = "Thats my Kung Fu";
            String plainTextFile = "src/main/resources/textToTest.txt";

            String cipherText = AesOFB128.encrypt(plainTextFile, key, ivMatrix).trim();
            assertEquals("7d 65 47 a5 cc 73 42 63 32 90 55 13 5e c7 58 90 4a 8 c0 84 cc 6 49 b7 a ed 70 82 5b 93 5a 41", cipherText);

        }
    }

    @Test
    public void testAES_CFB_Decrypt128() throws IOException {
        {
            AES_OFB AesCFB128 = new AES_OFB(128);
            String key = "Thats my Kung Fu";
            String cipherTextFile = "src/main/resources/cryptedTextOFB_128.txt";

            String decryptedText = AesCFB128.decrypt(cipherTextFile, key, ivMatrix).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }

}
