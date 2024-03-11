package com.yc.snackoverflow.reposity;

import com.yc.snackoverflow.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao extends JpaRepository<Member, Long> {

    @Modifying
    @Query(value = "INSERT INTO MEMBER (NAME, ALIVE, VIP, PASSWORD) VALUES (:name, :alive, :vip, :password) ON DUPLICATE KEY UPDATE NAME = :name, ALIVE = :alive, VIP = :vip, PASSWORD = :password", nativeQuery = true)
    int saveOrUpdateMember(String name, boolean alive, int vip, String password);

    default int saveOrUpdateMember(Member member) {
        return saveOrUpdateMember(member.getName(), member.isAlive(), member.getVip(), member.getPassword());
    }

    @Query(value = "SELECT * FROM MEMBER WHERE NAME IN (:memberNameList)", nativeQuery = true)
    List<Member> listMember(List<String> memberNameList);
}
