package com.asif.phonebookminiprojectone.Repository;

import com.asif.phonebookminiprojectone.Dao.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

    public List<Contact> findByActiveSwitch(String str);
}
