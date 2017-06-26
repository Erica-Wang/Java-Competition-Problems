/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class9;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class BowlingForNumbers {
    static int [] in;
    static int [][]dp;
    
    public static int sum ( int begin, int end){
        int sum = 0;
        for(int i = begin; i<=end; i++){
            sum +=in[i];
        }
        return sum;
    }
    public static void print2D (int [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        
        int t = input.nextInt();
        for(int p = 0; p<t; p++){
            int n = input.nextInt(); //pins
            int k = input.nextInt(); //balls
            int w = input.nextInt(); //width 3
            
            in = new int [n];
            for(int i = 0; i<n; i++){
                in[i]=input.nextInt();
            }
            
            dp = new int [k][n];
            
            for(int i = 0; i<n; i++){
                if(i<w){
                    dp[0][i]=sum(0,i);
                }else{
                    dp[0][i]=Math.max(sum(i-w+1,i), dp[0][i-1]);
                }
            }
            
            for(int N = 1; N<k; N++){
                for(int i = 0; i<n; i++){
                    if(i<(w*(N+1))){
                        dp[N][i]=sum(0,i);
                    }else{
                        dp[N][i]=Math.max(sum(i-w+1,i)+dp[N-1][i-w], dp[N][i-1]);
                    }
                }
            }
            System.out.println(dp[k-1][n-1]);
            
        }
        
    }
    
}
