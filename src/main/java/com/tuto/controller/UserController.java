package com.tuto.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.jwt.JwtTokenProvider;
import com.tuto.model.Product;
import com.tuto.model.Transaction;
import com.tuto.model.User;
import com.tuto.service.ProductService;
import com.tuto.service.TransactionService;
import com.tuto.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ProductService productService;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User user) {
		if (userService.findByUsername(user.getUsername()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<Object> getUser(Principal principal) {
		// principal = httpServletRequest.getUserPrincipal.
		if (principal == null) {
			// logout will also use here so we should return ok http status.
			return ResponseEntity.ok(principal);
		}
		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
		User user = userService.findByUsername(authenticationToken.getName());
		user.setToken(tokenProvider.generateToken(authenticationToken));

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/purchase")
	public ResponseEntity<Transaction> purchaseProduct(@RequestBody Transaction transaction) {
		return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}
}
