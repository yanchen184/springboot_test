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
    @Query(value = "INSERT INTO MEMBER (NAME, ALIVE, VIP, EMAIL,EMAIL,ROLE) VALUES (:name, :alive, :vip, :password,:email,:role )" +
            " ON DUPLICATE KEY UPDATE NAME = :name, ALIVE = :alive, VIP = :vip, EMAIL = :email, ROLE = :role", nativeQuery = true)
    int saveOrUpdate(String name, boolean alive, String vip, String password, String email, String role);

    default int saveOrUpdate(Member member) {
        return saveOrUpdate(member.getName(), member.getAlive(), member.getVip().getValue(), member.getPassword(), member.getEmail(), String.valueOf(member.getRole()));
    }

    @Modifying
    @Query(value = " update MEMBER set  BIRTHDAY = now()" +
            " where NAME = :name ", nativeQuery = true)
    void updateMemberByName(String name);


    @Query(value = "SELECT * FROM MEMBER WHERE (:memberNameList IS NULL OR NAME IN (:memberNameList))", nativeQuery = true)
    List<Member> list(List<String> memberNameList);

    Optional<Member> findByEmail(String name);

}
