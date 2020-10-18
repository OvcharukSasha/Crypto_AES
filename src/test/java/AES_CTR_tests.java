import AES_crypto.AES_CTR;
import AES_crypto.AES_OFB;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static help.Utils.*;
import static org.junit.Assert.assertEquals;

public class AES_CTR_tests {
    private final int[][] ivMatrix = {
            {0x7a, 0x89, 0x2b, 0x3d},
            {0x9f, 0xd5, 0xef, 0xca},
            {0x10, 0xf5, 0xfd, 0x4e},
            {0x27, 0x0b, 0x9f, 0xa7}};



    @Test
    public void testAES_CTR_Encrypt128() throws IOException {
        {
            AES_CTR AesCTR128 = new AES_CTR(128);
            String key = "Thats my Kung Fu";
            String plainTextFile = "src/main/resources/textToTest.txt";

            String cipherText = AesCTR128.encrypt(plainTextFile, key, ivMatrix).trim();
            assertEquals("18 df 40 6d 43 86 b9 12 76 d7 e7 d4 94 42 c3 7f fe 8a 19 d9 6b 94 8a 1c 7b bb 49 65 78 76 39 d1", cipherText);

        }
    }

    @Test
    public void testAES_CTR_Decrypt128() throws IOException {
        {
            AES_CTR AesCTR128 = new AES_CTR(128);
            String key = "Thats my Kung Fu";
            String cipherTextFile = "src/main/resources/cryptedTextCTR_128.txt";

            String decryptedText = AesCTR128.decrypt(cipherTextFile, key, ivMatrix).trim();
            Assert.assertEquals(toHex("Two One Nine TwoTwo One Nine Two").equalsIgnoreCase(removeSpaces(decryptedText)), true);

        }
    }

}
