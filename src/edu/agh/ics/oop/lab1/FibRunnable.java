package edu.agh.ics.oop.lab1;

public class FibRunnable implements Runnable
{
    private int x;
    int answer;

    FibRunnable(int x) {
        this.x = x;
    }

    public void run() {
        if (x <= 2) {
            answer = 1;
        } else {
            try {
                FibRunnable f1 = new FibRunnable(x - 1);
                FibRunnable f2 = new FibRunnable(x - 2);
                Thread t1 = new Thread(f1);
                Thread t2 = new Thread(f2);
                t1.start();
                t2.start();
                t1.join();
                t2.join();
                answer = f1.answer + f2.answer;
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
