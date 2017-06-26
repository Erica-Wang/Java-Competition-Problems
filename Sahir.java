/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class9;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class Sahir {
    
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        if(a==b){
            System.out.println("GO SHAHIR!");
        }else{
            ArrayList<Integer> [] road = new ArrayList[n+1];
            for(int i = 0; i<=n; i++){
                road[i]=new ArrayList ();
            }

            for(int i = 0; i<m; i++){
                int begin = input.nextInt();
                int end = input.nextInt();
                road[begin].add(end);
                road[end].add(begin);
            }

            boolean [] been = new boolean [n+1];
            been[a]=true;

            int result = 0;
            Stack <Integer> st = new Stack();
            st.add(a);
            while(!st.empty()){
                int loc = st.peek();
                st.pop();
                for(int i = 0; i<road[loc].size();i++){
                    int temp =road[loc].get(i);
                    if(temp==b){
                        result = 1;
                        st.clear();
                    }else if(!been[temp]){
                        st.add(temp);
                        been[temp]=true;
                    }
                }
            }

            if(result==1){
                System.out.println("GO SHAHIR!");
            }else{
                System.out.println("NO SHAHIR!");
            }
        
        }
    }
}
