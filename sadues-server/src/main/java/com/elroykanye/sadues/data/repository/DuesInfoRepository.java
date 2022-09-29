package com.elroykanye.sadues.data.repository;

import com.elroykanye.sadues.data.entity.composite.DuesInfoKey;
import com.elroykanye.sadues.data.entity.relation.DuesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuesInfoRepository extends JpaRepository<DuesInfo, DuesInfoKey> {

}
