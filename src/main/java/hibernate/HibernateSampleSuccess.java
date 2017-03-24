package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Member;
/**
 * test to use hibernate framework
 *
 */
public class HibernateSampleSuccess {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();

//		System.out.println(new File(ROOT_PATH + "xml\\hibernate.cfg.xml").getAbsolutePath());


//		cfg.configure(new File(CommonUtil.ROOT_PATH + "xml\\hibernate.cfg.xml").getAbsolutePath());
//		cfg.configure(new File("D:/git/mytrainrepo/JavaTest/src/main/java/xml/hibernate.cfg.xml"));
		cfg.configure("xml/hibernate.cfg.xml");
//		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		try{
			Member m = new Member(1, "Tom");
			s.save(m);
			tx.commit();
		} catch (HibernateException he){
			he.printStackTrace();
		}
	}
}
