/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class7;
import java.util.*;
/**
 *
 * @author EricaWang
 */
public class TroyangleNew {

    /**
     * @param args the command line arguments
     */
    public static int sumArr2D(int [][]arr){
        int sum = 0;
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                sum+=arr[i][u];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String random = input.nextLine();
        int [][] board = new int [n][n];
        for(int i = 0; i<n ; i++){
            String s = input.nextLine();
            for (int u = 0; u<n; u++){
                if(s.charAt(u)=='#'){
                    board[i][u]=1;
                }
            }
        }
        
        for(int i = n-1; i>=0; i--){
            for(int u = n-1; u>=0; u--){
                if(board[i][u]>=1&&(i+1)<n&&(u-1)>=0&&(u+1)<n){
                    board[i][u]=1+Math.min(Math.min(board[i+1][u-1],board[i+1][u]),board[i+1][u+1]);
                }
            }
        }
        
        System.out.println(sumArr2D(board));
    }
    
}
