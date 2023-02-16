import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr1 = input.split(",");
        
        int c=0;
        for(int i =0 ;i<arr1.length ;i++ ){
            char[] s1 = arr1[i].toCharArray();
            boolean[] alphabetPresent = new boolean[26];
            for(char ch : s1){
                if(Character.isLetter(ch)){
                    alphabetPresent[ch-'a'] = true;
                }
            }
			String[] arr2 = new String[arr1.length-1];
            System.arraycopy(arr1,0,arr2,0,i);
            System.arraycopy(arr1,i+1,arr2,i,arr2.length-i);
            // System.out.println(Arrays.toString(arr2));
            for(int j =0; j < arr2.length;j++){
                char[] s2 = arr2[j].toCharArray();
                boolean flag = false;
                for(char letter : s2){
                    if(Character.isLetter(letter) && !alphabetPresent[letter-'a']){
                        flag = true;
                        break;
                    }
                    
                    
                }
                if(!flag)c++;
            }
            
        }
        if(c==0)
            System.out.println(0);
        else{
        	System.out.println(c);}
    }
}