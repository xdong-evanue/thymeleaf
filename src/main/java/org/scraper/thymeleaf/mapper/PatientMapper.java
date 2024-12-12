package org.scraper.thymeleaf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.scraper.thymeleaf.entity.Patient;

import java.util.List;

@Mapper
public interface PatientMapper {

    @Insert("INSERT INTO patients (name, phoneNumber) VALUES (#{name}, #{phoneNumber})")
    void insert(Patient patient);

    @Select("SELECT * FROM patients")
    List<Patient> findAll();

    @Select("SELECT TOP 1 * FROM patients WHERE phoneNumber = #{phoneNumber}")
    Patient findByPhoneNumber(String phoneNumber);

    @Update("UPDATE patients SET name = #{name}, phoneNumber = #{phoneNumber} WHERE id = #{id}")
    void update(Patient patient);

    @Update("DELETE FROM patients WHERE phoneNumber = #{phoneNumber}")
    void deleteByPhoneNumber(String phoneNumber);
}
