import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Ascii_Art {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        
        char[][] asciiMatrix = new char[H][];
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            asciiMatrix[i] = ROW.toCharArray(); 
        }
        
        char[] charArr = T.toCharArray();
        
        for(int totalHeight = 0; totalHeight < H; totalHeight++){
            for(int k = 0; k < charArr.length; k++){
                Ascii_Art.displayLetter(asciiMatrix, charArr[k], L, totalHeight);
            }
            
            System.out.println();
        }
        
        in.close();
    }
    
    public static void displayLetter(char[][] asciiMatrix, char letterToFind, int widthOfLetter, int currentHeight){
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L','M',
                 + 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '?'};
            
        int iter = 0;
        
        if(letterToFind >= 97 && letterToFind <= 122){
            letterToFind -= 32;
        }
        
        while(letterToFind != alphabet[iter] && iter < 26){
            iter++;
        }
        
        for(int k = 0; k < widthOfLetter; k++){
            System.out.print(asciiMatrix[currentHeight][(iter * widthOfLetter) + k]);
        }
    }
}