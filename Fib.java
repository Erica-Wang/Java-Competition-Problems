/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class1;

/**
 *
 * @author EricaWang
 */
public class Fib {

    /**
     * @param args the command line arguments
     */
    static int [] f=new int [1000];
    public static int fib(int n){
        System.out.println("a");
        if(f[n]!=0)
            return f[n];
        if (n<=2){
            return f[n]=1;
        }else{
            return f[n]=fib(n-1)+fib(n-1);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(fib(50));
    }
    
}
