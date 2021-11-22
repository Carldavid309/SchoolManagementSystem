package com.finals.SMS.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerForm {
    private Integer id;
    //ポイント1
    @NotBlank
    @Size(min = 1, max = 20)
    private String name;
    @Size(max = 100)
    private String email;
}