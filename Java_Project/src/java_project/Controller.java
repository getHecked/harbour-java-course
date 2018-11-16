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
public class Controller {

    Humidity_sensor humid;
    Intrusion_sensor intrusion;
    Smoke_sensor smoke;
    Temp_sensor temp;

    public Controller(Humidity_sensor humid, Intrusion_sensor intrusion, Smoke_sensor smoke, Temp_sensor temp) {
        this.humid = humid;
        this.intrusion = intrusion;
        this.smoke = smoke;
        this.temp = temp;
    }

    public Humidity_sensor getHumid() {
        return humid;
    }

    public void setHumid(Humidity_sensor humid) {
        this.humid = humid;
    }

    public Intrusion_sensor getIntrusion() {
        return intrusion;
    }

    public void setIntrusion(Intrusion_sensor intrusion) {
        this.intrusion = intrusion;
    }

    public Smoke_sensor getSmoke() {
        return smoke;
    }

    public void setSmoke(Smoke_sensor smoke) {
        this.smoke = smoke;
    }

    public Temp_sensor getTemp() {
        return temp;
    }

    public void setTemp(Temp_sensor temp) {
        this.temp = temp;
    }
    
    

    
}
