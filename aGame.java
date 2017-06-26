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
public class aGame {

    /**
     * @param args the command line arguments
     */
    static int [][] dp;
    public static void print (int [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        int m = input.nextInt();
        dp = new int [m+1][m+1];
        int[] b = new int [m+1];
        int [] sum = new int [m+1];
        for(int i=1; i<=m; i++){
            b[i]=input.nextInt();
            sum [i]=sum[i-1]+b[i];
        }
        int a = func(sum,1,m);
        System.out.println(a+" "+(sum[m]-a));
        print(dp);
    }
    public static int func (int [] sum, int l, int r){
        int s = sum[r]-sum[l-1];
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=0){
            return dp[l][r];
        }
        return dp[l][r]= Math.max(s-func(sum,l,r-1),s-func(sum,l+1,r));
    }
    
}
