/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz15;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class ConvexHull {
    
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        int m = input.nextInt();
        
        ArrayList<Integer> [] routes = new ArrayList[n+1];
        ArrayList<Integer> [] time = new ArrayList[n+1];
        ArrayList<Integer> [] hull = new ArrayList[n+1];
        
        for(int i = 1; i<=n; i++){
            routes[i]=new ArrayList();
            time[i]= new ArrayList();
            hull[i] = new ArrayList();
        }
        
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            
            routes[a].add(b);
            routes[b].add(a);
            
            int tim = input.nextInt();
            int hul =input.nextInt();
            
            time[a].add(tim);
            time[b].add(tim);
            hull[a].add(hul);
            hull[b].add(hul);
        }
        
        int a = input.nextInt();
        int b = input.nextInt();
        
        int result = -1;
        
        Queue<Integer> location = new LinkedList();
        Queue<Integer> hul = new LinkedList();
        Queue<Integer> tim = new LinkedList();
        Queue<boolean[]> been = new LinkedList();
        
        location.add(a);
        hul.add(k);
        tim.add(0);
        boolean [] be = new boolean [n+1];
        be[a]=true;
        been.add(be);
        while(!location.isEmpty()){
            int loc = location.poll();
            int hu = hul.poll();
            int ti = tim.poll();
            be = been.poll();
            
            
            if(hu<=0){
            }else if(loc == b){
                if(result==-1){
                    result = ti;
                }else{
                    if(result>ti){
                        result = ti;
                    }
                }
            }else{
                
                for(int i = 0; i<routes[loc].size(); i++){
                    boolean [] te = be.clone();
                    
                    int templ = routes[loc].get(i);
                    int temph = hull[loc].get(i);
                    int tempt = time[loc].get(i);
                    
                    if(!be[templ]){
                        location.add(templ);
                        hul.add(hu-temph);
                        tim.add(ti+tempt);
                        te[templ]=true;
                        been.add(te);
                    }
                }
                
            }
            
        }
        
        System.out.println(result);
        
    }
    
}
