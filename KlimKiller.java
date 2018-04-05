
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class KlimKiller implements KeyListener {

	String[] names = { "клим", "илья", "вася", "андрей", "гриша", "никита", "денис", "дима", "глеб", "антон", "валера",
			"котик", "зайка", "жираф", "путин", "вова" };

	JFrame f = new JFrame(names[ThreadLocalRandom.current().nextInt(names.length)] + " пидор");
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	int width = ThreadLocalRandom.current().nextInt(dimension.width++);
	int height = ThreadLocalRandom.current().nextInt(dimension.height++);

	static Timer timer = new Timer(50, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new KlimKiller();
			System.gc();
		}
	});

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

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
