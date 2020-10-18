package AES_crypto;

import help.Utils;

import java.io.*;
import java.nio.charset.Charset;

import static help.Utils.*;

public class AES_ECB {   //Electronic Code Book
    private static AES aesCipher;
    private StringBuilder sbInput;
    private StringBuilder sbOutput;

    public AES_ECB(int mode) {
        aesCipher = new AES(mode);
    }

    public String encrypt(String filename, String KeyString) throws IOException {

        String KeyTextHex = convertToHexString(KeyString.getBytes());
        int keyLength = KeyString.length();
        int[][] keysHexMatrix = Utils.aesTheMatricenHex(KeyTextHex, keyLength, aesCipher.getNK());
        sbInput = new StringBuilder();
        sbOutput = new StringBuilder();

        InputStream in = new FileInputStream(filename);
        Charset encoding = Charset.defaultCharset();
        Reader reader = new InputStreamReader(in, encoding);
        int textLength = 16;
        boolean isFileReadable = true;
        while (isFileReadable) {
            sbInput = new StringBuilder();

            for (int i = 0; i < textLength; i++) {
                int r = reader.read();
                if (r != -1) {
                    sbInput.append((char) r);
                } else {
                    if (i == 0) {
                        //System.out.println("EOF");
                        isFileReadable = false;
                        break;
                    } else {
                        for (int k = 15 - i; k >= 0; k--)
                            sbInput.append(" ");
                    }
                }
            }

            if (!isFileReadable) break;
            String InputTextHex = convertToHexString(sbInput.toString().getBytes());
            int[][] hexInputMatrix = Utils.aesTheMatricenHex(InputTextHex, textLength, aesCipher.Nw);
            aesCipher.DoEncryption(hexInputMatrix, keysHexMatrix);
            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 4; j++) {
                    sbOutput.append(Integer.toHexString(aesCipher.getStateAt(j, k)) + " ");
                }
            }
        }
        return sbOutput.toString();
    }

    public String decrypt(String filename, String KeyString) throws IOException {

        String KeyTextHex = convertToHexString(KeyString.getBytes());
        int keyLength = KeyString.length();
        int[][] keysHexMatrix = Utils.aesTheMatricenHex(KeyTextHex, keyLength, aesCipher.getNK());
        sbOutput = new StringBuilder();

        InputStream in = new FileInputStream(filename);
        Charset encoding = Charset.defaultCharset();
        Reader reader = new InputStreamReader(in, encoding);

        boolean isFileReadable = true;
        int textLength = 16;
        while (isFileReadable) {
            byte[] inputBlock = new byte[textLength];

            for (int i = 0; i < textLength; ) {
                String hex = "";
                int r1 = reader.read();
                if ((r1 != -1) && ((char) r1 != ' ')) {
                    hex += (char) r1;
                    int r2 = reader.read();
                    if (r2 != -1)
                        if ((char) r2 != ' ')
                            hex += (char) r2;

                    inputBlock[i] = hexToByte(hex);
                    ++i;
                } else {
                    if (r1 == -1) {
                        //System.out.println("EOF");
                        isFileReadable = false;
                        for (int k = 15 - i; k >= 0; k--)
                            inputBlock[k] = 0;
                        break;
                    } else if ((char) r1 != ' ') {
                        i = i - 1;
                        continue;
                    }
                }
            }
            if (!isFileReadable) break;
            String InputTextHex = convertToHexString(inputBlock);
            int[][] hexInputMatrix = Utils.aesTheMatricenHex(InputTextHex, textLength, aesCipher.Nw);

            aesCipher.DoDecryption(hexInputMatrix, keysHexMatrix);

            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 4; j++) {
                    sbOutput.append(Integer.toHexString(aesCipher.getStateAt(j, k)) + " ");
                }
            }
        }
        return sbOutput.toString();
    }


}
