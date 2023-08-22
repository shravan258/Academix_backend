package com.academix_organization.dao;

import com.academix_organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganizationDAO extends JpaRepository<Organization, Integer> {

    @Query("SELECT o FROM Organization o WHERE o.organization_email = :email")
    Organization findByOrganizationEmail(@Param("email") String email);

    @Query("SELECT o FROM Organization o WHERE o.organization_code = :code")
    Organization findByOrganizationCode(@Param("code") String code);

}
