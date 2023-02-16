package com.github.spacenail.market.service;

import com.github.spacenail.market.Model.Product;
import com.github.spacenail.market.Model.User;
import com.github.spacenail.market.repo.ProductRepo;
import com.github.spacenail.market.repo.RoleRepo;
import com.github.spacenail.market.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceData {
    private ProductRepo repo;
@Autowired
    public void setRepo(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
    return repo.findAll();
    }

    public void deleteProductById(Long id) {
    repo.deleteById(id);
    }

    public void addProduct(Product product) {
    product.setId(0L);
    repo.save(product);
    }

    public void updateProduct(Product product) {
    repo.save(product);
    }

    public Product getProduct(Long id) {
    return repo.findById(id).orElseThrow();
    }

    public static class CustomUserDetailService implements UserDetailsService {
        private UserRepo userRepo;
        private RoleRepo roleRepo;
        @Autowired
        private void setUserRepo(UserRepo userRepo){
            this.userRepo = userRepo;
        }
        @Autowired
        private void setRoleRepo(RoleRepo roleRepo){
            this.roleRepo = roleRepo;
        }
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepo.findByName(username).orElseThrow(
                    () ->new UsernameNotFoundException(username));
            return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),
                    user.getRoles().stream().
                            map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }
    }
}
