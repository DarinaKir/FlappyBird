import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {

    private Bird bird;
    private boolean start;

    public Movement (Bird bird) {
        this.bird = bird;
        this.start = false;
    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE && this.bird.isAlive()) {
            this.start = true;
            new Thread(() -> {
                for (int i = 0; i < 60; i++) {
                    this.bird.moveUp();
                    try {
                        Thread.sleep(MainScene.MOVE_TIME_LOOP/2);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }).start();
        }
    }


    public void keyReleased(KeyEvent e) {
//        int keyCode = e.getKeyCode();
//        if (keyCode == KeyEvent.VK_SPACE) {
//            this.bird.moveUp();
//        }
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}