package com.example.mspayments.constants;

import lombok.*;

@AllArgsConstructor
@Getter
public enum StatusConstants {
    ACTIVE(1) ,
    DE_ACTIVE(0);

    private Integer status;
}
