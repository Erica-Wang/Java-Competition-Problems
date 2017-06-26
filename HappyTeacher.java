/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class3;
import java.util.*;
import java.io.*;
/**
 *
 * @author EricaWang
 */
public class HappyTeacher {

    /**
     * @param args the command line arguments
     */
    static int [][] board;
    static int [][] timeUsed;
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] hap = new int [n+1];
        int [] ene = new int [n+1];
        int [] time = new int [n+1];
        for(int i = 1; i<=n; i++){
            hap[i]=input.nextInt();
            ene[i]=input.nextInt();
            time[i]=input.nextInt();
        }
        int tmax = input.nextInt();
        
        board = new int [n+1][tmax+1];
        timeUsed = new int [n+1][tmax+1];
        
        for(int i = 1;i<=n;i++){
            for(int u = 1; u<=tmax; u++){
                
            }
        }
        
    }
    
}
