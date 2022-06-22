package com.stockinfo.ops.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.stockinfo.ops.repository.StocksInfoRepository;
import com.stockinfo.ops.model.StocksInfo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class StocksInfoController {
  @Autowired
  StocksInfoRepository stocksInfoRepository;
  //@Autowired private StocksInfoService stocksInfoService;

  //GET /api/stocks (get a list of stocks)
  @RequestMapping(value = "/stocks", method = RequestMethod.GET)
  Page<StocksInfo> stocksInfoPageable(Pageable pageable) {
    return stocksInfoRepository.findAll(pageable);
  }
    
  //POST /api/stocks (create a stock)
  @PostMapping("/stocks")
  public ResponseEntity<StocksInfo> createStock(@RequestBody StocksInfo stocksInfo) 
  {
    try {
      StocksInfo inputStocksInfo = new StocksInfo();
      inputStocksInfo.setStock_num(stocksInfo.getStock_num());
      inputStocksInfo.setStock_id(stocksInfo.getStock_id());
      inputStocksInfo.setStock_name(stocksInfo.getStock_name());
      inputStocksInfo.setStock_price(stocksInfo.getStock_price());
      inputStocksInfo.setStock_lastupdatedon(stocksInfo.getStock_lastupdatedon());
      StocksInfo _stocksInfo = stocksInfoRepository.save(inputStocksInfo);
      return new ResponseEntity<>(_stocksInfo, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  //GET /api/stocks/1 (get one stock from the list)
  @GetMapping("/stocks/{id}")
  public ResponseEntity<StocksInfo> getStocksInfoById(@PathVariable("id") Long id) 
  {
    Optional<StocksInfo> stocksData = stocksInfoRepository.findById(id);
    if (stocksData.isPresent()) {
      return new ResponseEntity<>(stocksData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  //PATCH /api/stocks/1 (update the price of a single stock)
  //@PatchMapping("/stocks/{id}/{stock_price}") -- for passing stock_price as param
  @PatchMapping("/stocks/{id}")
  public ResponseEntity<StocksInfo> updateStockPrice(@PathVariable("id") Long id, @RequestBody StocksInfo inputStocksInfo) 
  {
      try {
          StocksInfo stocksInfo = stocksInfoRepository.findById(id).get();
          stocksInfo.setStock_price(inputStocksInfo.getStock_price());
          return new ResponseEntity<StocksInfo>(stocksInfoRepository.save(stocksInfo), HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  //DELETE/api/stocks/1 (delete a single stock)
  @DeleteMapping("/stocks/{id}")
  public String deleteStocksInfoById(@PathVariable("id")
                                      Long stock_id)
  {
      try {  
        stocksInfoRepository.deleteById(stock_id);
        return "Stock Deleted Successfully";
      } catch (Exception e) {
        return "Stock Not Found";
      }
  }

}
