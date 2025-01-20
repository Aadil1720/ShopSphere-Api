package com.adil.inventory_service;

import com.adil.inventory_service.model.Inventory;
import com.adil.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class InventoryServiceApplication {

	private final InventoryRepository inventoryRepository;

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData() {
		return args -> {

			Inventory sku1 = new Inventory();
			sku1.setSkuCode("SKU001");
			sku1.setQuantity(10);

			Inventory sku2 = new Inventory();
			sku2.setSkuCode("SKU002");
			sku2.setQuantity(0);

			Inventory sku3 = new Inventory();
			sku3.setSkuCode("SKU003");
			sku3.setQuantity(20);

			inventoryRepository.save(sku1);
			inventoryRepository.save(sku2);
			inventoryRepository.save(sku3);
		};

	}
}
