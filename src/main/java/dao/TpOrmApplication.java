package dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TpOrmApplication {

    public static void main(String[] args) {

       ApplicationContext context= SpringApplication.run(TpOrmApplication.class, args);
        EntityRepository<Produit> produitDao=context.getBean(EntityRepository.class);
        produitDao.save(new Produit("pc 200", 6000.0,12));
        produitDao.save(new Produit("HP ", 100.0,30));
        produitDao.save(new Produit("pc PPH", 4300.0,42));
    }

}
