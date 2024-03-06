package com.example.mscurrencies.dto.models.cbarClientModel;

import jakarta.xml.bind.annotation.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ValCurs {

    @XmlAttribute(name = "Date")
    String date;

    @XmlAttribute(name = "Name")
    String name;

    @XmlAttribute(name = "Description")
    String description;

    @XmlElement(name = "ValType")
    List<ValType> typeList;

}
