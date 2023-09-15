package edu.tcu.cs.storeonline.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Ewallet implements Serializable {
    @Id
    private String id;
    private String balance;
    private String creationTime;
    private String lastModifiedTime;
    private String status;

    public Ewallet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    //change this with user purchase of
    public void setBalance(String balance) {

        this.balance = balance;
    }

    public String getCreationTime() {

        return creationTime;
    }

    public void setCreationTime(String creationTime) {

        this.creationTime = creationTime;
    }

    public String getLastModifiedTime() {

        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {

        this.lastModifiedTime = lastModifiedTime;
    }

    public String getStatus() {

        return status;
    }

    //user will pass in Normal or Frozen and using that Stirng parameter, we will decide if we will do a transaction
    public void setStatus(String status) {

        this.status = status;
    }

}
