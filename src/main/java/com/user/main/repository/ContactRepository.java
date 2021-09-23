package com.user.main.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.main.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Serializable>{

}
