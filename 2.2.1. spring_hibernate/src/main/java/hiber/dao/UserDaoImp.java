package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers(String model, int series) {
      String hqlQuery = "FROM User u WHERE car.model = :paramModel AND car.series = :paramSeries";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
      query.setParameter("paramModel", model);
      query.setParameter("paramSeries", series);
      return query.getResultList();
   }
}
