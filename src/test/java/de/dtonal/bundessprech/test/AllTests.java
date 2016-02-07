package de.dtonal.bundessprech.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCsvParser.class, TestFractionDomain.class, TestHibernateUtil.class, TestPersonDomain.class })
public class AllTests {

}
