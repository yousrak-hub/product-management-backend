package com.tuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.model.Product;
import com.tuto.model.Transaction;
import com.tuto.model.User;
import com.tuto.service.ProductService;
import com.tuto.service.TransactionService;
import com.tuto.service.UserService;

@RestController
@RequestMapping("api/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private TransactionService transactionService;

	@PutMapping("/user-update")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		User existUser = userService.findByUsername(user.getUsername());
		if (existUser != null && !existUser.getId().equals(user.getId())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/all-users")
	public ResponseEntity<List<User>> findAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/users-count")
	public ResponseEntity<Long> numberOfUsers() {
		return new ResponseEntity<>(userService.numberOfUsers(), HttpStatus.OK);
	}

	@PostMapping("/create-product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/product-update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
	}

	@DeleteMapping("/product-delete/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/all-products")
	public ResponseEntity<List<Product>> findAllProdcuts() {
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/products-count")
	public ResponseEntity<Long> numberOfProdcuts() {
		return new ResponseEntity<>(productService.numberOfProducts(), HttpStatus.OK);
	}

	@GetMapping("/all-transactions")
	public ResponseEntity<List<Transaction>> findAllTransactions() {
		return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
	}

	@GetMapping("/transactions-count")
	public ResponseEntity<Long> numberOfTransactions() {
		return new ResponseEntity<>(transactionService.numberOfTransactions(), HttpStatus.OK);
	}
}
