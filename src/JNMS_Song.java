import org.jfugue.player.Player;

public class JNMS_Song
{
	public static void main(String[] args)
	{
		String prelude = "";
		String part1 = "";
		String part2bass = "";
		String part2treble = "";
		String interlude = "";
		String postlude = "";
		Player p = new Player();
		p.play(prelude + part1 + part2bass + part2treble + interlude + part1 + part2bass + part2treble + postlude);
	}
}
