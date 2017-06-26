/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class7;
import java.util.*;
/**
 *
 * @author EricaWang
 */
public class Golf {

    /**
     * @param args the command line arguments
     */
    public static void print1D(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int d = input.nextInt();
        int num = input.nextInt();
        int [] club = new int [num];
        for(int i = 0; i<num; i++){
            club[i]=input.nextInt();
        }
        Arrays.sort(club);
        int [] clubs = new int [num];
        for(int i = 0; i<clubs.length; i++){
            clubs[i]=club[num-1-i];
        }
        int []dp = new int [d+1];
        dp[0]=0;
        for(int i = 1; i<=d; i++){
            dp[i]=10000;
        }
        
        for(int i = 0; i<num; i++){
            for(int U = clubs[i];U<=d;U++){
                dp[U]=Math.min(dp[U],dp[U-clubs[i]]+1);
            }
        }
        if(dp[d]!=10000){
            System.out.println("Roberta wins in "+dp[d]+" strokes.");
        }else{
            System.out.println("Roberta acknowledges defeat.");
        }
    }
    
}
