/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class3;
import java.util.*;
/**
 *
 * @author EricaWang
 */
public class JaydenEatsChoco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int min = n;
        int [ ] arr = new int [3];
        for(int i = 0; i<3; i++){
            arr[i]=input.nextInt();
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println(n/min);
    }
    
}
