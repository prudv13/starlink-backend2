package com.Hack.Hackthon.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VendorEntity {
    @Id
    private long id;
    private String min_capacity;
    private String max_capacity;
    private String vehicletype;
    private String zone;
    private String marketArea;
    private String UploadPicture;
}
