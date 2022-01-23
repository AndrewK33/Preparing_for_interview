package Lesson_3.Exercise_one;

public class PingPongGame {
    private final Object mon = new Object();
    private String gameQueue = "ping";

    public static void main(String[] args) {
        PingPongGame pingPongGame = new PingPongGame();
        new Thread(pingPongGame::printPing).start();
        new Thread(pingPongGame::printPong).start();

    }

    private void printPing() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!gameQueue.equals("ping")) {
                        mon.wait();
                    }
                    System.out.println("ping");
                    gameQueue = "pong";
                    mon.notifyAll();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printPong() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!gameQueue.equals("pong")) {
                        mon.wait();
                    }
                    System.out.println("pong");
                    gameQueue = "ping";
                    mon.notifyAll();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
