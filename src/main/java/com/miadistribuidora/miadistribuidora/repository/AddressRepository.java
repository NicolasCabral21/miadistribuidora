package com.miadistribuidora.miadistribuidora.repository;

import com.miadistribuidora.miadistribuidora.model.db.AddressDb;
import com.miadistribuidora.miadistribuidora.model.db.ItemDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressDb, Integer>, JpaSpecificationExecutor<ItemDb> {

    Optional<AddressDb> findById(Integer idAddress);
}
