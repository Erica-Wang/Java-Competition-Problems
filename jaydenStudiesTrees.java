/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz25;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class jaydenStudiesTrees {
    
    public static int findMax(int [] arr){
        int max = arr[1];
        for(int i = 2; i<arr.length;i++){
            if(arr[i]!=1000000&&arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> [] map = new ArrayList [n+1];
        for(int i = 1; i<=n; i++){
            map[i]=new ArrayList();
        }
        
        ArrayList<Integer> once = new ArrayList();
        ArrayList<Integer> done = new ArrayList();
        
        for(int i = 0; i<n-1; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            map[a].add(b);
            map[b].add(a);
            
            if(done.contains(a)){
            }else if(once.contains(a)){
                once.remove(once.indexOf(a));
                done.add(a);
            }else if(!once.contains(a)){
                once.add(a);
            }
            
            if(done.contains(b)){
            }else if(once.contains(b)){
                once.remove(once.indexOf(b));
                done.add(b);
            }else{
                once.add(b);
            }
        }
        
        int max = -1;
        
        for(int nu = 0; nu<once.size(); nu++){
            int [] count = new int [n+1];
            Arrays.fill(count, 1000000);
            count[once.get(nu)]=0;
            Queue<Integer> list = new LinkedList();
            list.add(once.get(nu));
            while(!list.isEmpty()){
                int cur = list.poll();
                for(int i = 0; i<map[cur].size(); i++){
                    int temp = map[cur].get(i);
                    if(count[temp]==1000000){
                        count[temp]=count[cur]+1;
                        list.add(temp);
                    }
                }
            }
            int curMax = findMax(count);
            if(curMax>max){
                max = curMax;
            }
        }
        System.out.println(max);
    }
}
