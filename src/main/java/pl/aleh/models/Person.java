package pl.aleh.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;
import javax.persistence.OneToMany;

public class Person {

  private int id;

  @NotEmpty(message = "Name must not be empty")
  @Size(min = 6, max = 100, message = "Name must be between 6 and 100 characters")
  private String fullName;

  @Min(value = 1923, message = "Year of birth must be greater than 1923")
  private int yearOfBirth;

  @OneToMany(mappedBy = "owner")
  private List<Book> books;

  public Person() {}

  public Person(String fullName, int yearOfBirth) {
    this.fullName = fullName;
    this.yearOfBirth = yearOfBirth;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
