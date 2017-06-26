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
public class Stress {
    
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    
    public static void print(boolean [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] floor = new int [n];
        int [] weight = new int [n];
        int totWeight = 0;
        for(int i = 0; i<n; i++){
            int f = input.nextInt();
            int w = input.nextInt();
            floor[i]=f;
            weight[i]=w;
            totWeight+=w;
        }
        
        int loc = 101;
        
        ArrayList<int []> routes = new ArrayList();
        ArrayList<boolean []> been = new ArrayList();
        ArrayList<Integer> num = new ArrayList();
        
        for(int i = 0; i<n; i++){
            
            int [] route = new int [n];
            
            route[0]=i;
            routes.add(route);
            boolean [] be = new boolean [n];
            be[i]=true;
            been.add(be);
            
            num.add(0);
            
        }
        
        int nu = 0;
        
        while(nu<n-1){
            
        
            int [] temp = routes.get(0);
            routes.remove(0);
            boolean [] be = been.get(0);
            been.remove(0);
            nu = num.get(0);
            num.remove(0);
            nu++;
            for(int i = 0; i<n; i++){
                if(!be[i]){
                    int [] te = temp.clone();
                    boolean [] bee = be.clone();
                    te[nu]=i;
                    bee[i]=true;
                    routes.add(te);
                    been.add(bee);
                    num.add(nu);
                    
                }
            }
        }
        
        int result = 10000000;
        for(int i = 0; i<routes.size(); i++){
            
            int tot = totWeight;
            
            int [] temp = routes.get(i);
            int tempR = 0;
            int in = strIncrease(101,floor[temp[0]],totWeight);
            tempR+=in;
            tot-=weight[temp[0]];
            
            for(int u = 1; u<n; u++){
                int cur = floor[temp[u-1]];
                int goal = floor[temp[u]];
                int inte = strIncrease(cur,goal,tot);
                tempR+=inte;
                tot-=weight[temp[u]];
            }
            
            System.out.println(tempR);
            
            if (tempR <result){
                result = tempR;
            }
            
        }
        
        System.out.println(result);
        
    }
    
    public static int strIncrease(int cur, int goal, int totWeight){
        
        return (Math.abs(cur-goal)+1)*totWeight;
        
    }
    
}
