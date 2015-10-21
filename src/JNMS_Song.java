import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.jfugue.theory.ChordProgression;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import java.io.File;
import java.io.IOException;

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
		String preludeV0 = "" +
				"V0 I[String_Ensemble_1] " +
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
		String preludeV1 = "" +
				"V1 I[Whistle] " +
				"0s. 0s. 0s. 0i. 0s | " +				// 3 1 3 5 5
				"0w | " +								// 5
				"0i 0i 0i 0i. 0s | " +					// 2 7 2 5 5
				"0i 0i 0i 0i | " +						// 5 2 3 4
				"0i 0 0i | " +							// 5 5 3
				"0s. 0s. 0s. 0 | " +					// 1 5 1 3
				"0i 0 0i | " +							// 5 5 3
				"0s. 0s. 0s. 0 | " +					// 1 5 1 3
				"0i. 0s 0i 0s 0s | " +					// 1 1 6 4 6
				"0i 0 0i | " +							// 5 5 2
				"0i 0i 0i 0i | " +						// 7 5 7 2
				"0 0 | ";								// 1 0
		String part1V0 = "I[Voice] " +
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
		String part1V1 = "" +
				//"V9 L0 Rs [BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Ri Rs [BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Rs [HAND_CLAP]s Rs [BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Ri Rs [BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Rs [HAND_CLAP]s L1" +
				"[BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Rs [HAND_CLAP]s Rs | " +							// 5 3
				"[BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Ri Rs | " +								// 6 5
				"[BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Rs [HAND_CLAP]s Rs | " +							// 1 2
				"[BASS_DRUM]s Ri Rs [ACOUSTIC_SNARE]s Ri Rs | " +								// 1 5
				"| " +									// Sentence break
				"0 0i 0i | " +							// 6 6 7
				"0 0i 0i | " +							// 1 7 6
				"0 0 | " +								// 5 3
				"0w | " +								// 2
				"| " +									// Sentence break
				"0i. 0s 0i 0i | " +						// 5 5 5 3
				"0 0 | " +								// 6 5
				"| " +									// Sentence break
				"0i. 0s 0i 0i | " +						// 1 1 1 2
				"0 0 | " +								// 1 5
				"| "  +									// Sentence break
				"0i 0i 0 | " +							// 6 6
				"0i 0i 0 | " +							// 4 4
				"| " +									// Sentence break
				"0i 0i 0i 0i | " +						// 6 6 6 5
				"| " +									// Sentence break
				"0i 0i 0i 0i | " +						// 4 4 3 2
				"0i 0i 0i 0i | " +						// 3 3 4 0
				"0q ";									// 5
		String part2treble = "" +
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
		String part2bass = "" +
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
		String part2beat = "" +
				"[CRASH_CYMBAL_1] | " +								// 1
				"[CRASH_CYMBAL_1]w | " +								// 4
				"[CRASH_CYMBAL_1]q [CRASH_CYMBAL_1]i. [CRASH_CYMBAL_1]s | " +						// 4 2 4
				"[CRASH_CYMBAL_1]w | " +								// 3
				"| " +									// Sentence break
				"[CRASH_CYMBAL_1] [CRASH_CYMBAL_1] | " +								// 3 5
				"[CRASH_CYMBAL_1]w | " +								// 1
				"[CRASH_CYMBAL_1] [CRASH_CYMBAL_1]i. [CRASH_CYMBAL_1]s | " +						// 1 6 1
				"[CRASH_CYMBAL_1] [CRASH_CYMBAL_1] | " +								// 7 6
				"| " +									// Sentence break
				"[CRASH_CYMBAL_1] [CRASH_CYMBAL_1] | " +								// 5 0
				"[CRASH_CYMBAL_1]i. [CRASH_CYMBAL_1]s [CRASH_CYMBAL_1]i [CRASH_CYMBAL_1]i | " +					// 1 1 1 7
				"[CRASH_CYMBAL_1] [CRASH_CYMBAL_1] | " +								// 6 6
				"| " +									// Sentence break
				"[CRASH_CYMBAL_1]i. [CRASH_CYMBAL_1]s [CRASH_CYMBAL_1]i [CRASH_CYMBAL_1]i | " +					// 3 3 3 2
				"[CRASH_CYMBAL_1] [CRASH_CYMBAL_1] | " +								// 1 7
				"| " +									// Sentence break
				"[CRASH_CYMBAL_1]i [CRASH_CYMBAL_1]i [CRASH_CYMBAL_1]i [CRASH_CYMBAL_1]i | " +						// 6 6 5 4
				"[CRASH_CYMBAL_1]q. [CRASH_CYMBAL_1]i | " +							// 6 1
				"[CRASH_CYMBAL_1]q. [CRASH_CYMBAL_1]i | " +							// 3 2
				"[CRASH_CYMBAL_1]i [CRASH_CYMBAL_1]i [CRASH_CYMBAL_1] | " +						// 1 1 7
				"[CRASH_CYMBAL_1] [CRASH_CYMBAL_1] | ";								// 1 0
		/*String interlude = prelude;
		String postlude = "";

		Pattern pPrelude = new Pattern(prelude).add(preludeV1);

		Pattern pPart1 = new Pattern(part1).add(part1V1);

		Pattern pPart2treble = new Pattern(part2treble);
		Pattern pPart2bass = new Pattern(part2bass);
		Pattern pPart2 = pPart2treble.add(pPart2bass);

		Pattern pInterlude = new Pattern(interlude);
		Pattern pPostlude = new Pattern(postlude);



		Pattern main = pPart1.add(pPart2);

		Pattern full = pPrelude.add(main).add(pInterlude).add(main).add(pPostlude);*/
		//String full = prelude + part1 + part2treble;

		/*try
		{
			File fs = new File("gen");
			if (fs.mkdir())
			{
				File f = new File("gen/JNMS_Song.mid");
				MidiFileManager.savePatternToMidi(new Pattern(preludeV0 + part1V0 + part2treble + preludeV1 + part1V1 + part2bass), f);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}*/
		Player p = new Player();
		//p.play(preludeV0 + part1V0 + part2treble + preludeV1 + part1V1 + part2bass);
		Pattern pPart2bass = new Pattern(part2bass).addToEachNoteElement("a40");

		p.play(new Pattern(part1V0).addTrack(9, new Pattern(part1V1)));
		//p.play(new Pattern(part2treble).addTrack(1, pPart2bass).addTrack(2, new Pattern(part2beat)));
		//p.play(preludeV0 + preludeV1);

		/*Rhythm rhythm = new Rhythm()
				.addLayer("o.s.o.sxo.s.o.sx")
				.addLayer("");
		//new Player().play(new ChordProgression("I IV vi V").eachChordAs("$_i $_i Ri $_i"), new Rhythm().addLayer("..X...X...X...XO"));*/
	}
}
