package com.ict_project.ICT_PROJECT.services;

import com.ict_project.ICT_PROJECT.model.StaffModel;
import com.ict_project.ICT_PROJECT.repository.StaffRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Builder
@RequiredArgsConstructor
public class StaffServices {
    private final StaffRepository staffRepository;

    public StaffModel saveStaff(StaffModel staff) {
        return staffRepository.save(staff);
    }

    public List<StaffModel> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<StaffModel> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    public StaffModel updateStaff(Long id, StaffModel staffModel) {
        Optional<StaffModel> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()) {
            StaffModel existingStaff = optionalStaff.get();
            existingStaff.setFirstName(staffModel.getFirstName());
            existingStaff.setMiddleName(staffModel.getMiddleName());
            existingStaff.setLastName(staffModel.getLastName());
            existingStaff.setAddress(staffModel.getAddress());
            existingStaff.setEmail(staffModel.getEmail());
            existingStaff.setGender(staffModel.getGender());
            existingStaff.setBirthDate(staffModel.getBirthDate());
            existingStaff.setDateHired(staffModel.getDateHired());
            existingStaff.setDepartment(staffModel.getDepartment());
            existingStaff.setStatus(staffModel.getStatus());
            existingStaff.setEmploymentType(staffModel.getEmploymentType());
            existingStaff.setMaritalStatus(staffModel.getMaritalStatus());
            existingStaff.setNationality(staffModel.getNationality());
            existingStaff.setWorkLocation(staffModel.getWorkLocation());
            existingStaff.setSalaryScale(staffModel.getSalaryScale());
            return staffRepository.save(existingStaff);
        } else {
            return null;
        }
    }

    public StaffModel deleteStaff(Long id) {
        Optional<StaffModel> staffToDelete = staffRepository.findById(id);
        if (staffToDelete.isPresent()) {
            staffRepository.deleteById(id);
            return staffToDelete.get();
        } else {
            return null;
        }
    }
}
