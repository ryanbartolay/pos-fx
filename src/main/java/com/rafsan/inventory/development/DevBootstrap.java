package com.rafsan.inventory.development;

import org.hibernate.Session;

import com.rafsan.inventory.HibernateUtil;
import com.rafsan.inventory.entity.Employee;
import com.rafsan.inventory.utils.StringUtils;

public class DevBootstrap {

	private static Session session;
	private String password = "123456a";
	
	public DevBootstrap() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Employee employee = new Employee();
		employee.setUserName("admin");
		employee.setPassword(StringUtils.cryptWithMD5(password));
		employee.setFirstName("Admin");
		employee.setLastName("Admin");
		employee.setType("admin");
		session.save(employee);
        session.getTransaction().commit();
		
	}
}
