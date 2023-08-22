package com.academix_student.proxy;


import com.sharedclasses.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "classroom-service")
public interface StudentProxy {
    @GetMapping("addtoclassroom/{code}/student/{student_id}")
    public StandardResponse addstudenttoclassroom(@PathVariable String code, @PathVariable Integer student_id);
}
