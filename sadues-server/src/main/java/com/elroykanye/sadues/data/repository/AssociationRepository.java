package com.elroykanye.sadues.data.repository;

import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.University;
import com.elroykanye.sadues.data.enums.AssociationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
    List<Association> findAllByUniversity(University university);
    Optional<Association> findByUniversityAndType(University university, AssociationType associationType);
}
