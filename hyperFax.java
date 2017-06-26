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
public class hyperFax {
    static edge [] in;
    static int dp[][][];
    public static void print (int [][][]arr){
        for(int i = 0; i<arr[0].length;i++){
            for(int u = 0; u<arr[0][0].length;u++){
                System.out.print(arr[0][i][u]+" ");
            }
            System.out.println();
        }
        for(int i = 0; i<arr[0].length;i++){
            for(int u = 0; u<arr[0][0].length;u++){
                System.out.print(arr[1][i][u]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int func(int l, int r, int cur){
        //0 = left, 1 = right
        System.out.println("j"+l+" "+r+" "+cur);
        if (dp[cur][l][r]!=-1){
            System.out.println("a");
            print(dp);
            return dp[cur][l][r];
        }
        if(l==r){
            System.out.println("b");
            dp[0][l][l]=in[l].val;
            dp[1][l][l]=in[l].val;
            print(dp);
            return in[l].val;
        }
        if(cur==0){
            int firstPos = func(l+1,r,0)-(in[l+1].loc-in[l].loc)+in[l].val;
            int secPos = func(l+1,r,1)-(in[r].loc-in[l].loc)+in[l].val;
            System.out.println("aa"+firstPos+" "+secPos);
            System.out.println("c");
            print(dp);
            return Math.max(firstPos,secPos);
        }
        int firstPos = func(l,r-1,1)-(in[r].loc-in[r-1].loc)+in[r].val;
        int secPos = func(l,r,0)-(in[l].loc-in[r].loc)+in[r].val;
        System.out.println("aaa"+firstPos+" "+secPos);
        System.out.println("cc");
        print(dp);
        return dp[cur][l][r]=Math.max(firstPos,secPos);
        
    }
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        in = new edge[n];
        for(int i = 0; i<n; i++){
            in[i]=new edge(input.nextInt(),input.nextInt());
        }
        Arrays.sort(in);
        dp = new int [2][n][n];
        for(int i = 0; i<2; i++){
            for(int u = 0; u<n; u++){
                for(int w = 0; w<n; w++){
                    dp[i][u][w]=-1;
                }
            }
        }
        func(0,in.length-1,0);
        System.out.println("change");
        func(0,in.length-1,1);
        print(dp);
    }
    static class edge implements Comparable<edge>{
        int loc, val;
        public edge(int l, int v){
            loc = l;
            val = v;
        }
        
        @Override
        public int compareTo(edge e){
            return this.loc-e.loc;
        }
    }
    
}

/*

#include <bits/stdc++.h>
using namespace std;
struct E { int x, d; } a[2002];
int N, dp[2][2002][2002], sum[2002], ans=0;
bool cmp(E x, E y) { return x.x < y.x; }
int main(){
    scanf("%d", &N);
    for(int i=1; i<=N; i++)
        scanf("%d %d", &a[i].x, &a[i].d);
    sort(a+1, a+N+1, cmp);
    for(int i=1; i<=N; i++){
        sum[i] = sum[i-1] + a[i].d;
        if(a[i].x == 0) dp[0][i][i] = dp[1][i][i] = a[i].d;
    }
    for(int len=1; len < N; len++){
        for(int l=1; l+len <= N; l++){
            int r = l+len;
            int dl = max(dp[0][l+1][r], dp[1][l+1][r]-(a[r].x-a[l+1].x));
            if( dl >= a[l+1].x - a[l].x)
                dp[0][l][r] = max(dp[0][l][r], dl-(a[l+1].x-a[l].x)+a[l].d);
            int dr = max(dp[1][l][r-1], dp[0][l][r-1]-(a[r-1].x-a[l].x));
            if(dr >= a[r].x - a[r-1].x)
                dp[1][l][r] = max(dp[1][l][r], dr-(a[r].x-a[r-1].x)+a[r].d);
        }
    }
    for(int l=1; l<=N; l++)
        for(int r=l; r<=N; r++)
            if(dp[0][l][r]>0 || dp[1][l][r]>0)
                ans = max(ans, sum[r] - sum[l-1]);
    printf("%d\n", ans);
}

*/