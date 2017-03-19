package com.crm.database.aspect.order;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.service.FactoryService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

/**
 * Created by Bohdan on 17.03.2017.
 */
@Aspect
@Component
public class OrderServiceAspect
{
    @Pointcut("execution(* com.crm.database.service.order.OrderService.saveEntry(*)) && args(order)")
    private void pointcutSaveEntry(Order order)
    {

    }

    @Pointcut("execution(* com.crm.database.service.order.OrderService.saveOrUpdate(*)) && args(order)")
    private void pointcutSaveOrUpdate(Order order)
    {

    }

    @Pointcut("execution(* com.crm.database.service.order.OrderService.updateEntry(*)) && args(order)")
    private void pointcutUpdate(Order order)
    {

    }

    @Before(value = "pointcutSaveOrUpdate(order) || pointcutSaveEntry(order) || pointcutUpdate(order)", argNames = "order")
    private void beforeSave(Order order)
    {
        if (order.getGoods() != null)
        {
            if (order.getId() != null)
            {
                Order orderEntry = FactoryService.getOrderService().getEntry(order.getId(), order1 ->
                {
                    Hibernate.initialize(order1.getGoods());
                });

                for (SelectedGood selectedGood : orderEntry.getGoods())
                {
                    Good goodInStore = selectedGood.getGoodInStore();
                    FactoryService.getGoodService().updateEntry(goodInStore);
                }
            }
            else
            {
                for (SelectedGood selectedGood : order.getGoods())
                {
                    Good goodInStore = selectedGood.getGoodInStore();
                    FactoryService.getGoodService().updateEntry(goodInStore);
                }
            }
        }
    }

    @Pointcut("execution(* com.crm.database.service.order.OrderService.deleteEntry(*)) && args(id)")
    private void pointcutDelete(Long id)
    {

    }

    private Order order;

    @Before(value = "pointcutDelete(id)", argNames = "id")
    private void beforeDelete(Long id)
    {
        order = FactoryService.getOrderService().getEntry(id, orderEntry ->
        {
            Hibernate.initialize(orderEntry.getGoods());
        });
    }

    @After(value = "pointcutDelete(id)", argNames = "id")
    private void afterDelete(Long id)
    {
        if (!order.getOrderStatus().equals(OrderStatus.CLOSED))
        {
            for (SelectedGood selectedGood : order.getGoods())
            {
                Good goodInStore = FactoryService.getGoodService().getEntryByField("nomination", selectedGood.getName());
                goodInStore.setAmount(goodInStore.getAmount() + selectedGood.getAmount());

                FactoryService.getGoodService().updateEntry(goodInStore);
            }
        }
    }
}
