import org.jfugue.player.Player;

public class JNMS_Song
{
	/*
	 * 1 C
	 * 2 D
	 * 3 E
	 * 4 F
	 * 5 G
	 * 6 A
	 * 7 B
	 *
	 * _ i
	 * __ s
	 */
	public static void main(String[] args)
	{
		String prelude = "E6s. C6s. E6s. G6i. G6s | " +
				"G6w | " +
				"D6i Bi D6i Gi. Gs | " +
				"Gi D6i E6i F6i | " +
				"G6i G6 E6i | " +
				"C6s. Gs. C6s. E6 | " +
				"G6i G6 E6i | " +
				"C6s. Gs. C6s. E6 | " +
				"C6i. C6s Ai Fs As | " +
				"Gi G Di | " +
				"Bi Gi Bi D6i | " +
				"C6 0 | ";
		String part1 = "Gq. Ei | " +
				"A G | " +
				"C6q. D6i | " +
				"C6 G | " +
				"| " +
				"A Ai Bi | " +
				"C6 Bi Ai | " +
				"G E6 D6w | " +
				"| " +
				"Gi. Gs Gi Ei | " +
				"A G | " +
				"C6i. C6s C6i D6i | " +
				"C6 G | " +
				"Ai Ai 0 | " +
				"F6i F6i 0 | " +
				"A6i A6i A6i G6i | " +
				"F6i F6i E6i D6i | " +
				"E6i E6i F6i 0i | " +
				"G6q ";
		String part2treble = "C6 | " +
				"A6w | " +
				"A6q F6i. A6s | " +
				"G6w | " +
				"G6 G | " +
				"E6w | " +
				"E6 C6i. E6s | " +
				"D6w | " +
				"D6 0 | " +
				"E6i. E6s E6i D6i | " +
				"C6 A | " +
				"G6i. G6s G6i F6i | " +
				"E6 D6 | " +
				"C6i C6i Bi Ai | " +
				"D6q. E6i | " +
				"G6q. F6i | " +
				"E6i E6i D6 | " +
				"C6 0 | ";
		String part2bass = "";
		String interlude = "";
		String postlude = "";
		Player p = new Player();
		p.play(prelude + part1 + part2treble/* + part2bass + interlude + part1 + part2treble + part2bass + postlude*/);
	}
}
