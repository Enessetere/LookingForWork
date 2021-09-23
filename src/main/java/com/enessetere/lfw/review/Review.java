package com.enessetere.lfw.review;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(value = AccessLevel.PRIVATE)
@Getter
public class Review {
    private String author;
    private String message;
    //TODO: to merge with note branch
    private String note;

    private Review() {}

    public static class Builder {
        private Review review;

        public Builder() {
            review = new Review();
        }

        public Builder author(String author) {
            review.setAuthor(author);
            return this;
        }

        public Builder message(String message) {
            review.setMessage(message);
            return this;
        }

        public Builder note(String note) {
            review.setNote(note);
            return this;
        }

        public Review build() {
            return review;
        }
    }
}
