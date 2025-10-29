package org.aptech.t2311e.entity.onetomany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity  // todo : -> danh dau 1 bean
@Table(name = "product_table")  // todo -> khai bao anh xa  -> db
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product {
    @Id  // khai bao khoa chin
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

     // 1 product  -> 1 category

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "category_id")
    @JsonIgnore
    private Category category;
}
