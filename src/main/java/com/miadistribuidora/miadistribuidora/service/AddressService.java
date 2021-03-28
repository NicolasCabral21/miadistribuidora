package com.miadistribuidora.miadistribuidora.service;

import com.miadistribuidora.miadistribuidora.model.db.AddressDb;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressDb saveAddress(AddressDb address);
    Optional<AddressDb> getAddress(Integer idAddress);
    List<AddressDb> getAddresses();
    AddressDb updateAddress(AddressDb item);
    void deleteAddress(Integer itemId);
}
