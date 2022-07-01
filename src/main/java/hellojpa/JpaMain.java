package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            생성.
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

//            조회.
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

//            삭제.
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

//            수정.
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            JPQL 사용.
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                            .setFirstResult(1)
//                            .setMaxResults(8)
//                            .getResultList();
//
//            for(Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

////////      영속성

//            비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA");

//            영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            준영속
//            em.detach(member);

//            삭제한 상태
//            em.remove(member);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
