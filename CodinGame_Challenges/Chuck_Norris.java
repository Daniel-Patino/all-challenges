import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Chuck_Norris {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        Chuck_Norris newSolution = new Chuck_Norris();
        
        String ourBins = Chuck_Norris.toBin7(MESSAGE);
        String toOut = Chuck_Norris.toUnary(ourBins);
        
        System.out.println(toOut);
    }
    
    public static String toBin7(String MESSAGE){
        char[] toCharArr = MESSAGE.toCharArray();
        String ourBins = new String();
        String tempBin = new String();
        int toCheckIfSeven = 0;
        
        for(int i = 0; i < toCharArr.length; i++){
            tempBin = Integer.toBinaryString(toCharArr[i]);
            toCheckIfSeven = 7 - tempBin.length(); 
            
            for(int k = 0; k < toCheckIfSeven; k++){
               tempBin = "0" + tempBin;
            }
            
            ourBins = ourBins + tempBin; 
        }
        return ourBins;
    }
    
    public static String toUnary(String ourBin){
        char[] toCharArr = ourBin.toCharArray();
        String unaryStr = new String();
        
        int repCount = 0;
        char last = toCharArr[0];
        String toOutput = new String();
        int iterator = 0;
        boolean noNeed = false;
        
        while(iterator < toCharArr.length){
            
            char next = toCharArr[iterator];
            
            if(last != next || iterator == toCharArr.length - 1){
                if(last == '0'){
                    toOutput = toOutput + "00 ";
                }   
                else{
                    toOutput = toOutput + "0 ";
                }
                
                for(int j = 0; j < repCount; j++)
                    toOutput = toOutput + "0";
                    
                repCount = 0;
                last = toCharArr[iterator];
                
                if(iterator != toCharArr.length - 1)
                    toOutput = toOutput + " ";
            }

            if(iterator == toCharArr.length - 1 && repCount == 0){
                
                last = toCharArr[iterator];
                if(last == toCharArr[iterator - 1]){
                    noNeed = true;
                }
                if(!noNeed){
                    toOutput = toOutput + " ";
                }
                if(last == '0' && !noNeed){
                    toOutput = toOutput + "00 ";
                }   
                if(last == '1' && !noNeed){
                    toOutput = toOutput + "0 ";
                }
                toOutput = toOutput + "0";
            }
            repCount++;
            iterator++;
        }
        return toOutput;
    }
}