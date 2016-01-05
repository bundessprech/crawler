package de.dtonal.bundessprech.data;

public enum State {
	SCHLESWIG_HOLSTEIN, MECKLENBURG_VORPOMMERN, HAMBURG, BREMEN, LOWER_SAXONY, BRANDENBURG, BERLIN, SAXONY_ANHALT, NORTH_RINE_WESTPHALIA, HESSE, THURINGIA, SAXONY, RHINELAND_PALATINATE, SAARLAND, BADEN_WUERTTEMBERG, BAVARIA;

	public static State fromString(String string) {

		if (string.equals("Schleswig-Holstein")) {
			return State.SCHLESWIG_HOLSTEIN;
		}
		if (string.equals("Mecklenburg-Vorpommern")) {
			return MECKLENBURG_VORPOMMERN;
		}
		if (string.equals("Hamburg")) {
			return HAMBURG;
		}
		if (string.equals("Bremen")) {
			return BREMEN;
		}
		if (string.equals("Niedersachsen")) {
			return LOWER_SAXONY;
		}
		if (string.equals("Brandenburg")) {
			return BRANDENBURG;
		}
		if (string.equals("Berlin")) {
			return BERLIN;
		}
		if (string.equals("Sachsen-Anhalt")) {
			return SAXONY_ANHALT;
		}
		if (string.equals("Nordrhein-Westfalen")) {
			return NORTH_RINE_WESTPHALIA;
		}
		if (string.equals("Hessen")) {
			return HESSE;
		}
		if (string.equals("Thüringen")) {
			return THURINGIA;
		}
		if (string.equals("Sachsen")) {
			return SAXONY;
		}
		if (string.equals("Rheinland-Pfalz")) {
			return RHINELAND_PALATINATE;
		}
		if (string.equals("Saarland")) {
			return SAARLAND;
		}
		if (string.equals("Baden-Württemberg")) {
			return BADEN_WUERTTEMBERG;
		}
		if (string.equals("Bayern")) {
			return BAVARIA;
		}

		if(string.equals(""))
		{
			return null;
		}
		System.out.println("Party: Can't find Party from string: '" + string + "'");
		return null;
	}
}
