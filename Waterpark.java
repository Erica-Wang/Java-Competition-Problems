/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class8;
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
 * @author EricaWang
 */
public class Waterpark {

    /**
     * @param args the command line arguments
     */
    static ArrayList <Integer> myA;
    static ArrayList <Integer> tempA;
    public static void print1D(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int findIn(int a, ArrayList <Integer> list){
        for(int i = list.size()-1; i>=0; i--){
            if(list.get(i)<a){
                return i+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        InputReader input = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        
        int checkPts = input.readInt();
        int begin = input.readInt();
        int end = input.readInt();
        //boolean [][] board = new boolean [checkPts+1][checkPts+1];
        ArrayList<Integer>[] board = new ArrayList[checkPts+1];
        for(int i = 1; i<checkPts+1; i++){
            board[i] = new ArrayList();
        }
        
        while(begin!=0&&end!=0){
            int index = findIn(end, board[begin]);
            board[begin].add(index,end);
            begin = input.readInt();
            end = input.readInt();
        }
        
        int [] result = new int [checkPts+1];
        result[1]=1;
        for(int i = 1; i<=checkPts; i++){
            int index = 0;
            if(!board[i].isEmpty()){
                for(int u = i+1; u<=checkPts; u++){
                    if(board[i].get(index)==u){
                        result[u]+=result[i];
                        index++;
                    }
                }
            }
        }
        System.out.println(result[checkPts]);
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
