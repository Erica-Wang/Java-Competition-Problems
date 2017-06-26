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
public class notEnoughTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//cos
        int t = input.nextInt();//time
        int []dp = new int [t+1];
        for(int i = 1; i<=n; i++){
                    int p = input.nextInt();//time
                    int v = input.nextInt();//value
                    int p1 = input.nextInt();//time
                    int v1 = input.nextInt();
                    int p2 = input.nextInt();//time
                    int v2 = input.nextInt();
                    for(int u = t; u>0;u--){
                        if(u>=p){
                            dp[u]=Math.max(dp[u], dp[u-p]+v);
                        }
                        if(u>=p1){
                            dp[u]=Math.max(dp[u], dp[u-p1]+v1);
                        }
                        if(u>=p2){
                            dp[u]=Math.max(dp[u], dp[u-p2]+v2);
                        }
                }
        }
        System.out.println(dp[t]);
    }
    
}
