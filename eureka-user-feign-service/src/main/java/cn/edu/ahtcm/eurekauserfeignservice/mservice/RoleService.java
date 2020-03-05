package cn.edu.ahtcm.eurekauserfeignservice.mservice;
import cn.edu.ahtcm.common.entity.Role;
import cn.edu.ahtcm.eurekauserfeignservice.mservice.fb.RoleServiceFB;
import feign.Param;import org.springframework.cloud.openfeign.FeignClient;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.ResponseBody;import java.util.List;
@FeignClient(value = "role-service",fallback = RoleServiceFB.class)
public interface RoleService {

    @GetMapping("listRoles")
    List<Role> getUserRoles(@RequestParam("id") Integer id);
}
