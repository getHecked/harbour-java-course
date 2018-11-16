/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

import Frames.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Arjun
 */
public class Java_Project_main {

  
    public static void main(String[] args) {
     
        Temp_sensor temp = new Temp_sensor(false,25);
        Humidity_sensor humid_sensor = new Humidity_sensor("45%");
        Smoke_sensor smoke = new Smoke_sensor(70, "OK");
        Map<String,String> map = new HashMap<String, String>();
        map.put("Laser1", "Ready");
        map.put("Laser2", "Ready");
        Intrusion_sensor sensor = new Intrusion_sensor(map, true);
        
        Controller main = new Controller(humid_sensor, sensor, smoke, temp);
        
        Start_controller controller = new Start_controller(main);
        
        controller.show();
        
        
        
        
        
   
        
    }
    
}
