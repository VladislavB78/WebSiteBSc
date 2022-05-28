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
    @Query("update MyOrder m set m.order_status.id = ?1 where m.customer.id = ?2")
    void updateOrder_statusIdByCustomer_Id(Integer s_id, Integer c_id);
}
