package com.example.WebSiteCoursework.repositories;

import com.example.WebSiteCoursework.entities.MyOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MyOrderRepository extends CrudRepository<MyOrder, Integer> {

    @Query("select m from MyOrder m where m.customer.id = ?1")
    List<MyOrder> findByCustomer_Id(Integer id);

    @Transactional
    @Modifying
    @Query("update MyOrder m set m.orderStatus.id = ?1, m.orderNumber = ?2 where m.customer.id = ?3")
    void updateOrderStatusIdAndOrderNumberByCustomer_Id(Integer s_id, String orderNumber, Integer c_id);

    @Transactional
    @Modifying
    @Query("update MyOrder m set m.orderStatus.id = ?1 where m.orderNumber = ?2")
    void updateOrderStatusIdByOrderNumber(Integer s_id, String orderNumber);

    @Query("select m from MyOrder m where m.orderStatus.id = ?1")
    List<MyOrder> findByOrderStatus_Id(Integer s_id);

    @Query("select m from MyOrder m where m.orderNumber = ?1")
    List<MyOrder> findByOrderNumber(String orderNumber);
}
