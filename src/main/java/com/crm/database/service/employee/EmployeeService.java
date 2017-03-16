package com.crm.database.service.employee;

import com.crm.database.entity.employee.Employee;
import com.crm.database.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Bohdan on 08.02.2017.
 */
@Service
public class EmployeeService extends GenericServiceImpl<Employee, Long>
{
    @Override
    public Long saveEntry(Employee entry)
    {
        return super.saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(Employee entry)
    {
        super.saveOrUpdate(entry);
    }

    @Override
    public void updateEntry(Employee entry)
    {
        super.updateEntry(entry);
    }
}
