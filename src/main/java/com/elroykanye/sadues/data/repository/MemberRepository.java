package com.elroykanye.sadues.data.repository;

import com.elroykanye.sadues.data.entity.composite.MemberKey;
import com.elroykanye.sadues.data.entity.relation.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, MemberKey> {
}
