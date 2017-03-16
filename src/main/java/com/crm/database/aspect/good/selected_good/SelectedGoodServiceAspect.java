package com.crm.database.aspect.good.selected_good;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.service.FactoryService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Bohdan on 17.03.2017.
 */
@Aspect
@Component
public class SelectedGoodServiceAspect
{

    @Pointcut("execution(* com.crm.database.service.good.selected_good.SelectedGoodService.saveEntry(*)) && args(good)")
    private void pointcutSaveEntry(SelectedGood good)
    {

    }

    @Pointcut("execution(* com.crm.database.service.good.selected_good.SelectedGoodService.saveOrUpdate(*)) && args(good)")
    private void pointcutSaveOrUpdate(SelectedGood good)
    {

    }

    @Pointcut("execution(* com.crm.database.service.good.selected_good.SelectedGoodService.updateEntry(*)) && args(good)")
    private void pointcutUpdate(SelectedGood good)
    {

    }

    @Before(value = "pointcutSaveOrUpdate(good) || pointcutSaveEntry(good) || pointcutUpdate(good)", argNames = "good")
    private void beforeSave(SelectedGood good)
    {
        Good goodInStore = FactoryService.getGoodService().getEntryByField("nomination", good.getNomination());
        goodInStore.setAmount(goodInStore.getAmount() - good.getAmount());
        FactoryService.getGoodService().updateEntry(goodInStore);
    }

    @Pointcut("execution(* com.crm.database.service.good.selected_good.SelectedGoodService.deleteEntry(*)) && args(id)")
    private void pointcutDelete(Long id)
    {

    }

    private Good goodInStore;
    private SelectedGood selectedGood;

    @Before(value = "pointcutDelete(id)", argNames = "id")
    private void beforeDelete(Long id)
    {
        selectedGood = FactoryService.getSelectedGoodService().getEntry(id);

        goodInStore = FactoryService.getGoodService().getEntryByField("nomination", selectedGood.getNomination());
    }

    @After(value = "pointcutDelete(id)", argNames = "id")
    private void afterDelete(Long id)
    {
        goodInStore.setAmount(goodInStore.getAmount() + selectedGood.getAmount());
    }
}
