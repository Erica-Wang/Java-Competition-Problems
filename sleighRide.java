/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz12;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class sleighRide {
    
    public static void print (ArrayList<Integer>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static int sum(ArrayList <Integer> list){
        int sum = 0;
        for(int i = 0; i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }
    
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        ArrayList<Integer> [] roads = new ArrayList[n+1];
        ArrayList<Integer> [] time = new ArrayList[n+1];
        
        for(int i = 0; i<=n; i++){
            roads[i] = new ArrayList();
            time[i] = new ArrayList();
        }
        
        for(int i = 0; i<n; i++){
            
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            
            roads[a].add(b);
            roads[b].add(a);
            time[a].add(c);
            time[b].add(c);
            
        }
        
        ArrayList<Integer> result = new ArrayList();
        
        Stack<Integer> loc = new Stack();
        Stack<boolean []> been = new Stack();
        Stack<Integer> count = new Stack();
        
        boolean[] be = new boolean [n+1];
        be[0]=true;
        been.add(be);
        loc.add(0);
        count.add(0);
        
        while(!loc.isEmpty()){
            
            int l = loc.peek();
            loc.pop();
            be = been.peek();
            been.pop();
            int co = count.peek();
            count.pop();
            
            //System.out.println(l);
            
            boolean test = false;
            
            
            for(int i = 0; i<roads[l].size();i++){
                boolean [] te = be.clone();
                int temp = roads[l].get(i);
                if(!be[temp]){
                    test = true;
                    loc.add(temp);
                    te[temp]=true;
                    been.add(te);
                    
                    int t = time[l].get(i);
                    count.add(co+t);
                }
            }
            
            if(!test){
                result.add(co);
            }
        }
        
        Collections.sort(result);
        System.out.println(sum(result)*2-result.get(result.size()-1));
        
    }
    
}
