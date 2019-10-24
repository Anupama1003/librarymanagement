package com.capgemini.librarymanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BooksInventory {
	@Id
	@Column(name="book_id")
	public String bookId;
	@Column(name="book_name")
	public String bookName;
	@Column(name="author1")
	public String firstauthor;
	@Column(name="author2")
	public String secondauthor;
	@Column
	public String publisher;
	@Column
	public String yearOfPublication;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getFirstauthor() {
		return firstauthor;
	}
	public void setFirstauthor(String firstauthor) {
		this.firstauthor = firstauthor;
	}
	public String getSecondauthor() {
		return secondauthor;
	}
	public void setSecondauthor(String secondauthor) {
		this.secondauthor = secondauthor;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	

}
