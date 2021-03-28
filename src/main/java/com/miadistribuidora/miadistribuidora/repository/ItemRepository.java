package com.miadistribuidora.miadistribuidora.repository;

import com.miadistribuidora.miadistribuidora.model.db.ItemDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemDb, Integer>, JpaSpecificationExecutor<ItemDb> {

    Optional<ItemDb> findById(Integer idItem);
}
