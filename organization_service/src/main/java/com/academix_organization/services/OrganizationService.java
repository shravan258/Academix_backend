package com.academix_organization.services;

import com.academix_organization.Exceptions.DuplicateOrganizationException;
import com.academix_organization.dto.OrganizationRequest;
import com.sharedclasses.StandardResponse;

public interface OrganizationService {

    public StandardResponse addOrganization(OrganizationRequest new_organization) throws DuplicateOrganizationException;

    public StandardResponse addTeacherToOrg(Integer teacherId,String orgCode);


}
