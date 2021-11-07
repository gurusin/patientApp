package com.opdapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StrengthUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long unitId;
    private String unitName;

}
