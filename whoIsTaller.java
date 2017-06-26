/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz20;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class whoIsTaller {
    
    public static void print (ArrayList<Integer>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(i+" "+arr[i]);
        }
        System.out.println();
    }
    public static void main (String []args){
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Integer>[] taller = new ArrayList[n+1];
        ArrayList<Integer>[] shorter = new ArrayList[n+1];
        
        for(int i = 0; i<=n; i++){
            taller[i]=new ArrayList();
            shorter[i]=new ArrayList();
        }
        
        for (int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();

            ArrayList<Integer> first = new ArrayList();
            ArrayList<Integer> second = new ArrayList();
            for(int u = 0; u<shorter[b].size();u++){
                int l = shorter[b].get(u);
                taller[l].add(a);
                shorter[a].add(l);
            }
            for(int u = 0; u<taller[a].size();u++){
                int l = taller[a].get(u);
                shorter[l].add(b);
                taller[b].add(l);
            }
            
            shorter[a].add(b);
            taller[b].add(a);
        }
        
        int a = input.nextInt();
        int b = input.nextInt();
        boolean bool = false;
        for(int i = 0; i<taller[a].size(); i++){
            if (taller[a].get(i)==b){
                bool = true;
                System.out.println("no");
                break;
            }
        }
        if (!bool){
            for (int i = 0; i<shorter[a].size(); i++){
                if (shorter[a].get(i)==b){
                    bool = true;
                    System.out.println("yes");
                    break;
                }
            }
        }
        
        if(!bool){
            System.out.println("unknown");
        }
        
    }
}
