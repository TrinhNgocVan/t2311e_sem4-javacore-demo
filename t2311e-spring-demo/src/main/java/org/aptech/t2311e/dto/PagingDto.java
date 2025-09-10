package org.aptech.t2311e.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lop cha dung chung cho tat ca model danh sach co phan tran
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingDto {
    private int pageSize;
    private int pageNumber;
}
