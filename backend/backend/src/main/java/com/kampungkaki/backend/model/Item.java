package com.kampungkaki.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "items")
@Data // This generates getters/setters automatically via Lombok
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category; // e.g., "Tools", "Kitchen", "Games"
    private String contact;    // e.g., "Tele: @sebas"
    private boolean available = true;

    // Add this annotation to ensure it defaults to true in the database
//    @Column(columnDefinition = "boolean default true")

//    public boolean isAvailable() {
//        return isAvailable;
//    }
//
//    public void setAvailable(boolean available) {
//        isAvailable = available;
//    }
}
