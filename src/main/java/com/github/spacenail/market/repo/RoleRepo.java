package com.github.spacenail.market.repo;

import com.github.spacenail.market.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
