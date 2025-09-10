package org.aptech.t2311e.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class PageDto  extends PagingDto{
    @SuppressWarnings("rawtypes")
    private List data;
    private long totalElements;
    private int number;
    private int numberOfElements;
    private int totalPages;
}
