package com.travel.load.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String title;
    private String context;
    private LocalDate postDate;
    private String author;
    private String authorImage;


    public Post(String image, String title, String context, LocalDate postDate, String author, String authorImage) {
        this.image = image;
        this.title = title;
        this.context = context;
        this.postDate = postDate;
        this.author = author;
        this.authorImage = authorImage;
    }
}
