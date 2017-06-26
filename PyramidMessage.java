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
public class PyramidMessage {
    
    static ArrayList<String> appeared = new ArrayList();
    static ArrayList<ArrayList<String>> contains = new ArrayList();
//    
    public static void print (ArrayList<ArrayList<String>> list){
        for(int i = 0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int findMax(int [] arr){
        int max = arr[0];
        for(int i = 1; i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        for(int num = 0; num<l; num++){
            int n = input.nextInt();
            ArrayList<String> in = new ArrayList();
            for(int i = 0; i<n; i++){
                in.add(input.next());
            }
            ArrayList<String> home = new ArrayList();
            contains.add(home);
            appeared.add(in.get(in.size()-1));
            
            String temp = in.get(in.size()-1);
            for(int i = 0; i<n; i++){
                String s= in.get(i);
                
                if(!appeared.contains(s)){
                    appeared.add(s);
                    int index = appeared.indexOf(temp);
                    contains.get(index).add(s);
                    contains.add(new ArrayList());
                }
                
                temp = s;
            }
            
            int [] value = new int [appeared.size()];
            
            Stack<Integer> loc = new Stack();
            loc.add(0);
            
            while(!loc.isEmpty()){
                
                int loca = loc.peek();
                loc.pop();
                
                for(int i = 0; i<contains.get(loca).size();i++){
                    int te = appeared.indexOf(contains.get(loca).get(i));
                    if(value[te]==0){
                        value[te]=value[loca]+1;
                        loc.add(te);
                    }
                }
                
            }
            
            int max = findMax(value);
            System.out.println(n*10-max*20);
            
            appeared.clear();
            contains.clear();
        }
        
    }
}
