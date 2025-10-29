package com.cybersoft.bai5.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssignRolesRequest {
    @NotEmpty
    private List<Long> roleIds;
}
