/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class4;
import java.util.*;
/**
 *
 * @author EricaWang
 */
public class PickIt {

    /**
     * @param args the command line arguments
     */
    static int [][] dp = new int [205][205];
    static int [] a = new int [205];
    public static int fun(int l, int r){
        if(dp[l][r]!=0){
            return dp[l][r];
        }
        if(l+1==r){
            return dp[l][r]=0;
        }
        for(int k = l+1; k<r; k++){
            dp[l][r]=Math.max(dp[l][r],fun(l,k)+fun(k,r)+a[l]+a[k]+a[r]);
        }
        return dp[l][r];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n!=0){
            dp = new int [205][205];
            a = new int [205];
            for(int i = 1; i<=n; i++){
                a[i]=input.nextInt();
            }
            System.out.println(fun(1,n));
            n = input.nextInt();
        }
        
    }
    
}
