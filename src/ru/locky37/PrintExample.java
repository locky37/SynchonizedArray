package ru.locky37;

public class PrintExample extends Thread {
    private int s;

    PrintExample(int num) {
        this.s = num;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        System.out.println(Thread.currentThread().getName());
    }
}

