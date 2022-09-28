package com.library.app.service;

import com.library.app.model.Book;
import com.library.app.model.User;
import com.library.app.repository.BookRepository;
import com.library.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;

    @Override
    public User saveUser(User u) {
        return repository.save(u);
    }

    @Override
    public User findUserByEmail(String email) {

        User searchUser= null;
        List<User> allUsers = repository.findAll();
        for (int i = 0; i < allUsers.size(); i++) {
            if(allUsers.get(i).getEmail().equals(email)){
                searchUser= allUsers.get(i);
                break;
            }
        }
        return searchUser;
    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) {
        User searchUser= null;
        List<User> allUsers = repository.findAll();
        for (int i = 0; i < allUsers.size(); i++) {
            if(allUsers.get(i).getPhoneNumber().equals(phoneNumber)){
                searchUser= allUsers.get(i);
                break;
            }
        }
        return searchUser;
    }

    @Override
    public void deleteUserByID(Long id) {
        Optional<User> searchUser= repository.findById(id);
        if(searchUser.isPresent()){
            repository.deleteById(id);
        }
    }

    @Override
    public User findUserByID(Long id) {
        Optional<User> searchUser = repository.findById(id);
        User user= null;
        if(searchUser.isPresent()){
            user = repository.findById(id).get();
        }
        return user;
    }

    @Override
    public User updateUser(User u) {
        return repository.save(u);
    }

    @Override
    public List<User> findAllUser() {
        return repository.findAll();
    }
}
