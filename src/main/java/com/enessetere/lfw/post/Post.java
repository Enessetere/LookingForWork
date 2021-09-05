package com.enessetere.lfw.post;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "posts")
@Setter(value = AccessLevel.PRIVATE)
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(name = "id")
    private UUID postId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "company")
    private String companyName;

    //TODO: Address entity with OneToOne relation
    @Column(name = "address_id")
    private String address;

    //TODO: Profession entity with ManyToMany relation
    @Column(name = "profession")
    private String profession;

    //TODO: Specialization entity with ManyToMany relation
    @Column(name = "specialization")
    private String specialization;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return nameParser() + address + "\n" + profession + " - " + specialization + "\n" + description + "\n" + postId;
    }

    private String nameParser() {
        return (Objects.nonNull(companyName) ? companyName + "\n" : "") + (Objects.nonNull(lastName) ? lastName + " " : "") + (Objects.nonNull(firstName) ? firstName + "\n" : (Objects.nonNull(lastName) ? "\n" : ""));
    }

    public static class PostBuilder {
        private final Post post;

        public PostBuilder() {
            this.post = new Post();
        }

        public PostBuilder firstName(String firstName) {
            post.setFirstName(firstName);
            return this;
        }

        public PostBuilder lastName(String lastName) {
            post.setLastName(lastName);
            return this;
        }

        public PostBuilder companyName(String companyName) {
            post.setCompanyName(companyName);
            return this;
        }

        public PostBuilder address(String address) {
            post.setAddress(address);
            return this;
        }

        public PostBuilder profession(String profession) {
            post.setProfession(profession);
            return this;
        }

        public PostBuilder specialization(String specialization) {
            post.setSpecialization(specialization);
            return this;
        }

        public PostBuilder description(String description) {
            post.setDescription(description);
            return this;
        }

        public Post build() {
            return post;
        }
    }
}
