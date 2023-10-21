package com.finalproject.assetmanagement.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "inbound_item" , nullable = false)
    private String inboundItem;

    @Column(name = "outbound_item" , nullable = false)
    private String outboundItem;

    @Column(name = "loan_amount" , nullable = false)
    private Long loanAmount;

    @Column(name = "status" , nullable = false)
    private String status;

    @Column(name = "current_quantity" , nullable = false)
    private Long currentQuantity;

    @OneToMany(mappedBy = "transaction")
    private List<Asset> assets;

    @OneToMany(mappedBy = "transaction")
    private List<Employee> employees;

}
