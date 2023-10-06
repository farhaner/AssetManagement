package com.finalproject.assetmanagement.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "asset_code" , nullable = false)
    private String assetCode;

    @Column(name = "asset_name" , nullable = false)
    private String name;

    @Column(name = "description" , nullable = false)
    private String description;

//    @ManyToOne
//    @Column(name = "branch_id")
//    private Branch branchId;
}
