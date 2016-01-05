package de.dtonal.bundessprech.data;

public enum Gender {
	MALE, FEMALE, UNKNOWN;

	public static Gender fromString(String string) {

		if (string.equals("Weiblich")) {
			return FEMALE;
		}
		if (string.equals("Männlich")) {
			return MALE;
		}

		if(string.equals(""))
		{
			return UNKNOWN;
		}
		System.out.println("Gender: Can't find Gender from string: '" + string + "'");
		return UNKNOWN;
	}
}
