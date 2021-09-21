import java.util.LinkedList;
import java.util.Queue;

public class Melody
{
	private Queue<Note> notes;

	/**
	 * Overloaded constructor that sets notes equal to actual values
	 * 
	 * @param song
	 */
	public Melody(Queue<Note> song)
	{
		notes = song;
	}

	/**
	 * Returns the total duration of the song by calling the .getDuration() method
	 * for each note and doubling it for repeated sections of the song
	 * 
	 * @return total duration of the song including repeats
	 */
	public double getTotalDuration()
	{
		double total = 0.0;
		int size = notes.size();
		boolean repeat = false;
		while (size > 0)
		{
			Note note = notes.remove();

			if (note.isRepeat())
			{
				if (!repeat)
				{
					repeat = true;
				} else
				{
					repeat = false;
				}
				total += 2 * note.getDuration();
			} else if (repeat)
			{
				total += 2 * note.getDuration();
			} else
			{
				total += note.getDuration();
			}
			size--;
			notes.add(note);
		}
		return total;
	}

	/**
	 * Iterates through the queue of notes with a for loop and sets the duration of
	 * each note using the .setDuration() method to the parameter times the current
	 * tempo
	 * 
	 * @param tempo
	 */
	public void changeTempo(double tempo)
	{
		int size = notes.size();

		for (int i = 0; i < size; i++)
		{
			Note note = notes.remove();
			note.setDuration(tempo * note.getDuration());
			notes.add(note);
		}

	}

	/**
	 * Uses recursion to reverse the song removes all the notes then adds them in a
	 * recursive way so its backwards since the most recent call of reverse() will
	 * have the last note, it gets added first therefore the song will be reversed
	 * exit is when the queue is empty otherwise we would not stop removing
	 */
	public void reverse()
	{
		if (notes.isEmpty())
		{
			return;
		} else
		{
			Note note = notes.remove();
			reverse();
			notes.add(note);
		}

	}

	/**
	 * single call to return our variable notes
	 * 
	 * @return all the notes of the song
	 */
	public Queue<Note> getNotes()
	{
		return notes;
	}

	/**
	 * adds every note from melody other to our current melody to make one song
	 * 
	 * @param other
	 */
	public void append(Melody other)
	{
		while (!other.getNotes().isEmpty())
		{
			notes.add(other.getNotes().remove());
		}

	}

	/**
	 * calls the play() method from StdAudio for every note in the song. Whenever a
	 * repeated section comes up we store it in a temp queue and then whenever the
	 * next repeated section comes up we replay the temp queue
	 */
	public void play()
	{
		Queue<Note> temp = new LinkedList<Note>();
		int size = notes.size();
		boolean repeat = false;
		int counter = 0;
		for (int i = 0; i < size; i++)
		{
			Note note = notes.remove();

			if (note.isRepeat())
			{
				temp.add(note);// adds first repeat and next repeat
				repeat = true;
				note.play();
				counter++;
				if (counter % 2 == 0)// every time counter is even # we know to play() the temp queue
				{
					System.out.println(temp);
					int size2 = temp.size();
					for (int j = 0; j < size2; j++)
					{
						temp.remove().play();
						//System.out.println(temp); used to debug the second queue
					}

					//System.out.println(temp);

					repeat = false;// makes sure we don't repeat forever
				}
			} else if (repeat && !note.isRepeat())
			{
				note.play();
				temp.add(note);// adds the notes in between the repeat section

			} else
			{
				note.play();// plays normal notes
			}
			notes.add(note);
		}
	}

	@Override
	public String toString()
	{
		String output = "";
		int size = notes.size();
		for (int i = 0; i < size; i++)
		{
			Note note = notes.remove();
			output += note.toString();
			output += "\n";
			notes.add(note);
		}
		return output;
	}
}
