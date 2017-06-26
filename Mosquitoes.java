/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz16;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class Mosquitoes {
    
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList <Integer> x = new ArrayList();
        ArrayList <Integer> y = new ArrayList();
        for(int i = 0; i<n; i++){
            x.add(input.nextInt());
            y.add(input.nextInt());
        }
        
        Collections.sort(x);
        Collections.sort(y);
        int max = x.get(x.size()-1)-x.get(0);
        int ma = y.get(y.size()-1)-y.get(0);
        
        if(max>ma){
            System.out.println(max*max);
        }
        else{
            System.out.println(ma*ma);
        }
        
    }
            
    
}
