package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.models.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
