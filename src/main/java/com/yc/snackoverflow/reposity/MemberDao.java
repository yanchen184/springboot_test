package com.yc.snackoverflow.reposity;

import com.yc.snackoverflow.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberDao extends JpaRepository<Member, Long> {

    @Modifying
    @Query(value = "INSERT INTO MEMBER (NAME, ALIVE, VIP, PASSWORD,BIRTHDAY) VALUES (:name, :alive, :vip, :password,now())" +
            " ON DUPLICATE KEY UPDATE NAME = :name, ALIVE = :alive, VIP = :vip, PASSWORD = :password, BIRTHDAY = now()", nativeQuery = true)
    int saveOrUpdate(String name, boolean alive, String vip, String password);

    default int saveOrUpdate(Member member) {
        return saveOrUpdate(member.getName(), member.getAlive(), member.getVip().getValue(), member.getPassword());
    }

    @Modifying
    @Query(value = " update MEMBER set  BIRTHDAY = now()" +
            " where NAME = :name ", nativeQuery = true)
    void updateMemberByName(String name);


    @Query(value = "SELECT * FROM MEMBER WHERE (:memberNameList IS NULL OR NAME IN (:memberNameList))", nativeQuery = true)
    List<Member> list(List<String> memberNameList);

    Optional<Member> findByEmail(String name);

}
