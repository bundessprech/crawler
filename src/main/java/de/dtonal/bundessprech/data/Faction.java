package de.dtonal.bundessprech.data;

public enum Faction {
	CDU_CSU, SPD, GRUENE, LINKE, FDP;

	public static Faction fromString(String string) {
		
		if (string.toUpperCase().contains("CDU/CSU")) {
			return CDU_CSU;
		}
		if (string.toUpperCase().contains("SPD")) {
			return SPD;
		}
		if (string.toUpperCase().contains("GRÜNE")) {
			return GRUENE;
		}
		if (string.toUpperCase().contains("DIE LINKE")) {
			return LINKE;
		}
		if (string.toUpperCase().contains("FDP")) {
			return FDP;
		}
		if(string.equals(""))
		{
			return null;
		}
		System.out.println("Faction: Can't find Faction from string: '" + string + "'");
		return null;
	}
}
