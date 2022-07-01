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
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            // 준영속
            em.detach(member); // update query는 실행하지 않음.
            // 영속성에서 분리했기 때문에.

            // 특정 entity만 준영속 상태로 만들 때 -> detatch
            // 전부 다 해제 -> em.clear
            Member member2 = em.find(Member.class, 150L); // query가 두 번 실행됨.

            // em.close
            // 영속성 관리를 하지 않음.

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
