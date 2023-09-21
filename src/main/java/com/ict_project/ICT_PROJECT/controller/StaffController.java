package com.ict_project.ICT_PROJECT.controller;

import com.ict_project.ICT_PROJECT.model.StaffModel;
import com.ict_project.ICT_PROJECT.services.StaffServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/staff")
public class StaffController {
    private final StaffServices staffServices;

    @PostMapping("/add")
    public ResponseEntity<?> saveStaff(@RequestBody StaffModel request) {
        StaffModel response = staffServices.saveStaff(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<StaffModel>> getAllStaff() {
        List<StaffModel> response = staffServices.getAllStaff();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStaffById(@PathVariable Long id){
        Optional<StaffModel> response = staffServices.getStaffById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StaffModel> updateStaff(@PathVariable Long id, @RequestBody StaffModel staffModel){
        StaffModel response = staffServices.updateStaff(id, staffModel);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StaffModel> deleteStaff(@PathVariable Long id) {
        StaffModel deletedStaff = staffServices.deleteStaff(id);

        if (deletedStaff != null) {
            return ResponseEntity.ok(deletedStaff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
