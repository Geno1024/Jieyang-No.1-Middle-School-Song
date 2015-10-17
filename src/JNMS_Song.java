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
		String prelude = "E6s. C6s. E6s. G6i. G6s " +
				"G6w " +
				"D6i Bi D6i Gi. Gs " +
				"Gi D6i E6i F6i " +
				"G6i G6 E6i " +
				"C6s. Gs. C6s. E6 " +
				"G6i G6 E6i " +
				"C6s. Gs. C6s. E6 " +
				"C6i. C6s Ai Fs As " +
				"Gi G Di " +
				"Bi Gi Bi D6i " +
				"C6 0";
		String part1 = "G. Ei " +
				"A G " +
				"C6. D6i " +
				"C6 G " +
				"" +
				"A Ai Bi " +
				"C6 Bi Ai " +
				"G E6 D6w ";
		String part2bass = "";
		String part2treble = "";
		String interlude = "";
		String postlude = "";
		Player p = new Player();
		p.play(/*prelude + */part1/* + part2bass + part2treble + interlude + part1 + part2bass + part2treble + postlude*/);
	}
}
