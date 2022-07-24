package com.elroykanye.sadues.data.repository;

import com.elroykanye.sadues.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Member, Long> {
}
