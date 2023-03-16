package com.ecommerce.store;

import com.ecommerce.store.dto.CartRequest;
import com.ecommerce.store.dto.ItemProductRequest;
import com.ecommerce.store.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class StoreApplication implements CommandLineRunner {

	@Autowired
	ICartService cartService;

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var itemProductRequest = ItemProductRequest.builder()
				.productId(1L)
				.quantity(2)
				.build();

		var itemProductRequest2 = ItemProductRequest.builder()
				.productId(2L)
				.quantity(3)
				.build();

		List<ItemProductRequest> itemProductRequests = new ArrayList<>();
		itemProductRequests.add(itemProductRequest);
		itemProductRequests.add(itemProductRequest2);

		var cart = CartRequest.builder()
				.itemProductRequests(itemProductRequests)
				.build();

		//create
		var response = cartService.save(cart.toDomain());
		//read
		delay();
		cartService.find(response.getId());
		//update
		delay();
		response.getItemProducts().remove(0);
		cartService.save(response);
		//delete
		delay();
		cartService.delete(response.getId());

	}

	private void delay() throws InterruptedException {
		Thread.sleep(2000L);
	}

}
