package kodlamaio.northwind.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
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
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping
	public Result add(@RequestBody Product product) {
		
		return this.productService.add(product);
	}
	@GetMapping("/getByProductName")
	public DataResult<Product>getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>>getAll(@RequestParam int pageNo,@RequestParam int pageSize ){
		return this.productService.getAll(pageNo, pageSize);
		
	}
	@GetMapping("/getAllBySorting")
	DataResult<List<Product>>getAllSorted(){
		return this.productService.getAllSorted();
	}
	
}
