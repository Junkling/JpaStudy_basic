package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
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
//
//        try {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setName("member1");
//            member1.setTeam(team);
//            Member member2 = new Member();
//            member2.setName("member2");
//            member2.setTeam(team);
//            em.persist(member1);
//            em.persist(member2);
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member1.getId());
//            Team findTeam = findMember.getTeam();
//            List<Member> members = findTeam.getMembers();
//            for (Member m : members) {
//                System.out.println("m.getName() = " + m.getName());
//            }
//            System.out.println("findTeam.getName() = " + findTeam.getName());
//            tx.commit();
//        try {
//            Movie movie = new Movie();
//            movie.setDirector("AAaa");
//            movie.setActor("BBbb");
//            movie.setName("영화이름22");
//            movie.setPrice(11111);
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie movie1 = em.find(Movie.class, movie.getId());
//            System.out.println("movie = " + movie1);
//
//            tx.commit();
//        try {
//            Member member = new Member();
//            member.setName("user");
//            member.setCreatedBy("kim");
//            member.setCreatedTime(LocalDateTime.now());
//
//            em.persist(member);
//            tx.commit();

//        try{
//            Member member1 = new Member();
//            member1.setName("hello1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("hello2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member findMember1REF = em.getReference(Member.class, member1.getId());
//            Member findMember1 = em.find(Member.class, member1.getId());
//            Member findMember2 = em.find(Member.class, member2.getId());
////            Member findMember2REF = em.getReference(Member.class, member2.getId());
//            System.out.println("findMember1REF.getClass() = " + findMember1REF.getClass());
//            System.out.println("findMember1.getClass() = " + findMember1.getClass());
//            System.out.println("findMember2.getClass() = " + findMember2.getClass());
//            System.out.println("findMember1.getClass()==findMember2.getClass() = " + (findMember1.getClass() == findMember2.getClass()));
//            System.out.println("findMember1==findMember1REF = " + (findMember1 == findMember1REF));
//
//            em.detach(findMember1REF);
//            //영속성 컨텍스트에서 제외시키면 LazyInitializationException 발생
//            System.out.println("findMember1REF.getName(); = " + findMember1REF.getName());
//
//            //find의 경우 객체가 넘어오고 Referenc의 경우 프록시 객체가 넘어옴으로 ==으로 타입 비교시 false가 나옴
//
//            //한번에 조인해서 값을 모두 가져옴
////            Member findMember = em.getReference(Member.class, member.getId());
////            System.out.println("findMember = " + findMember.getClass());
////            System.out.println("findMember.getId() = " + findMember.getId());
////            System.out.println("findMember.getName() = " + findMember.getName());
//
//
//            tx.commit();
//        try{
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setName("hello1");
//            member1.setTeam(team);
//            em.persist(member1);
//            em.flush();
//            em.clear();
////            Member m = em.find(Member.class, member1.getId());
////
////
////            System.out.println("m.getTeam.getClass() = " + m.getTeam().getClass());
////            System.out.println("===============");
////            m.getTeam().getName();
////            System.out.println("===============");
//
//            List<Member> members = em.createQuery("SElECT m FROM MEMBER m", Member.class).getResultList();
//
//            tx.commit();

        try {
            Child child1 = new Child();
            Child child2 = new Child();
            Parent parent = new Parent();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());

            findParent.getChildList().remove(0);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

}

