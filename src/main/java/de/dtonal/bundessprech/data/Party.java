package de.dtonal.bundessprech.data;

public enum Party {
	CDU,
	CSU,
	SPD,
	GRUENE,
	LINKE,
	FDP;

	public static Party fromString(String string) {
		if (string.toUpperCase().contains("CDU")) {
			return CDU;
		}
		if (string.toUpperCase().contains("CSU")) {
			return CSU;
		}
		if (string.toUpperCase().contains("SPD")) {
			return SPD;
		}
		if (string.toUpperCase().contains("GRÜNEN")) {
			return GRUENE;
		}
		if (string.toUpperCase().contains("LINKE")) {
			return GRUENE;
		}
		if (string.toUpperCase().contains("FDP")) {
			return GRUENE;
		}

		if(string.equals(""))
		{
			return null;
		}
		System.out.println("Party: Can't find Party from string: '" + string + "'");
		return null;
	}
}
