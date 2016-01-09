package de.dtonal.bundessprech.db;

import de.dtonal.bundessprech.data.Person;

public class PersonDomain implements IPersonDomain{
	
	public void addPerson(Person person)
	{
		addPerson(person, false);
	}
	
	public void addPerson(Person person, boolean updateIfExists)
	{
		//TODO Implement
	}

}
