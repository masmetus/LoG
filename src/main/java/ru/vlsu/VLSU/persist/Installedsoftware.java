package ru.vlsu.VLSU.persist;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "installedsoftware")
public class Installedsoftware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Software")
    private Software software;

    @ManyToOne
    @JoinColumn(name = "ID_computer")
    private Computer computer;

    private Date LicenseStart;

    private Date LicenseEnd;

    private Integer TypeLicense_ID;

    private Integer ID_enginere;

    private Date InstallationDate;

    private boolean WorkStatus;

    private Integer ID_room;

    public Installedsoftware() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Date getLicenseStart() {
        return LicenseStart;
    }

    public void setLicenseStart(Date licenseStart) {
        LicenseStart = licenseStart;
    }

    public Date getLicenseEnd() {
        return LicenseEnd;
    }

    public void setLicenseEnd(Date licenseEnd) {
        LicenseEnd = licenseEnd;
    }

    public Integer getTypeLicense_ID() {
        return TypeLicense_ID;
    }

    public void setTypeLicense_ID(Integer typeLicense_ID) {
        TypeLicense_ID = typeLicense_ID;
    }

    public Integer getID_enginere() {
        return ID_enginere;
    }

    public void setID_enginere(Integer ID_enginere) {
        this.ID_enginere = ID_enginere;
    }

    public boolean isWorkStatus() {
        return WorkStatus;
    }

    public void setWorkStatus(boolean workStatus) {
        WorkStatus = workStatus;
    }

    public Integer getID_room() {
        return ID_room;
    }

    public void setID_room(Integer ID_room) {
        this.ID_room = ID_room;
    }

    public Date getInstallationDate() {
        return InstallationDate;
    }

    public void setInstallationDate(Date installationDate) {
        InstallationDate = installationDate;
    }
}
