package ru.vlsu.VLSU.persist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstalledsoftwareRerository extends JpaRepository<Installedsoftware, Integer> {
    Installedsoftware findByComputerIdAndSoftwareId(Integer computerId, Integer softwareId );

}
