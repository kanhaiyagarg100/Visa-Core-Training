package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		// create spring container
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		// ApplicationContext ctx= new ClassPathXmlApplicationContext("app.xml")
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		OrderService os= ctx.getBean("orderService", OrderService.class);
		
		List<Product> list= os.fetchProducts();
		for(Product p: list) {
			System.out.println(p.getName()+","+p.getPrice());
		}
	}
}
