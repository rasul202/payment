package com.example.msusers.page;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageContainer<T> {

    T data;
    Integer pageNo;
    Integer pageSize;
    Long totalElements;
    Integer totalPages;
    Boolean isLast;

}
