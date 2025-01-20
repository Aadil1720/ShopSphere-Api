package com.adil.inventory_service.repository;

import com.adil.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Object> findBySkuCode(String skuCode);
}
