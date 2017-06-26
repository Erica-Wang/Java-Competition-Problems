/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz10;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class PhenomenonReviews {
    
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void print(ArrayList<Integer>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static int sum(int []arr){
        int sum = 0;
        for(int i = 0; i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static int findMax(ArrayList<Integer> arr){
        int max = arr.get(0);
        int index = 0;
        for(int i = 1; i<arr.size();i++){
            if(arr.get(i)>max){
                max = arr.get(i);
                index = i;
            }
        }
        return index;
    }
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Integer> pho = new ArrayList();
        for(int i = 0; i<m; i++){
            int p =input.nextInt();
            pho.add(p);
        }
        
        ArrayList<Integer> [] road = new ArrayList[n];
        for(int i = 0; i<n; i++){
            road[i]=new ArrayList();
        }
        for(int i = 0; i<n-1; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            road[a].add(b);
            road[b].add(a);
        }
        
        if(m==1){
            System.out.println(0);
        }else{
        
            int work = 0;
            while(work!=-1){
                work = -1;
                for(int i = 1; i<n; i++){
                    if(road[i].size()==1){
                        if(!pho.contains(i)){
                            road[road[i].get(0)].remove(road[road[i].get(0)].indexOf(i));
                            road[i].clear();
                            work = 0;
                        }
                    }
                }
            }

            work = -1;
            //if tle then make an arraylist to store the remaining ones
            for(int i = 0; i<n; i++){
                if(road[i].size()>=2){
                    work = i;
                    break;
                }
            }

            if(work==-1){
                System.out.println(1);
            }else{
                //System.out.println();
                ArrayList<Integer> finalr = new ArrayList();
                
                for(int nu = 0; nu<road[work].size();nu++){
                
                    ArrayList<Integer> result = new ArrayList();
                    
                    Queue<Integer> loc = new LinkedList();
                    Queue<Integer> count = new LinkedList();
                    Queue<boolean[]> been = new LinkedList();

                    int l = road[work].get(nu);
                    int co = 1;
                    boolean [] be = new boolean [n];
                    be[work]=true;
                    be[l]=true;
                    
                    while(l!=-1){
                        int temp = -1;
                        for(int i = 0; i<road[l].size();i++){
                            if(!be[road[l].get(i)]){
                                temp= 0;
                                loc.add(road[l].get(i));
                                count.add(co+1);
                                be[road[l].get(i)]=true;
                                been.add(be);
                           }
                        }
                        
                        if(temp==-1){
                            result.add(co);
                        }
                        
                        if(loc.isEmpty()){
                            l= -1;
                        }else{
                            l = loc.poll();
                            co = count.poll();
                            be = been.poll();
                        }
                            
                        
                    }
                    
                    int max = result.get(0);
                    for(int i = 1; i<result.size(); i++){
                        if(result.get(i)>max){
                            max = result.get(max);
                        }
                    }
                    
                    finalr.add(max);
                }
                int longestPath = 0;
                
                int index = findMax(finalr);
                longestPath+=finalr.get(index);
                finalr.remove(index);
                
                index = findMax(finalr);
                longestPath+=finalr.get(index);
                
                //number of paths
                
                int count = 0;
                for(int i = 0; i<road.length; i++){
                    for(int u = 0; u<road[i].size();u++){
                        count++;
                        road[road[i].get(u)].remove(road[road[i].get(u)].indexOf(i));
                        road[i].remove(u);
                    }
                }
                
                System.out.println(2*count-longestPath);
                    
            }
        
        }
    }
    
}
/*
1. prun the tree (get rid of the useless edges)
2. bsf to find the longest path
3. calculate total edges
4. 2*tot - longest path
*/