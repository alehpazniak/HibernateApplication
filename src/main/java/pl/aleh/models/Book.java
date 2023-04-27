package pl.aleh.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

public class Book {

  private int id;

  @NotEmpty(message = "Book title cannot be empty")
  @Size(min = 2, max = 30, message = "Book title must be between 2 and 30 characters")
  private String title;

  @NotEmpty(message = "Author cannot be empty")
  @Size(min = 2, max = 30, message = "The author's name must be between 2 and 30 characters")
  private String author;

  @Min(value = 1500, message = "Year must be greater than 1500")
  private int year;

  @ManyToOne
  @JoinColumn(name = "person_id", referencedColumnName = "id")
  private Person owner;

  @Column(name = "taken_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date takenAt;

  @Transient
  private boolean expired;

  public Book() {}

  public Book(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Person getOwner() {
    return owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public Date getTakenAt() {
    return takenAt;
  }

  public void setTakenAt(Date takenAt) {
    this.takenAt = takenAt;
  }

  public boolean isExpired() {
    return expired;
  }

  public void setExpired(boolean expired) {
    this.expired = expired;
  }

}
