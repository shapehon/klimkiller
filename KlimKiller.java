import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

public class KlimKiller implements KeyListener {

    static Timer timer = new Timer(50, e -> new KlimKiller());
    String[] names = {"клим", "илья", "вася", "андрей", "гриша", "никита", "денис", "дима", "глеб", "антон", "валера",
            "котик", "зайка", "жираф", "путин", "вова"};
    //создание jframe с случайным тайтлом
    JFrame f = new JFrame(names[ThreadLocalRandom.current().nextInt(names.length)] + " пидор");
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    //случайная длина и ширина по экрану
    int width = ThreadLocalRandom.current().nextInt(dimension.width++);
    int height = ThreadLocalRandom.current().nextInt(dimension.height++);

    //само окно
    public KlimKiller() {
        f.addKeyListener(this);
        f.getContentPane().setBackground(new Color(ThreadLocalRandom.current().nextInt(256),
                ThreadLocalRandom.current().nextInt(256), ThreadLocalRandom.current().nextInt(256)));
        f.setBounds((dimension.width / 2) - width / 2, (dimension.height / 2) - height / 2, width, height);
        f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new KlimKiller();
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_R):
                System.exit(0);
                break;
            case (KeyEvent.VK_I):
                timer.stop();
                break;
            case (KeyEvent.VK_P):
                timer.start();
                break;
            case (KeyEvent.VK_K):
                new KlimKiller();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
