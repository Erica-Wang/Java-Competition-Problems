/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz18;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

/**
 *
 * @author ericawang
 */
public class truckingTroubles {
    
    static ArrayList<Integer> [] p;
    static int [] pp;
    static int [] des;
    
    public static void print (ArrayList<Integer>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    
    static int find (int x) {
        if (x!=pp[x]) {
            pp[x] = find(pp[x]);
        }
        return pp[x];
    }
    
    public static boolean done (){
        for(int i = 1; i<des.length; i++){
            if(find(des[i-1])!=find(des[i])){
                return false;
            }
        }
        return true;
    }
    
    public static void merge (int x, int y){
        int fx = find(x);
        int fy = find(y);
        if (fx!=fy){
            if (p[fx].size()>p[fy].size()){
                for(int i = 0; i<p[fy].size();i++){
                    int cur = p[fy].get(i);
                    p[fx].add(cur);
                    pp[cur]=fx;
                }
                p[fy].clear();
            }else{
                int l = p[fx].size();
                for(int i = 0; i<l;i++){
                    int cur = p[fx].get(i);
                    p[fy].add(cur);
                    pp[cur]=fy;

                }
                p[fx].clear();
            }
        }
    }
    
    public static void main (String []args){
        
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        
        int n = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        p = new ArrayList [n+1];
        pp = new int [n+1];
        
        for(int i = 0; i<=n; i++){
            p[i]=new ArrayList();
        }
        
        ArrayList<edge> routes = new ArrayList();
        for(int i = 0; i<m; i++){
            routes.add(new edge(in.readInt(),in.readInt(),in.readInt()));
        }
        
        Collections.sort(routes);
        for(int i = 1; i<=n;i++){
            p[i].add(i);
            pp[i]=i;
        } 
        
        des = new int [d];
        for(int i = 0; i<d; i++){
            des[i]=in.readInt();
        }
        for(int num = m-1; num>=0; num--){
            edge e = routes.get(num);
            merge(e.u,e.v);
            if(done()){
                System.out.println(e.w);
                break;
            }
            
            
        }
        
    }
    static class edge implements Comparable<edge> {
        int u,v,w;
        edge (int a, int b, int c){
            u = a;
            v = b;
            w = c;
        }
        
        @Override
        public int compareTo(edge x){
            return this.w-x.w;
        }
        
        @Override
        public String toString(){
            return this.u+" "+this.v+" "+this.w;
        }
    }
}

class Access {
    public static void main (String [] args){
        InputReader input = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t = input.readInt();
        out.println(t);
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

class OutputWriter {
    private final PrintWriter writer;
    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }
    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }
    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }
    public void println(Object...objects) {
        print(objects);
        writer.println();
    }
    public void close() {
        writer.close();
    }
    public void flush() {
        writer.flush();
    }
}

