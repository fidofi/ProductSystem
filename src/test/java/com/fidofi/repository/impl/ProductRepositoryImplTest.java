package com.fidofi.repository.impl;

import com.fidofi.model.Page;
import com.fidofi.model.Product;
import com.fidofi.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fido on 2017/10/2.
 * dao操作的单元测试
 */
public class ProductRepositoryImplTest {
  private ProductRepository productRepository=new ProductRepositoryImpl();

  @Test
    public void create() throws Exception {
       Product product=new Product();
       product.setCategoryCode(3);
       product.setProductDescription("测试删除3");
       product.setProductName("批量删除3");
       product.setProductPrice(10.0F);
       product.setProductPhoto("www.dssdfwio.jpg");
       productRepository.create(product);
    }


    //@Test
    public void delete() throws Exception {
        Product product=productRepository.readByCategoryCode("8501893150691");
        productRepository.delete(product.getProductBarCode());
    }


   // @Test
    public void update() throws Exception {
        Product product=productRepository.readByCategoryCode("8501893150691");
        product.setProductName("更新名字");
        product.setProductDescription("更新描述");
         productRepository.update(product);
    }


   // @Test
    public void read() throws Exception {
        Page page=new Page();
        page.setIndex(1);
        List<Product> product=productRepository.readAll(page);
        System.out.println(product);

    }


  //  @Test
    public void readByProductName() throws Exception {
        Page page=new Page();
        page.setIndex(1);
        List<Product> productList= productRepository.readByProductName("大西瓜",page);
        System.out.println(productList.size());
        for(Product product:productList){
            System.out.println(product.toString());
        }
    }


   // @Test
    public void readByCategoryCode() throws Exception {

    }
   // @Test
    public void deleteByList()throws Exception{
        List<String> productBarCodeList=new ArrayList<String>();
        productBarCodeList.add("3690565150692");
        productBarCodeList.add("3549450150692");
        productBarCodeList.add("3308818150692");
        productRepository.deleteByList(productBarCodeList);
    }
  //  @Test
    public void testCount(){
        System.out.println(productRepository.count());
    }

 }