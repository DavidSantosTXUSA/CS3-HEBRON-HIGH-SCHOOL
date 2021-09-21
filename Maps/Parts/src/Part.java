public class Part implements Comparable<Part>
{
	private String make, mode, rest;
	private int year;

	public Part(String line)
	{
		year = 0;
		make = "";
		mode = "";
		rest = "";// did not know what to do with this ??
		String[] list = line.split(" ");
		String temp = list[0];
		int count = 0;
		while (!temp.contains("1") && !temp.contains("2") && !temp.contains("3") && !temp.contains("4")
				&& !temp.contains("5") && !temp.contains("6") && !temp.contains("7") && !temp.contains("8")
				&& !temp.contains("9"))// checks if temp contains numbers
		{
			mode += temp + " ";
			count++;
			temp = list[count];
		}
		mode += temp;
		temp = list[count + 1];// go one more over since temp contains numbers as it was the exit conditon for
								// our while loop
		while (!temp.contains("1") && !temp.contains("2") && !temp.contains("3") && !temp.contains("4")
				&& !temp.contains("5") && !temp.contains("6") && !temp.contains("7") && !temp.contains("8")
				&& !temp.contains("9"))// checks if temp contains numbers
		{
			make += temp + " ";
			count++;
			temp = list[count];

		}
		year = Integer.parseInt(list[list.length - 1]);// end will always be the year

	}

	/**
	 * compareTo method that compares by make first model second, then lastly year.
	 */
	public int compareTo(Part rhs)
	{

		/*
		 * Order is make, model, year
		 */
		if (make.compareTo(rhs.make) > 0)
		{
			return 1;
		} else if (make.compareTo(rhs.make) < 0)
		{
			return -1;
		}
		if (mode.compareTo(rhs.mode) > 0)
		{
			return 1;
		} else if (mode.compareTo(rhs.mode) < 0)
		{
			return 1;
		}
		if (year > rhs.year)
		{
			return 1;
		} else if (year < rhs.year)
		{
			return -1;
		}

		return 0;
	}

	public String toString()
	{
		return make + year + " " + mode;
	}
}