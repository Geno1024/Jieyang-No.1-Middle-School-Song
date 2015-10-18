import org.jfugue.pattern.Pattern;
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
		String prelude = "V0 I[String_Ensemble_1] " +
				"E6s. C6s. E6s. G6i. G6s | " +			// 3 1 3 5 5
				"G6w | " +								// 5
				"D6i Bi D6i Gi. Gs | " +				// 2 7 2 5 5
				"Gi D6i E6i F6i | " +					// 5 2 3 4
				"G6i G6 E6i | " +						// 5 5 3
				"C6s. Gs. C6s. E6 | " +					// 1 5 1 3
				"G6i G6 E6i | " +						// 5 5 3
				"C6s. Gs. C6s. E6 | " +					// 1 5 1 3
				"C6i. C6s Ai Fs As | " +				// 1 1 6 4 6
				"Gi G Di | " +							// 5 5 2
				"Bi Gi Bi D6i | " +						// 7 5 7 2
				"C6 0 | ";								// 1 0
		String part1 = "I[Acoustic_Bass] " +
				"Gq. Ei | " +							// 5 3
				"A G | " +								// 6 5
				"C6q. D6i | " +							// 1 2
				"C6 G | " +								// 1 5
				"| " +									// Sentence break
				"A Ai Bi | " +							// 6 6 7
				"C6 Bi Ai | " +							// 1 7 6
				"G E6 | " +								// 5 3
				"D6w | " +								// 2
				"| " +									// Sentence break
				"Gi. Gs Gi Ei | " +						// 5 5 5 3
				"A G | " +								// 6 5
				"| " +									// Sentence break
				"C6i. C6s C6i D6i | " +					// 1 1 1 2
				"C6 G | " +								// 1 5
				"| "  +									// Sentence break
				"Ai Ai 0 | " +							// 6 6
				"F6i F6i 0 | " +						// 4 4
				"| " +									// Sentence break
				"A6i A6i A6i G6i | " +					// 6 6 6 5
				"| " +									// Sentence break
				"F6i F6i E6i D6i | " +					// 4 4 3 2
				"E6i E6i F6i 0i | " +					// 3 3 4 0
				"G6q ";									// 5
		String part2treble = "V0 " +
				"C6 | " +								// 1
				"A6w | " +								// 6
				"A6q F6i. A6s | " +						// 6 4 6
				"G6w | " +								// 5
				"| " +									// Sentence break
				"G6 G | " +								// 5 5
				"E6w | " +								// 3
				"E6 C6i. E6s | " +						// 3 1 3
				"D6w | " +								// 2
				"| " +									// Sentence break
				"D6 0 | " +								// 2 0
				"E6i. E6s E6i D6i | " +					// 3 3 3 2
				"C6 A | " +								// 1 6
				"| " +									// Sentence break
				"G6i. G6s G6i F6i | " +					// 5 5 5 4
				"E6 D6 | " +							// 3 2
				"| " +									// Sentence break
				"C6i C6i Bi Ai | " +					// 1 1 7 6
				"D6q. E6i | " +							// 2 3
				"G6q. F6i | " +							// 5 4
				"E6i E6i D6 | " +						// 3 3 2
				"C6 0 | ";								// 1 0
		String part2bass = "V1 " +
				"C6 | " +								// 1
				"F6w | " +								// 4
				"F6q D6i. F6s | " +						// 4 2 4
				"E6w | " +								// 3
				"| " +									// Sentence break
				"E6 G | " +								// 3 5
				"C6w | " +								// 1
				"C6 Ai. C6s | " +						// 1 6 1
				"B A | " +								// 7 6
				"| " +									// Sentence break
				"G 0 | " +								// 5 0
				"C6i. C6s C6i Bi | " +					// 1 1 1 7
				"A A | " +								// 6 6
				"| " +									// Sentence break
				"E6i. E6s E6i D6i | " +					// 3 3 3 2
				"C6 B | " +								// 1 7
				"| " +									// Sentence break
				"Ai Ai Gi Fi | " +						// 6 6 5 4
				"Aq. C6i | " +							// 6 1
				"E6q. D6i | " +							// 3 2
				"C6i C6i B | " +						// 1 1 7
				"C6 0 | ";								// 1 0
		String interlude = prelude;
		String postlude = "";

		Pattern pPrelude = new Pattern(prelude);
		Pattern pPart1 = new Pattern(part1);
		Pattern pPart2treble = new Pattern(part2treble);
		Pattern pPart2bass = new Pattern(part2bass);
		Pattern pInterlude = new Pattern(interlude);
		Pattern pPostlude = new Pattern(postlude);

		Pattern pPart2 = pPart2treble.add(pPart2bass);

		//Pattern main = pPart1.add(pPart2);

		//Pattern full = pPrelude.add(main).add(pInterlude).add(main).add(pPostlude);

		Player p = new Player();
		p.play(pPart1);
	}
}
