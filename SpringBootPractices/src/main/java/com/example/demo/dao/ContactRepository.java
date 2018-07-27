package com.example.demo.dao;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Contact;

public interface ContactRepository extends MongoRepository<Contact, Long>{//JpaRepository<Contact, Long>{ //MongoRepository<Contact, Long>{

}
