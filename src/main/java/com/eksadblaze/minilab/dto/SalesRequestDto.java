package com.eksadblaze.minilab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesRequestDto {

    private String salesId;
    private String salesName;
    private String dealerId;
    private String supervisorId;
    private String salesGender;
    private String salesEmail;
    private String salesStatus;

}
