package com.crm.database.service.good.selected_good;

import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Bohdan on 01.03.2017.
 */
@Service
public class SelectedGoodService extends GenericServiceImpl<SelectedGood, Long>
{
    @Override
    public Long saveEntry(SelectedGood entry)
    {
        return super.saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(SelectedGood entry)
    {
        super.saveOrUpdate(entry);
    }

    @Override
    public void updateEntry(SelectedGood entry)
    {
        super.updateEntry(entry);
    }

    @Override
    public void deleteEntry(Long id)
    {
        super.deleteEntry(id);
    }
}
