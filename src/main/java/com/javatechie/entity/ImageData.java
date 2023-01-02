package com.javatechie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "images")
//@Table(name = "ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {
    @Id
    private String eventId;
    private String email;
    private String name;
    private String type;
    private int totalSeat;
//    @Lob
//    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
}
