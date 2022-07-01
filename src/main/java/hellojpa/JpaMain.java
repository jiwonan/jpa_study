package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush(); // 쿼리가 이 시점에 호출됨.
            // flush를 한다고 1차 캐시가 지워지지 않음.
            // 영속성 컨텍스트에 있는 쓰기지연 SQL 저장소에 있는 것들이 DB에 반영되는 것 뿐임.

            System.out.println("===================");

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
