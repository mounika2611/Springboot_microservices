package com.ecommerce.productservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "product")
public class Product {


	    @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column (name = "product_name")
	   
	    private String productName;

	    @Column (name = "price")
	   
	    private BigDecimal price;

	    @Column (name = "discription")
	    private String discription;

	    @Column (name = "category")
	   
	    private String category;

	    @Column (name = "availability")
	    
	    private int availability;
	    
	    public Product() {

		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getDiscription() {
			return discription;
		}

		public void setDiscription(String discription) {
			this.discription = discription;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getAvailability() {
			return availability;
		}

		public void setAvailability(int availability) {
			this.availability = availability;
		}

		
}
