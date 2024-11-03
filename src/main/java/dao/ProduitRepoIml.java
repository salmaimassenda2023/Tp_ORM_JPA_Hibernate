package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("produitDao")
@Transactional
public class ProduitRepoIml implements EntityRepository<Produit>{
    @PersistenceContext
    private EntityManager entityManager ;

    // METHODS
    @Override
    public Produit save(Produit p) {
        entityManager.persist(p);
        return p;
    }

    @Override
    public Produit findOne(Long id) {
        Produit produit = entityManager.find(Produit.class,id);
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        Query query=entityManager.createQuery("select p from Produit p");
        return query.getResultList();
    }

    @Override
    public List<Produit> findParMC(String mc) {
        Query query=entityManager.createQuery("select p from Produit p where p.designation like :x");
        query.setParameter(1,mc);
        return query.getResultList();
    }

    @Override
    public Produit update(Produit p) {
        entityManager.merge(p);
        return p;
    }

    @Override
    public void delete(Long id) {
        Produit produit = entityManager.find(Produit.class,id);
        entityManager.remove(produit);

    }
}
