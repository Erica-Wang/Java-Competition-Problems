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
public class Knapsack1D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Formula for knapsack 1D:
                    dp[(i-1)%2][j]
        dp[i%2][j]=
                    max(dp[(i-1)%2][j],dp[(i-1)%2][j-w]+v
        */
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int maxWeight = input.nextInt();
        int [] value = new int[num+1];
        int [] weight= new int [num+1];
        for(int i = 1; i<=num; i++){
            value[i]=input.nextInt();
            weight[i]=input.nextInt();
        }
        int [] result = new int [maxWeight+1];
        
        for(int i = 1; i<=num; i++){
            for(int u = maxWeight; u>0;u--){
                if(u>=weight[i]){
                    result[u]=Math.max(result[u], value[i]+result[u-weight[i]]);
                }
            }
        }
        
        System.out.println(result[maxWeight]);
    }
    
}
