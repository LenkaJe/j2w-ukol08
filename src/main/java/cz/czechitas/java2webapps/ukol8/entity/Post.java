package cz.czechitas.java2webapps.ukol8.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Post {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @NotBlank
 private String slug;
 @NotBlank
 private String author;
 @NotBlank
 private String title;
 @NotBlank
 private String perex;
 @NotBlank
 private String body;
 private LocalDate published;

 public Post(Long id, @NotBlank String slug, @NotBlank String author, @NotBlank String title, @NotBlank String perex, @NotBlank String body, LocalDate published) {
  this.id = id;
  this.slug = slug;
  this.author = author;
  this.title = title;
  this.perex = perex;
  this.body = body;
  this.published = published;
 }

 public Post() {
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getSlug() {
  return slug;
 }

 public void setSlug(String slug) {
  this.slug = slug;
 }

 public String getAuthor() {
  return author;
 }

 public void setAuthor(String author) {
  this.author = author;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getPerex() {
  return perex;
 }

 public void setPerex(String perex) {
  this.perex = perex;
 }

 public String getBody() {
  return body;
 }

 public void setBody(String body) {
  this.body = body;
 }

 public LocalDate getPublished() {
  return published;
 }

 public void setPublished(LocalDate published) {
  this.published = published;
 }
}
