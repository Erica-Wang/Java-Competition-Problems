/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz29;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class greedyForPies {
    static int [][][][] dp;
    static int [] ori, add;
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int func(int cur, int l, int r, int can){
        if(cur>ori.length-1||l>r){
            return 0;
        }
        if(dp[cur][l][r][can]!=-1){
            return dp[cur][l][r][can];
        }
        int max = 0;
        if(cur<=ori.length-1){
//            System.out.println("AA"+cur);
            max = Math.max(max,func(cur+1,l,r,1));
            if(can==1)
                max = Math.max(max,ori[cur]+func(cur+1,l,r,0));
        }
        if(l<=r){
            max = Math.max(max,func(cur,l+1,r,1));
            if(can==1)
                max = Math.max(max,add[r]+func(cur,l,r-1,0));
        }
        return dp[cur][l][r][can]=max;
        
    }
    public static void main (String []args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        ori = new int [m+1];
        for(int i = 1; i<=m; i++){
            ori[i]=input.nextInt();
        }
        int n = input.nextInt();
        add = new int [n+1];
        for(int i = 1; i<=n; i++){
            add[i]=input.nextInt();
        }
        Arrays.sort(add);
        
        if(n==0){
            int [] result = new int [m+1];
            result[1]=ori[1];
            for(int i = 2; i<=m; i++){
                result[i]=Math.max(result[i-1], result[i-2]+ori[i]);
            }

            System.out.println(result[m]);
        }else{

            dp = new int [m+2][n+2][n+2][2];
            for(int i = 0; i<=m; i++){
                for(int u = 0; u<=n; u++){
                    for(int j = 0; j<=n; j++){
                        dp[i][u][j][0]=-1;
                        dp[i][u][j][1]=-1;
                    }
                }
            }

            System.out.println(func(1,1,n,1));

        }
    }
}