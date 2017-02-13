package com.crm;

import com.crm.entity.employee.Employee;
import com.crm.managers.JsonFileManager;

import java.io.IOException;

/**
 * Created by Prigovor on 12.02.2017.
 */
public class JSONSample {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("Lora");
        employee.setSurname("Rouslin");
        employee.setEmail("imrahill120@gmail.com");

        try {
            JsonFileManager.serializeToJsonFile(employee, "D:\\lora.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
