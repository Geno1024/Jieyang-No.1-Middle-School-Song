import org.jfugue.midi.MidiDictionary;
import org.jfugue.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;*/

public class Test extends JFrame
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame("InstTest");
		f.setSize(1280, 512);
		f.setLocation(300, 0);
		f.setLayout(new FlowLayout());
		final Player p = new Player();
		for (int i = 0; i < 128; i++)
		{
			final JButton b = new JButton(i + ". " + MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(Byte.parseByte(i + "")));
			b.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent actionEvent)
				{
					p.play("V0 I[" + MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(Byte.parseByte(b.getText().split("\\.")[0])) + "] D6h | ");
					System.out.println(MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(Byte.parseByte(b.getText().split("\\.")[0])));
				}
			});
			f.add(b);
		}
		f.setVisible(true);
		/*Frame f = new Frame("InstTest");
		f.setSize(500,1000);
		f.setLocation(300,0);
		f.setLayout(new FlowLayout());
		f.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		final Player p = new Player();
		for (int i = 0; i < 128; i++)
		{
			final Button b = new Button(i + ". " + MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(Byte.parseByte(i + "")));
			b.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent actionEvent)
				{
					p.play("V0 I[" + MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(Byte.parseByte(b.getLabel().split("\\.")[0])) + "] C5");
				}
			});
			f.add(b);
		}
		f.setVisible(true);
*/

	}
}
