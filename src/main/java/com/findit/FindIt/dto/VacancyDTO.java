package com.findit.FindIt.dto;

import com.findit.FindIt.entity.Organization;
import com.findit.FindIt.entity.Recruiter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class VacancyDTO {

    private Long id;

    private String title;

    private String description;

    private String taskLink;

    private String organization;

    private String recruiter;
    private String price;
    private List<Long> users;
}
