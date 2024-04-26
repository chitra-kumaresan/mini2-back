package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.DoctorDto;
import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.exception.ResourceNotFoundException;
import com.example.mini2_backend.mapper.DoctorMapper;
import com.example.mini2_backend.repo.DoctorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class DoctorServiceImpl implements  DoctorService{
    private DoctorRepo doctorRepo;
    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor =DoctorMapper.mapToDoctor(doctorDto);
            Doctor appointment1 =doctorRepo.save(doctor);
            return DoctorMapper.mapToDoctorDto(appointment1);
        }

        @Override
        public DoctorDto getDoctorById(Long docId) {
        Doctor doctor1=doctorRepo.findById(docId)
                    .orElseThrow(()->new ResourceNotFoundException("Doctor", "id" ,docId));
            return DoctorMapper.mapToDoctorDto(doctor1);

        }
    @Override
        public List<DoctorDto> getAllDoctors() {
            List<Doctor> employees =doctorRepo.findAll();
            return employees.stream()
                    .map((DoctorMapper::mapToDoctorDto))
                    .collect(Collectors.toList());
        }

    @Override
    public DoctorDto updateDoctor(Long docId, DoctorDto updatedDoctor) {
        Doctor doctor=doctorRepo.findById(docId)
                .orElseThrow(()->new ResourceNotFoundException("Doctor", "id" ,docId));
        doctor.setDoctorName(updatedDoctor.getDoctorName());
        doctor.setSpecialist(updatedDoctor.getSpecialist());
        doctor.setExperience(updatedDoctor.getExperience());
        doctor.setAge(updatedDoctor.getAge());
        doctor.setEmail(updatedDoctor.getEmail());
        doctor.setContactNo(updatedDoctor.getContactNo());

        Doctor updated=doctorRepo.save(doctor);
        return DoctorMapper.mapToDoctorDto(updated);
    }
    @Override
    public void deleteDoctor(Long docId) {
        doctorRepo.findById(docId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", docId));
        doctorRepo.deleteById(docId);
    }

    }
