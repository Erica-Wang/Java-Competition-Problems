/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz28;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class claireElstein {
    static ArrayList<Integer>[] in;
    static ArrayList<Integer>[] out;
    static int mod = 1000000007;

    public static void print (ArrayList<edge>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void print(node [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        in = new ArrayList[n+1];
        out = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            in[i]=new ArrayList();
            out[i]=new ArrayList();
        }
        
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            in[b].add(a);
            out[a].add(b);
        }
        
        node [] dp = new node[n+1];
        for(int i = 1; i<=n; i++){
            if(in[i].isEmpty()) dp[i]= new node(0,1);
        }
        
        for(int i = 1; i<=n; i++){
            for(int j : out[i]){
                if(dp[j]==null) dp[j]=new node(0,0);
                dp[j].len+=dp[i].len+dp[i].count;
                dp[j].count+=dp[i].count;
            }
        }
        
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(dp[i]!=null&&out[i].isEmpty()){
                count=(count+dp[i].len)%mod;
            }
        }
        
        System.out.println(count);
        
    }
    
    static class edge{
        int loc, times;
        boolean done;
        public edge(int l,int t){
            loc = l;
            times = t;
            done = false;
        }
        public String toString(){
            return this.loc+" "+this.times;
        }
    }
    
    static class node{
        int len;
        int count;
        public node(int l, int c){
            len = l;
            count = c;
        }
        public String toString(){
            return "|"+this.len+" "+this.count+"|";
        }
    }
}
