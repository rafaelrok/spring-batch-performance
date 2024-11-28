package com.springbatch.competicao.dominio;

import java.math.BigDecimal;
import java.util.List;

public class Product {
	private Integer id;
	private String name;
	private String description;
	private String image;
	private BigDecimal price;
	private BigDecimal discountAmount;
	private String status;
	private List<Object> categories;
	private String textCategories;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Object> getCategories() {
		return categories;
	}

	public void setCategories(List<Object> categories) {
		this.categories = categories;
	}

	public String getTextCategories() {
		return textCategories;
	}

	public void setTextCategories(String textCategories) {
		this.textCategories = textCategories;
	}

}
