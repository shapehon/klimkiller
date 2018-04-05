import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.Timer;

public class KlimKiller {

	String[] names = { "клим", "илья", "вася", "андрей", "гриша", "никита", "денис", "дима", "глеб", "антон" };

	JFrame f = new JFrame(names[ThreadLocalRandom.current().nextInt(names.length)] + " пидор");
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	public KlimKiller() {
		int width = ThreadLocalRandom.current().nextInt(dimension.width++);
		int height = ThreadLocalRandom.current().nextInt(dimension.height++);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.getContentPane().setBackground(new Color(ThreadLocalRandom.current().nextInt(256),
				ThreadLocalRandom.current().nextInt(256), ThreadLocalRandom.current().nextInt(256)));
		f.setVisible(true);
		f.setResizable(false);
		f.setBounds((dimension.width / 2) - width / 2, (dimension.height / 2) - height / 2, width, height);
	}

	public static void main(String[] args) {
		new KlimKiller();
		Timer timer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new KlimKiller();
				System.gc();
			}
		});
		timer.start();
	}

}