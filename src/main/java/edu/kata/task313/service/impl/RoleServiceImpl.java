package edu.kata.task313.service.impl;

import edu.kata.task313.entity.Role;
import edu.kata.task313.repository.RoleRepository;
import edu.kata.task313.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role not found by id: " + id)
        );
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role entity) {
        throw new RuntimeException("Not allowed");
    }

    @Override
    public void remove(Long id) {
        throw new RuntimeException("Not allowed");
    }
}
