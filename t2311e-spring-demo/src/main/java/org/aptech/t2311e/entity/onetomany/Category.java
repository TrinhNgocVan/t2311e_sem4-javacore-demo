package org.aptech.t2311e.entity.onetomany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity  // todo : -> danh dau 1 bean
@Table(name = "category_table")
// todo -> khai bao anh xa  -> db
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL
    , orphanRemoval = true
    )
    private List<Product> products;

}
