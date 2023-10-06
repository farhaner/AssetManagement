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
@Builder(toBuilder = true)
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "branch_code" , nullable = false)
    private String branchCode;

    @Column(name = "branch_name" , nullable = false)
    private String branchName;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "mobile_phone" , nullable = false , unique = true)
    private String mobilePhone;
}
