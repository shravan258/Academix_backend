package com.academix_teacher.proxy;

import com.sharedclasses.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="organization-service")
public interface TeacherProxy {

        @GetMapping("/{orgcode}/addteacher/{teacherId}")
        public StandardResponse addTeacherToOrg(@PathVariable Integer teacherId, @PathVariable String orgcode);


}
