package com.enessetere.lfw.review;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter(value = AccessLevel.PRIVATE)
@Getter
@Entity(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID idx;

    @Column(name = "author")
    private String author;

    @Column(name = "review")
    private String review;
    //TODO: to merge with note branch
    @Column(name = "note")
    private String note;

    protected Review() {}

    public static class Builder {
        private final Review review;

        public Builder() {
            this.review = new Review();
        }

        public Builder author(String author) {
            this.review.setAuthor(author);
            return this;
        }

        public Builder review(String review) {
            this.review.setReview(review);
            return this;
        }

        public Builder note(String note) {
            this.review.setNote(note);
            return this;
        }

        public Review build() {
            return this.review;
        }
    }
}
