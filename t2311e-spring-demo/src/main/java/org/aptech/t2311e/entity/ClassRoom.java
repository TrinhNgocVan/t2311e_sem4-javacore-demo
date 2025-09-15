package org.aptech.t2311e.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class_room")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    //todo : class code  la duy nhat:
    @Column(name = "code",unique = true)
    private String code;
    @Column(name = "description")
    private String description;
    @Column(name = "start_time")
    private LocalDate startTime;
    @Column(name = "end_time")
    private LocalDate endTime;
    @Column(name = "current_semester")
    private Integer currentSemester;
//    private Integer numberOfStudents;

    /*
    FetchType :
        LAZY : Khi A va B co moi quan he -> load A se chua load B , chi load khi goi a.getB()
        EAGER :  Khi A va B co moi quan he -> load A , ngay lap tuc se load a.getB
      CASCADE : quy dinh truong hop lan truyen su thay doi tu entity cha  -> entity con
      orphanRemoval : xoa con trong danh sach cha -> xoa ban ghi phan tu con trong db hay ko
     */
    @OneToMany(mappedBy = "classRoom", fetch = FetchType.EAGER
    , cascade = CascadeType.ALL, orphanRemoval = true
    )
    private List<Student> students = new ArrayList<>();
}
