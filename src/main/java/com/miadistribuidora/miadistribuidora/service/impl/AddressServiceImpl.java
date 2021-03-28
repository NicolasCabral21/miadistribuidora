package com.miadistribuidora.miadistribuidora.service.impl;

import com.miadistribuidora.miadistribuidora.model.db.AddressDb;
import com.miadistribuidora.miadistribuidora.repository.AddressRepository;
import com.miadistribuidora.miadistribuidora.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDb saveAddress(AddressDb address) {
        addressRepository.save(address);
        return address;
    }

    @Override
    public Optional<AddressDb> getAddress(Integer idAddress) {
        return Optional.empty();
    }

    @Override
    public List<AddressDb> getAddresses() {
        return null;
    }

    @Override
    public AddressDb updateAddress(AddressDb item) {
        return null;
    }

    @Override
    public void deleteAddress(Integer itemId) {

    }
}
