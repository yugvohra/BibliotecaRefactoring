package com.liibrarymanagement;

/**
 * Created by vohray on 6/30/16.
 */
public class Book {

  private final String name;
  private final int bookId;

  public Book(String name, int bookId) {
    this.name = name;
    this.bookId = bookId;
  }

  public String getName() {
    return name;
  }

}
