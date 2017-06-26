/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz27;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class pickIt {
    static int [] a;
    static int [][] dp;
    public static int func(int st, int end){
        if(dp[st][end]!=0){
            return dp[st][end];
        }
        if(st+1==end){
            return dp[st][end]=0;
        }
        for(int i = st+1; i<end; i++){
            dp[st][end]=Math.max(dp[st][end],func(st,i)+func(i,end)+a[st]+a[i]+a[end]);
        }
        return dp[st][end];
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n!=0){
            a = new int [n+1];
            for(int i = 1; i<=n; i++){
                a[i]=input.nextInt();
            }
            dp = new int [n+1][n+1];
            System.out.println(func(1,n));
            n = input.nextInt();
        }
    }
    
}
