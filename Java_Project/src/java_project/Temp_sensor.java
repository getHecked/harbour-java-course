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
public class Temp_sensor {
    public boolean status;
    public int default_temp;

    public Temp_sensor(boolean status, int default_temp) {
        this.status = status;
        this.default_temp = default_temp;
    }

    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDefault_temp() {
        return default_temp;
    }

    public void setDefault_temp(int default_temp) {
        this.default_temp = default_temp;
    }
    
    
    
}
