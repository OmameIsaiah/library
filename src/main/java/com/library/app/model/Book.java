package com.library.app.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
/*@Table(name = "book_crud")*/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "catalogue", uniqueConstraints = {@UniqueConstraint(name = "UniqueISBNAndTitleConstrain", columnNames = { "isbn", "title" })})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "Author cannot be empty!")
    @Column(name = "author")
    private String author;

    @NotNull(message = "title cannot be empty!")
    @Column(name = "title", unique = true)
    private String title;
    @Column(name = "sub_title")
    private String subTitle;
    @NotNull(message = "Subject cannot be empty!")
    @Column(name= "subject")
    private String subject;
    @NotNull(message = "Date of publication cannot be empty!")
    @Column(name = "date_of_pub")
    private String dateOfPub;
    @NotNull(message = "Place of publication cannot be empty!")
    @Column(name = "place_of_pub")
    private String placeOfPop;
    @NotNull(message = "Publisher cannot be empty!")
    @Column(name = "publisher")
    private String publisher;
    @NotNull(message = "ISBN cannot be empty!")
    @Column(name = "isbn", unique = true)
    private String isbn;
    @NotNull(message = "Category cannot be empty!")
    @Column(name = "category")
    private String category;
    @NotNull(message = "Resource type cannot be empty!")
    @Column(name = "resource_type")
    private String resourceType;//Book, Journal, Article, Magazine, Video, Audio, Newspaper
    @NotNull(message = "Physical format cannot be empty!")
    @Column(name = "format")
    private String physicalFormat;//print or electronic
    @NotNull(message = "File path cannot be empty!")
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "download_link")
    private String downloadLink;
    @NotNull(message = "Access type cannot be empty!")
    @Column(name = "access_type")
    private String accessType;
    @Column(name = "views")
    private String views;
    @Column(name = "downloads")
    private String downloads;
    @Column(name = "status")
    private  String status;
    @Column(name = "remark")
    private String remark;


}
