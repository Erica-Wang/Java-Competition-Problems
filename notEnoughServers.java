/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz32;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class notEnoughServers {
    public static void print (ArrayList<Integer>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static int findMax(ArrayList[]arr){
        int max = arr[0].size();
        int pos =0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i].size()>max){
                pos = i;
                max = arr[i].size();
            }
        }
        return pos;
    }
    public static void remove(ArrayList<Integer>[]arr, int a){
        for(int i = 0; i<arr.length; i++){
            for(int u = 0; u<arr[0].size(); u++){
                if(arr[i].get(u)==a){
                    arr[i].remove(u);
                }
            }
        }
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Integer> [] personFail = new ArrayList[n];
        ArrayList<Integer> [] questionFail = new ArrayList[m];
        for(int i = 0; i<n; i++){
            personFail[i] = new ArrayList();
        }
        for(int i = 0; i<m; i++){
            questionFail[i] = new ArrayList();
        }
        ArrayList<Integer> remaining = new ArrayList();
        for(int i = 0; i<n; i++){
            remaining.add(i);
            String s = input.next();
            boolean allTrue = true;
            for(int u = 0; u<m; u++){
                if(s.charAt(u)=='X'){
                    allTrue=false;
                    personFail[i].add(u);
                    questionFail[u].add(i);
                }
            }
            if(allTrue){
                remaining.remove(remaining.size()-1);
                personFail[i].clear();
            }
        }
        int count = 0;
        ArrayList<Integer> removed = new ArrayList();
        while(!remaining.isEmpty()){
            int remove = findMax(questionFail);
            removed.add(remove);
            for(int i = 0; i<questionFail[remove].size(); i++){
                int pos = questionFail[remove].get(i);
                int index = remaining.indexOf(pos);
                if(index!=-1){
                    personFail[pos].clear();
                    remaining.remove(index);
                    remove(questionFail,pos);
                }
            }
            count++;
        }
        System.out.println(count);
        for(int i = 0; i<removed.size(); i++){
            System.out.print(removed.get(i)+1+" ");
        }
        
    }
}
