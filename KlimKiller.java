import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

public class KlimKiller implements KeyListener {

	static Timer timer = new Timer(50, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new KlimKiller();
			int key = ThreadLocalRandom.current().nextInt(7);
			if (r > 255 - n) {
				r /= 2;
			}
			if (g > 255 - n) {
				g /= 2;
			}
			if (b > 255 - n) {
				b /= 2;
			}
			switch (key) {
			case 0:
				r += n;
				g += n;
				b += n;
				break;

			case 1:
				r += n;
				g += n;
				if (b - n < 0) {
					b += n;
				} else {
					b -= n;
				}
				break;
			case 2:
				r += n;

				if (g - n < 0) {
					g += n;
				} else {
					g -= n;
				}

				if (b - n < 0) {
					b += n;
				} else {
					b -= n;
				}
				break;
			case 3:
				if (r - n < 0) {
					r += n;
				} else {
					r -= n;
				}

				if (g - n < 0) {
					g += n;
				} else {
					g -= n;
				}

				if (b - n < 0) {
					b += n;
				} else {
					b -= n;
				}
				break;
			case 4:
				if (r - n < 0) {
					r += n;
				} else {
					r -= n;
				}

				g += n;
				b += n;
				break;
			case 5:
				r += n;
				if (g - n < 0) {
					g += n;
				} else {
					g -= n;
				}

				b += n;
				break;
			case 6:
				if (r - n < 0) {
					r += n;
				} else {
					r -= n;
				}
				g += n;
				if (b - n < 0) {
					b += n;
				} else {
					b -= n;
				}
				break;

			default:
				break;
			}

		}
	});
	String[] names = { "клим", "илья", "вася", "андрей", "гриша", "никита", "денис", "дима", "глеб", "антон", "валера",
			"котик", "зайка", "жираф", "путин", "вова" };
	// создание jframe с случайным тайтлом
	JFrame f = new JFrame(names[ThreadLocalRandom.current().nextInt(names.length)] + " пидор");
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	// случайная длина и ширина по экрану
	int width = ThreadLocalRandom.current().nextInt(dimension.width++);
	int height = ThreadLocalRandom.current().nextInt(dimension.height++);
	// динамичность изменения цвета
	static int n = 3;
	static int r;
	static int g;
	static int b;

	// само окно
	public KlimKiller() {
		f.addKeyListener(this);
		f.getContentPane().setBackground(new Color(r, g, b));
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
