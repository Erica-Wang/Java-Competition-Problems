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
public class CombiningRiceball {
    
    static int [][] dp;
    static int maxRes;
    public static int find(int st, int end){
        int dif = end-st;
        int max = -1;
        
        //check for two adjacent
        for(int i = 0; i<dif; i++){
            int value = dp[st][st+i];
            if(dp[st+i+1][end]==value){
                if(max<value*2){
                    max = value*2;
                }
            }
        }
        
        //check for a combined one in the middle
        int l = st;
        int r = end;
        while(l<r-1){
            if(dp[st][l]==dp[r][end]){
                if(dp[l+1][r-1]!=-1){
                    int res = dp[st][l]*2+dp[l+1][r-1];
                    if(res>max){
                        max = res;
                    }
                    break;
                }else{
                    l++;
                    r--;
                }
            }else{
                if(dp[st][l]>dp[r][end]){
                    r--;
                }else{
                    l++;
                }
            }
        }
        
        if(max>maxRes){
            maxRes = max;
        }
        return max;
    }
    
    public static void main (String[]args){
        char a = 'a';
        char b = 'a';
        if(a==b){
            System.out.println("a");
        }
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] given = new int [n+1];
        for(int i = 1; i<=n; i++){
            given[i]=input.nextInt();
        }
        
        dp = new int [n+1][n+1];
        for(int i = 1; i<=n; i++){
            dp[i][i]=given[i];
            if(given[i]>maxRes){
                maxRes = given[i];
            }
        }
        
        for(int i = 1; i<n; i++){
            for(int st = 1; st<n; st++){
                int end = st+i;
                if(end<=n){
                    dp[st][end]=find(st,end);
                }
                
            }
        }
        System.out.println(maxRes);
    }
}
