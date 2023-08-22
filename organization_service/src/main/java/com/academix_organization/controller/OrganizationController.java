package com.academix_organization.controller;


import com.academix_organization.Exceptions.DuplicateOrganizationException;
import com.academix_organization.dto.OrganizationRequest;
import com.academix_organization.services.OrganizationService;
import com.sharedclasses.StandardResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Validated
public class OrganizationController {

    @Autowired
    private OrganizationService orgservice;

    @Autowired
    private Validator validator;
    @PostMapping("/addorg")
    public StandardResponse addOrganization (@RequestBody  OrganizationRequest new_organization) throws DuplicateOrganizationException {
        Set<ConstraintViolation<OrganizationRequest>> violations = validator.validate(new_organization);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder();

            for (ConstraintViolation<OrganizationRequest> violation : violations) {
                String defaultMessage = violation.getMessage();
                errorMessage.append(defaultMessage).append("\n");
            }
            return new StandardResponse(errorMessage.toString(),null,false);
        } else {
             return  orgservice.addOrganization(new_organization);

        }
    }

    @GetMapping("/{orgcode}/addteacher/{teacherId}")
    public StandardResponse addTeacherToOrg(@PathVariable Integer teacherId,@PathVariable String orgcode){
        return orgservice.addTeacherToOrg(teacherId, orgcode);
    }




}
