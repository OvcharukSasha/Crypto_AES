package help;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Utils {


    public static String convertToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X", bytes[i]));
        }
        return sb.toString();
    }

    public static String readFromFile(String filename) {
        String data = "";
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                data = data + myReader.nextLine() + " ";
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }



    public static byte[][] splitBy128Bits(byte[] inputText) {

        int countOfBlocks = (int) Math.ceil(inputText.length / 16.0);
        byte[][] blocks = new byte[countOfBlocks][16];
        for (int i = 0; i < countOfBlocks; i++) {
            if((i*16+16)>inputText.length)
                blocks[i] = Arrays.copyOfRange(inputText, i * 16, inputText.length);
            else
            blocks[i] = Arrays.copyOfRange(inputText, i * 16, i * 16 + 16);
        }

        return blocks;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(String.format("0x%08X", matrix[i][j]) + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
        System.out.println();
    }

    public static String toHex(String arg) {
        return String.format("%02X", new BigInteger(1, arg.getBytes()));
    }

//    public static byte [][] hexToByteArray(String hexString){
//        String[] hexes = hexString.split(" ");
//        byte[] byteArray = new byte[hexes.length];
//        for(int i=0; i<hexes.length; i++){
//            byteArray[i]= hexToString(hexes[i]);
//        }
//        return byteArray;
//    }

    public static byte hexToByte(String str){
        int it = Integer.parseInt(str, 16);
        BigInteger bigInt = BigInteger.valueOf(it);
        return bigInt.byteValue();

    }

    public static String removeSpaces(String hexString){
        String[] hexes = hexString.split(" ");
        StringBuilder sb=new StringBuilder();
        for (String str:hexes
             ) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static int[][] aesTheMatricenHex(String HexString, int inputlength, int words) {
        int[][] state = new int[4][words];
        int k = 0, m = -2, c = 0;
        for (int i = 0; i < words; i++) {
            for (int j = 0; j < 4; j++) {
                k += 2;
                m += 2;
                c++;
                state[j][i] = Integer.parseInt(HexString.substring(m, k), 16);
                if (c == inputlength) {
                    return state;
                }

            }
        }
        return state;
    }

    public static byte[][] convertToByteMatrix(int[][] intMatrix){
        byte[][] matrix= new byte[intMatrix.length][intMatrix[0].length];
        for (int i=0; i<intMatrix.length; i++)
            for (int j=0; j<intMatrix[0].length; j++){
                matrix[i][j]= Byte.valueOf((byte) intMatrix[i][j]);
            }
        return matrix;
    }

    public static int[][] matrixXOR(int[][]a, int[][]b){
        int[][]result=new int[a.length][a[1].length];
        if (a.length==b.length){
            for(int i=0; i<a.length; i++)
                for(int k=0; k<a[1].length; k++){
                    result[i][k]=a[i][k]^b[i][k];
                }

        }
        return result;
    }

    public int[][] deepCopy(int[][]a){
        int[][]copy=new int[a.length][a[1].length];

            for(int i=0; i<a.length; i++)
                for(int k=0; k<a[1].length; k++){
                    copy[i][k]=a[i][k];
                }
        return copy;
    }

}
