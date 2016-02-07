/**
 * 
 */
package de.dtonal.bundessprech.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * @author dtonal_user
 *
 */

@Entity
@Table(name = "FRACTION",uniqueConstraints = {@UniqueConstraint(columnNames={"FRACTION_NAME"})})
public class Fraction {
	
	@Id
    @GeneratedValue
    @Column(name="FRACTION_ID")
	private int id;
	
	@Column(name="FRACTION_NAME")
	private String name;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the persons
	 */
	public Set<Person> getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@OneToMany(mappedBy="fraction")
	private Set<Person> persons;
	
	public String toString()
	{
		return getName();
	}
}
