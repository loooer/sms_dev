package com.yyh.cj.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.yyh.cj.model.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao{
	private JdbcTemplate jdbcTemplate;
	
//	private SessionFactory sessionFactory;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Users> UsersQuery() {
		List<Map<String, Object>> lists = getJdbcTemplate().queryForList("select * from users");
		List<Users> users = new ArrayList<Users>();
		if(lists != null && lists.size() > 0){
			for(Map<String, Object> list : lists){
				Users user = new Users();
				user.setUserId((Integer)list.get("userid"));
				user.setName((String)list.get("name"));
				user.setPassword((String)list.get("password"));
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public boolean saveUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<Object>)getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					public Object doInHibernate(Session session) throws HibernateException {
						// TODO Auto-generated method stub
						Query query = session.createQuery("from Users");
						List<Object> rows = query.list();
						return rows;
					}
					
				});
	}

}
