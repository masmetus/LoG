package ru.vlsu.VLSU.persist;

import org.springframework.format.annotation.DateTimeFormat;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_computer")
    private Computer computer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date LicenseStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date LicenseEnd;

    private Integer TypeLicense_ID;

    @Column(name = "ID_Software", insertable = false, updatable = false)
    private Integer softwareId;

    @ManyToOne
    @JoinColumn(name = "ID_enginere")
    private User user;

    private Date InstallationDate;

    @Column(name = "work_status")
    private boolean WorkStatus;


    public Installedsoftware() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(Integer softwareId) {
        this.softwareId = softwareId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean getWorkStatus() {
        return WorkStatus;
    }

    public void setWorkStatus(boolean workStatus) {
        WorkStatus = workStatus;
    }

    public Date getInstallationDate() {
        return InstallationDate;
    }

    public void setInstallationDate(Date installationDate) {
        InstallationDate = installationDate;
    }
}
