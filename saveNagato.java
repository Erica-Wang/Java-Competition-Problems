/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz30;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class saveNagato {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        /*
        1. pick any node and dfs to find the farthest node from it
        2. find the node farthest from the node found in 1
        3. =start from the node found in part 2, and find the distance to every node
        4. compare the distance in step and step 3, print out whichever on eis longer
        */
        ArrayList<ArrayList<Integer>> in = new ArrayList();
        int n = input.nextInt();
        for(int i = 0; i<n; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            for(int u = in.size(); u<=Math.max(a,b); u++){
                in.add(new ArrayList());
            }
            in.get(a).add(b);
            in.get(b).add(a);
        }
        
        int max = -1;
        Queue<Integer> loc = new LinkedList();
        Queue<Integer> count = new LinkedList();
        boolean[] been = new boolean[in.size()];
        loc.add(1);
        been[1]=false;
        count.add(0);
        while(!loc.isEmpty()){
            
        }
    }
}
