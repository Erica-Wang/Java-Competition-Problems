/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class2;
import java.util.*;
/**
 *
 * @author EricaWang
 */
public class codingSpree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int t =input.nextInt();//num
        int j = input.nextInt();//time
        
        int [][] dp = new int [t+1][j+1];
        
        for(int i = 1; i<=t; i++){
            int value=input.nextInt();
            int time=input.nextInt();
            for(int u = 1; u<=j; u++){
                if(time>u){
                    dp[i][u]=dp[i-1][u];
                }else{
                    dp[i][u]=Math.max(value+dp[i-1][u-time],dp[i-1][u]);
                }
            }
        }
        System.out.println(dp[t][j]);
        
    }
    
}
