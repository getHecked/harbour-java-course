/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

/**
 *
 * @author Arjun
 */
public class Smoke_sensor {
    public int battery_level;
    public String status;
    public String emergency_contact;

    public Smoke_sensor(int battery_level, String status) {
        this.battery_level = battery_level;
        this.status = status;
    }

    public int getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(int battery_level) {
        this.battery_level = battery_level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }
    
    
}
