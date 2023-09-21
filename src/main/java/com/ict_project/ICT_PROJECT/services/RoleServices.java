package com.ict_project.ICT_PROJECT.services;

import com.ict_project.ICT_PROJECT.model.RoleModel;
import com.ict_project.ICT_PROJECT.repository.RoleRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class RoleServices {
    private final RoleRepository roleRepository;

    public RoleModel saveRole(RoleModel role) {
        return roleRepository.save(role);
    }

    public List<RoleModel> getAllRole() {
        return roleRepository.findAll();
    }

    public Optional<RoleModel> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public RoleModel updateRole(Long id, RoleModel roleModel) {
        Optional<RoleModel> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            RoleModel existingRole = optionalRole.get();
            existingRole.setRoleName(roleModel.getRoleName());
            return roleRepository.save(existingRole);
        } else {
            return null;
        }
    }

    public RoleModel deleteRole(Long id) {
        Optional<RoleModel> roleToDelete = roleRepository.findById(id);
        if (roleToDelete.isPresent()) {
            roleRepository.deleteById(id);
            return roleToDelete.get();
        } else {
            return null;
        }
    }
}
