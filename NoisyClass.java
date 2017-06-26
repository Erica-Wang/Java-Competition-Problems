/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz13;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class NoisyClass {
    
    public static boolean allZero (ArrayList<Integer> arr){
        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i)!=0){
                return false;
            }
        }
        return true;
    }
    
    
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int m = input.nextInt();
        
        ArrayList<Integer> noisy = new ArrayList();
        ArrayList<Integer> distracted = new ArrayList();
        ArrayList<Integer> [] connections = new ArrayList[n+1];
        int [] app = new int [n+1];
        for(int i = 1; i<=n; i++){
            connections[i] = new ArrayList();
        }
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            noisy.add(a);
            distracted.add(b);
            connections[a].add(i);
            app[b]++;
        }
        
        Queue<Integer> next = new LinkedList();
        
        for(int i = 1; i<=n; i++){
            if(app[i]==0){
                next.add(i);
            }
        }
        
        while(!next.isEmpty()){
            
            int loc = next.poll();
            
            for(int i = 0; i<connections[loc].size(); i++){
                
                int temp = connections[loc].get(i);
                
                int t = distracted.get(temp);
                
                app[t]--;
                if (app[t]==0){
                    next.add(t);
                }
                
                distracted.set(temp, 0);
                noisy.set(temp, 0);
            }
            
        }
        
        if(allZero(noisy)){
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
        
    }
    
}
