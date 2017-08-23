package com.carledwin.ti.user.rest.api.service;

import org.springframework.data.repository.CrudRepository;

import com.carledwin.ti.user.rest.api.model.User;

public interface UserService extends CrudRepository<User, Long> {

}
