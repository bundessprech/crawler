package de.dtonal.bundessprech.domain;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.dtonal.bundessprech.HibernateUtil;
import de.dtonal.bundessprech.data.Fraction;

public class FractionDomain {

	private static Fraction grueneFraction;
	private static Fraction cduCsuFraction;
	private static Fraction spdFraction;
	private static Fraction linkeFraction;
	private static Fraction fdpFraction;
	
	private static FractionDomain instance=null;
	
    public static FractionDomain getInstance()
    {
    	if(instance == null)
    	{
    		instance = new FractionDomain();
    	}
    	return instance;
    }

	private FractionDomain() {
		// Grüne

		grueneFraction = readFractionFromDbViaFractionName("Grüne");
		if (grueneFraction == null) {
			grueneFraction = new Fraction();
			grueneFraction.setName("Grüne");
			saveFraction(grueneFraction);
		} else {
			System.out.println("Grüne are allready in DB");
		}
		// CDU/CSU
		cduCsuFraction = readFractionFromDbViaFractionName("CDU/CSU");
		if (cduCsuFraction == null) {
			cduCsuFraction = new Fraction();
			cduCsuFraction.setName("Grüne");
			saveFraction(cduCsuFraction);
		} else {
			System.out.println("CDU/CSU are allready in DB");
		}
		// SPD
		spdFraction = readFractionFromDbViaFractionName("SPD");
		if (spdFraction == null) {
			spdFraction = new Fraction();
			spdFraction.setName("SPD");
			saveFraction(spdFraction);
		} else {
			System.out.println("SPD are allready in DB");
		}
		// LINKE
		linkeFraction = readFractionFromDbViaFractionName("Linke");
		if (linkeFraction == null) {
			linkeFraction = new Fraction();
			linkeFraction.setName("Linke");
			saveFraction(linkeFraction);
		} else {
			System.out.println("Linke are allready in DB");
		}
		// FDP
		fdpFraction = readFractionFromDbViaFractionName("FDP");
		if (fdpFraction == null) {
			fdpFraction = new Fraction();
			fdpFraction.setName("FDP");
			saveFraction(fdpFraction);
		} else {
			System.out.println("FDP are allready in DB");
		}

	}

	public static Fraction readFractionFromDbViaFractionName(String fractionName) {
		String hql = "FROM Fraction WHERE FRACTION_NAME = :fraction_string";

		System.out.println("Trying to read Fraction: " + fractionName);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		Session session = null;
		session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setParameter("fraction_string", fractionName);
		List<Fraction> results = query.list();
		if (results.isEmpty()) {
			return null;
		} else {
			return results.get(0);
		}

	}
	
	public Fraction getFractionFromname(String name)
	{		
		if (name.toUpperCase().contains("CDU/CSU")) {
			return cduCsuFraction;
		}
		if (name.toUpperCase().contains("SPD")) {
			return spdFraction;
		}
		if (name.toUpperCase().contains("GRÜNE")) {
			return grueneFraction;
		}
		if (name.toUpperCase().contains("DIE LINKE")) {
			return linkeFraction;
		}
		if (name.toUpperCase().contains("FDP")) {
			return fdpFraction;
		}
		if(name.equals(""))
		{
			return null;
		}
		System.out.println("Fraction: Can't find Fraction from string: '" + name + "'");
		return null;
	}

	private static void saveFraction(Fraction fractionToSave) {
		System.out.println("Trying to save Fraction: " + fractionToSave.getName());
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			int fractionId = (Integer) session.save(fractionToSave);
			tx.commit();
			System.out.println("Saving fraction success: " + fractionToSave.getName() + " with id " + fractionId);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * @return the grueneFraction
	 */
	public static Fraction getGrueneFraction() {
		return grueneFraction;
	}

	/**
	 * @return the cduCsuFraction
	 */
	public static Fraction getCduCsuFraction() {
		return cduCsuFraction;
	}

	/**
	 * @return the spdFraction
	 */
	public static Fraction getSpdFraction() {
		return spdFraction;
	}

	/**
	 * @return the linkeFraction
	 */
	public static Fraction getLinkeFraction() {
		return linkeFraction;
	}

	/**
	 * @return the fdpFraction
	 */
	public static Fraction getFdpFraction() {
		return fdpFraction;
	}

	public static void clearAll() {
		HibernateUtil.getSessionFactory().openSession().createQuery("delete from Fraction").executeUpdate();
	}

}
