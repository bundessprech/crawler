package de.dtonal.bundessprech.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Test;

import de.dtonal.bundessprech.DataBaseInitialiser;
import de.dtonal.bundessprech.HibernateUtil;
import de.dtonal.bundessprech.data.Fraction;
import de.dtonal.bundessprech.domain.FractionDomain;

public class TestFractionDomain {

	@Test
	public void testCreationOfFractionDomain() {
		FractionDomain domain = FractionDomain.getInstance();
		assertNotNull(domain);
		assertNotNull(domain.getCduCsuFraction());
		assertNotNull(domain.getSpdFraction());
		assertNotNull(domain.getGrueneFraction());
		assertNotNull(domain.getLinkeFraction());
		assertNotNull(domain.getFdpFraction());
	}

	@Test
	public void readFractionByName() {
		Fraction fraction = FractionDomain.getInstance().readFractionFromDbViaFractionName("Grüne");
		assertNotNull(fraction);
	}

	@After
	public void closeIt() {
		HibernateUtil.getSessionFactory().getCurrentSession().close();
	}

}
