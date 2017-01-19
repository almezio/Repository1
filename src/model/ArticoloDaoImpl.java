package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Articolo;

public class ArticoloDaoImpl implements ArticoloDao{
	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public Articolo createArticolo(Articolo articolo){
	
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().save(articolo);
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
							
			return articolo;				
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	public int updateArticolo(Articolo articolo){
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("update Articolo set descArticolo= :descArticolo where idArticolo= :idArticolo");
			query.setLong("idArticolo", articolo.getIdArticolo());
			query.setString("descArticolo", articolo.getDescArticolo());
			int entitiesUpdate=query.executeUpdate();  // in entitiesUpdate è indicato il numero di righe aggiornate
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
			return entitiesUpdate;				
		}catch(Exception e){
			return 0;
		}
	}
	
	@Override
	public int deleteArticolo(int idArticolo){
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("delete Articolo where idArticolo= :idArticolo");
			query.setLong("idArticolo", idArticolo);				
			int entitiesUpdate=query.executeUpdate();  // in entitiesUpdate è indicato il numero di righe cancellate
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
			return entitiesUpdate;				
		}catch(Exception e){
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> getArticoloFromId(Long idArticolo){
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("from Articolo a where a.idArticolo=:idArticolo");
			query.setLong("idArticolo",idArticolo);
			return (List<Articolo>)query.list();				
		}catch(Exception e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> getArticoliFromCategoria(Long idCategoria){
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			
			//Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Articolo.class).add(Restrictions.eq("idCategoria", idCategoria));
			//List <Articolo> articoli=criteria.list();
			List <Articolo> articoli=sessionFactory.getCurrentSession().createCriteria(Articolo.class).add(Restrictions.eq("idCategoria", idCategoria)).list();
			
			return articoli;				
		}catch(Exception e){
			return null;
		}
	}
	
}
