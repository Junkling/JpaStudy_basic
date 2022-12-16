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

        //save 쿼리
//        try {
//            Member member = new Member();
//            member.setId(3L);
//            member.setName("HelloC");
//            em.persist(member);
//
//            em.flush();
//            Member findMember = em.find(Member.class, 3L);
//            findMember.setName("ByeC");
//            //쿼리문이 나가지 않고 1차 캐쉬에 저장된 객체 정보를 가져옴
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName//() = " + findMember.getName());
//            System.out.println("==========");
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        }finally {
//        em.close();
//        }

//        try {
//
//            Member findMember = em.find(Member.class, 3L);
//            findMember.setName("HiC");
//            em.detach(findMember);
//
//            System.out.println("==========");
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        }finally {
//        em.close();
//        }

//        //업데이트 쿼리
//        try {
//            // EM는 Entity를 관리하고 있어 변경사항이 있으면 커밋시점에 확인하여 업데이트 쿼리를 날림
//            Member findMember1 = em.find(Member.class, 1L);
//            Member findMember2 = em.find(Member.class, 1L);
//            //같은 엔티티를 가져올때 처음에만 쿼리문이 나가고 1차 캐쉬에 저장된다.
//
//            System.out.println(findMember1 == findMember2);
//
//            findMember1.setName("ByeA");
//            System.out.println("============================");
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//
//        //JPQL
//        try {
//            // EM는 Entity를 관리하고 있어 변경사항이 있으면 커밋시점에 확인하여 업데이트 쿼리를 날림
//            List<Member> result = em.createQuery("Select m from Member", Member.class).getResultList();
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        }finally {
//        em.close();
//        }
//        emf.close();
//    }
    }
}
