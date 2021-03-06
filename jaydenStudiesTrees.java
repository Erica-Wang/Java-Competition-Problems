/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz31;
import java.util.*;
import java.io.*;
/**
 *
 * @author moyangwang
 */
public class jaydenStudiesTrees {
    public static int findMax(int [] arr){
        int max = arr[1];
        int pos = 1;
        for(int i = 2; i<arr.length;i++){
            if(arr[i]!=1000000&&arr[i]>max){
                max = arr[i];
                pos = i;
            }
        }
        return pos;
    }
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[]args){
        InputReader input = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = input.readInt();
        ArrayList<Integer> [] in = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            in[i]=new ArrayList();
        }
        for(int i = 1; i<n; i++){
            int a = input.readInt();
            int b = input.readInt();
            in[a].add(b);
            in[b].add(a);
        }
        
        int [] dis = new int [n+1];
        int curLoc = 1;
        for(int num = 0; num<2; num++){
            for(int i = 1; i<=n; i++){
                dis[i]=-1;
            }
            dis[curLoc]=0;
            Queue<Integer> loc = new LinkedList();
            loc.add(curLoc);
            while(!loc.isEmpty()){
                int cur = loc.poll();
                for(int i = 0; i<in[cur].size(); i++){
                    int pos = in[cur].get(i);
                    if(dis[pos]==-1){
                        dis[pos]=dis[cur]+1;
                        loc.add(pos);
                    }
                }
            }
            curLoc = findMax(dis);
        }
        System.out.println(dis[curLoc]);
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

