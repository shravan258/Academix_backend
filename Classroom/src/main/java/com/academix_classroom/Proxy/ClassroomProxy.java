package com.academix_classroom.Proxy;


import com.sharedclasses.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "teacher-service")
public interface ClassroomProxy {
    @GetMapping("/teacher/{id}/addclassroom/{classroom_id}")
    public StandardResponse addClassroom(@PathVariable Integer id, @PathVariable Integer classroom_id);
}
