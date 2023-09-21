package com.ict_project.ICT_PROJECT.controller;

import com.ict_project.ICT_PROJECT.model.RoleModel;
import com.ict_project.ICT_PROJECT.services.RoleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/role")
public class RoleController {
    private final RoleServices roleServices;

    @PostMapping("/add")
    public ResponseEntity<?> saveRole(@RequestBody RoleModel request) {
        RoleModel response = roleServices.saveRole(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<RoleModel>> getAllRole() {
        List<RoleModel> response = roleServices.getAllRole();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id){
        Optional<RoleModel> response = roleServices.getRoleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoleModel> updateRole(@PathVariable Long id, @RequestBody RoleModel roleModel){
        RoleModel response = roleServices.updateRole(id, roleModel);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RoleModel> deleteRole(@PathVariable Long id) {
        RoleModel deletedRole = roleServices.deleteRole(id);

        if (deletedRole != null) {
            return ResponseEntity.ok(deletedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
