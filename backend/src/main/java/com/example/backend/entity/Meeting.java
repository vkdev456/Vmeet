package com.example.backend.entity;

import java.time.LocalDate;
>>>>>>> main
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String userId;

    @NotNull
    private String meetingCode;

    @NotNull
    private LocalDate date;
 
    public Meeting(){

    }

    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
         this.Id=Id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    public void setMeetingCode(String meetingCode) {
        this.meetingCode = meetingCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
