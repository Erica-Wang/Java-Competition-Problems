/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class6;
import java.util.*;
import java.io.*;
/**
 *
 * @author EricaWang
 */
public class Troyangles {

    /**
     * @param args the command line arguments
     */
    
        static Stack<Integer> xv = new Stack();
    static Stack<Integer> yv = new Stack();
    
 
    public static int func(boolean [][] board,int n){
        int count = 0;
        n = n+1;
        
        Stack <Integer> x = (Stack<Integer>) xv.clone();
        Stack <Integer> y = (Stack<Integer>) yv.clone();
        xv.clear();
        yv.clear();
        
        while(!x.isEmpty()){
            int i = x.peek();
            x.pop();
            int u = y.peek();
            y.pop();
            if(i>=(n-1)&&i<board.length&&u>=0&&u<=(board.length-1)-2*(n-1)){
            boolean bool = true;
            for(int j = i;j>i-n;j--){
                int begin = u +(i-j);
                int end = u+2*n-1-(i-j);
                for(int k = begin;k<end;k++){    
                    if(!board[j][k]){
                        bool = false;
                    }
                }
            }
            
            if(bool){
                count++;
                xv.push(i);
                yv.push(u);
            }
            }
        }
        return count;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
//        Scanner input = new Scanner (System.in);
        InputReader input = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = input.readInt();
        boolean [][] board = new boolean [n][n];
        for(int i = 0; i<n; i++){
            String S = input.readString();
            for(int u = 0; u<n; u++){
                String s = S.substring(u,u+1);
                if(s.equals("#")){
                    board[i][u]=true;
                    xv.add(i);
                    yv.add(u);
                }
            }
        }
        
        int total = 0;
        for(int NUM = 0; NUM<n;NUM++){
            
            int cur = func(board,NUM);
            total+=cur;
            
        }
        System.out.println(total);;
        
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


/*
public class whatever{
    public static void main (String [] args) {
        InputReader input = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t = input.readInt();
        out.printLine(t);
    }
}
*/