package common;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RemoveObjects {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Town> towns = new ArrayList<>();

        Query query = em.createNativeQuery("SELECT * FROM towns");
        List<Object[]> nativeQuery = query.getResultList();

        for (Object[] objects : nativeQuery) {
            int pk = (int) objects[0];
            Town town = em.find(Town.class, pk);
            towns.add(town);
            if (town.getName().length() > 5){
                em.detach(town);
            } else {
                town.setName(town.getName().toLowerCase());
                em.merge(town);
            }
        }

        System.out.println(towns);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
