package com.fidofi.dto;


import com.fidofi.vo.ProductVO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fido on 2017/11/29.
 * 用户购物车
 */
public class Card {
    private Map<String, Integer> map;//存放条形码和对应数量
    private Float moneyNum;//总金额
    private Map<ProductVO, Integer> productMap;//存放商品及对应数量

    public Card() {
        this.map = new HashMap<String, Integer>();
        this.productMap = new HashMap<ProductVO, Integer>();
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Float getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(Float moneyNum) {
        this.moneyNum = moneyNum;
    }

    public Map<ProductVO, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductVO, Integer> productMap) {
        this.productMap = productMap;
    }

    @Override
    public String toString() {
        return "Card{" +
                "map=" + map +
                ", moneyNum=" + moneyNum +
                ", productMap=" + productMap +
                '}';
    }
}
