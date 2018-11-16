/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arjun
 */
public class Intrusion_sensor {

    public Map<String, String> lasers =  new HashMap<String, String>();;

    public String status;
    public boolean state=false;

    public Intrusion_sensor(Map<String, String> lasers, boolean state) {
        this.lasers = lasers;
        this.status = status;
        this.state = state;
    }

    public Map<String, String> getLasers() {
        return lasers;
    }

    public void setLasers(Map<String, String> lasers) {
        this.lasers = lasers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
