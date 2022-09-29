package com.elroykanye.sadues.data.repository;

import com.elroykanye.sadues.data.entity.composite.MembershipKey;
import com.elroykanye.sadues.data.entity.relation.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, MembershipKey> {
}
