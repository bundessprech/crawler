/**
 * 
 */
package de.dtonal.bundessprech.data;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dtonal
 *
 */
@Entity
@Table(name = "PERSON")
public class Person {
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	// german: Wahlkreis
	@Column(name = "electoralDistrictName")
	private String electoralDistrictName;
	// german: Fraktion
	@Column(name = "faction")
	@Enumerated(EnumType.STRING)
	private Faction faction;
	@Column(name = "homepageUrl")
	private URL homepageUrl;
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "party")
	@Enumerated(EnumType.STRING)
	private Party party;
	@Column(name = "prename")
	private String prename;
	@Column(name = "profession")
	private String profession;
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "state")
	private State state;
	@Column(name = "surname")
	private String surname;
	@Column(name = "title")
	private String title;
	@Column(name = "titleOfNobility")
	private String titleOfNobility;
	@Column(name = "university")
	private String university;

	/**
	 * @param id
	 * @param prename
	 * @param surname
	 */
	public Person(int id, String prename, String surname) {
		super();
		this.id = id;
		this.prename = prename;
		this.surname = surname;
	}

	public Person() {
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the electoralDistrictName
	 */
	public String getElectoralDistrictName() {
		return electoralDistrictName;
	}

	/**
	 * @param electoralDistrictName
	 *            the electoralDistrictName to set
	 */
	public void setElectoralDistrictName(String electoralDistrictName) {
		this.electoralDistrictName = electoralDistrictName;
	}

	/**
	 * @return the faction
	 */
	public Faction getFaction() {
		return faction;
	}

	/**
	 * @param faction
	 *            the faction to set
	 */
	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	/**
	 * @return the homepageUrl
	 */
	public URL getHomepageUrl() {
		return homepageUrl;
	}

	/**
	 * @param homepageUrl
	 *            the homepageUrl to set
	 */
	public void setHomepageUrl(URL homepageUrl) {
		this.homepageUrl = homepageUrl;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * @param party
	 *            the party to set
	 */
	public void setParty(Party party) {
		this.party = party;
	}

	/**
	 * @return the prename
	 */
	public String getPrename() {
		return prename;
	}

	/**
	 * @param prename
	 *            the prename to set
	 */
	public void setPrename(String prename) {
		this.prename = prename;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the titleOfNobility
	 */
	public String getTitleOfNobility() {
		return titleOfNobility;
	}

	/**
	 * @param titleOfNobility
	 *            the titleOfNobility to set
	 */
	public void setTitleOfNobility(String titleOfNobility) {
		this.titleOfNobility = titleOfNobility;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university
	 *            the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
