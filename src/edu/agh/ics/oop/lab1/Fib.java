package edu.agh.ics.oop.lab1;

public class Fib
{
    public static void main(String[] args) {
        try {
            int x = Integer.parseInt(args[0]);
            FibRunnable f = new FibRunnable(x);
            Thread t = new Thread(f);
            t.start();
            t.join();
            System.out.println(f.answer);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
