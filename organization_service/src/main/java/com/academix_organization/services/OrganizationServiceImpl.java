package com.academix_organization.services;

import com.academix_organization.Exceptions.DuplicateOrganizationException;
import com.academix_organization.dao.OrganizationDAO;
import com.academix_organization.dto.OrganizationRequest;
import com.academix_organization.entity.Organization;
import com.sharedclasses.StandardResponse;
import com.sharedclasses.UniqueCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationDAO organizationdao;


    @Override
    public StandardResponse addOrganization(OrganizationRequest new_organization) throws DuplicateOrganizationException {
        Organization temp_org = organizationdao.findByOrganizationEmail(new_organization.getOrganization_email());
        if(temp_org != null){
             StandardResponse response = new StandardResponse("organizattion with this email already exists",null,false);
             return response;
        }else{
            Organization new_org = new Organization();
            new_org.setOrganization_name(new_organization.getOrganization_name());
            new_org.setOrganization_address(new_organization.getOrganization_address());
            new_org.setOrganization_contact(new_organization.getOrganization_contact());
            new_org.setOrganization_email(new_organization.getOrganization_email());
            new_org.setOrganization_code(UniqueCodeService.generateUniqueCode());
            organizationdao.save(new_org);
            StandardResponse  response = new StandardResponse("organization created successfully",new_org,true);
            return response;
        }
    }

    @Override
    public StandardResponse addTeacherToOrg(Integer teacherId,String orgCode) {
        Organization tempOrg = organizationdao.findByOrganizationCode(orgCode);
        if(tempOrg == null){
            return new StandardResponse("no organization exists with this code",null,false);
        }else{
            List<Integer> org_teachers = tempOrg.getOrganization_teachers_id();
            if(org_teachers.contains(teacherId)){
                return new StandardResponse("teacher already exits with this id in organization",null,false);
            }else{
                tempOrg.addTeacher(teacherId);
                organizationdao.save(tempOrg);
                return new StandardResponse("teacher added successfully",tempOrg,true);
            }
        }
    }


}
