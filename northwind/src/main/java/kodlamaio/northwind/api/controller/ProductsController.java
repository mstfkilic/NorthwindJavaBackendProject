package kodlamaio.northwind.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products") // kodlama.io/api/request şeklinde bir istekte bulunulursa burası yönlendirecek.
public class ProductsController { // Farklı applicationların (Web,IOS,Android ) Backend ile anlaşabilmesi için yerleştirdiğimiz Api'nin controlünü sağlıyor.Dış Dünya ile iletişim kurduğumuz yer.
	
	
	private ProductService productService;
	
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}



	@GetMapping("/getall")
	public List<Product>getAll(){
		return this.productService.getAll();
	}
	
}
