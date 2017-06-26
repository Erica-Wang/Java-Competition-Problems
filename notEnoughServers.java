/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz34;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class notEnoughServers {
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void print (dp [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[]args){
        InputReader input = new InputReader(System.in);
        int n = input.readInt();
        int m = input.readInt();
        int [] inp = new int [m+1];
        int result = 0;
        for(int i = 0; i<n; i++){
            String s = input.readString();
            boolean isWrong = false;
            for(int u = 1; u<=m; u++){
                if (s.charAt(u-1)=='X'){
                    isWrong = true;
                    inp[u]+=Math.pow(2, n-1-i);
                }
            }
            
            if (isWrong){
                result+=Math.pow(2,n-1-i);
            }
        }
        
        dp [][] dp = new dp [m+1][(int)Math.pow(2, n)];
        ArrayList<Integer> check = new ArrayList();
        ArrayList<Integer> store = new ArrayList();
        for(int i = 0; i<=m; i++){
            for(int u = 0; u<=Math.pow(2,n)-1; u++){
                dp[i][u]=new dp(10000,-1,false);
            }
        }
        for(int i = 0; i<=m; i++){
            dp[i][0].value=0;
        }
        store.add(0);
        for(int i = 1; i<=m; i++){
            check = (ArrayList<Integer>) store.clone();
            store.clear();
            store.add(inp[i]);
            dp[i][inp[i]] = new dp(1,-1,true);
            for(int u = 0; u<check.size(); u++){
                
                if (dp[i][check.get(u)].value>dp[i-1][check.get(u)].value){
                    dp[i][check.get(u)].value=dp[i-1][check.get(u)].value;
                    dp[i][check.get(u)].prev=dp[i-1][check.get(u)].prev;
                    dp[i][check.get(u)].use=dp[i-1][check.get(u)].use;
                }
                store.add(check.get(u));
                
                int temp = check.get(u)|inp[i];
                int times = dp[i-1][check.get(u)].value+1;
                if (dp[i][temp].value==10000){
                    store.add(temp);
                }
                if (dp[i][temp].value>times){
                    dp[i][temp].value=times;
                    dp[i][temp].prev=check.get(u);
                    dp[i][temp].use=true;
                }
            }
            print(dp);
        }
        if (dp[m][result].value==0){
            System.out.print(1);
        }else{
            System.out.println(dp[m][result]);
        }
        
        int prev = result;
        int count = m;
        while (prev!=-1){
            if (dp[count][result].use){
                System.out.print(count);
            }
            prev = dp[count][prev].prev;
            count -=1;
        }
        
    }
}

class dp{
    int value, prev;
    boolean use;
    public dp(int v, int p, boolean bool){
        value = v;
        prev = p;
        use = bool;
    }
    
    public String toString(){
        return value+" "+prev+" "+use+" ";
    }
}


class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
          this.stream = stream;
    }
    public int read() {
        if (numChars == -1) throw new InputMismatchException();
    if (curChar >= numChars) {
        curChar = 0;
            try {
                numChars = stream.read(buf);
            } 
            catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) return -1;
    }
    return buf[curChar++];
    }
 
    public int readInt() {
    int c = read();
    while (isSpaceChar(c)) c = read();
    int sgn = 1;
    if (c == '-') {
            sgn = -1;
            c = read();
    }
    int res = 0;
    do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
    }
    public String readString() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        StringBuilder res = new StringBuilder();
    do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
    public boolean isSpaceChar(int c) {
        if (filter != null) return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    public String next() {
        return readString();
    }
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
