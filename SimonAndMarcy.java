/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class1;
import java.util.*;;
/**
 *
 * @author EricaWang
 */
public class SimonAndMarcy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        int M = input.nextInt();
        int [][]dp = new int [c+1][M+1];
        for(int i = 1; i<=c; i++){
            int v = input.nextInt();
            int w = input.nextInt();
            for(int j = 1; j<=M; j++){
                if(w>j){
                    dp[i][j]=dp[i-1][j];
                    
                }else{
                    dp[i][j]=Math.max(v+dp[i-1][j-w], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[c][M]);
    }
    
}
