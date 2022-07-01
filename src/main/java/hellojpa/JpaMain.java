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
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);
            // 1차 캐시에서 값을 가져오기 때문에 캐시에 이미 있는 데이터를 조회하면 쿼리를 한 번만 실행함.
            // 또한 영속 엔티티의 동일성을 보장함.
            // 단, 같은 트랜잭션 안에서.
            System.out.println("result = "+(findMember1 == findMember2)); // true.

            // 엔티티 매니저는 데이터 변경 시 트랜잭션을 시작해야 함.

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
