package com.stockinfo.ops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stockinfo.ops.model.StocksInfo;
/*
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
*/

//@Repository
public interface StocksInfoRepository extends JpaRepository<StocksInfo, Long> 
{
    //Page<StocksInfo> findByStock_id(String stock_id, Pageable pageable);
    //Page<StocksInfo> findByStock_name(String stock_name, Pageable pageable);
}
    