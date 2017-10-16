package com.fidofi.controller;

import com.fidofi.constant.DBConstant;
import com.fidofi.model.Product;
import com.fidofi.service.ProductService;
import com.fidofi.service.impl.ProductServiceImpl;
import com.fidofi.utils.CategoryCodeUtils;
import com.fidofi.utils.CharsetChangeUtils;
import com.fidofi.utils.PhotoNameUtils;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fido on 2017/10/3.
 * 增加商品
 */
public class SaveServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    //增加商品
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //对应表单传过来的名称和值
        HashMap<String, Object> values = new HashMap<String, Object>();
        request.setCharacterEncoding("UTF-8");
        // 检查是否是表单文件上传请求
        String productPhoto=null;

        try {
//            String location=DBConstant.location.substring(0,DBConstant.location.indexOf("WEB-INF"))+"imag/";
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            //  创建上传对象
            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iter = upload.getItemIterator(request); //得到所有的上传数据
            while (iter.hasNext()) { //循环上传表单的元素
                FileItemStream item = iter.next();
                String name = item.getFieldName(); //得到元素名
                InputStream stream = item.openStream();
                if (item.isFormField()) { //如果是普通元素
                    String value= Streams.asString(stream);
                    values.put(name, value);
                }
                else {//如果是文件型的元素
                    String photoName = PhotoNameUtils.getPhotoName();
                    productPhoto =DBConstant.location + photoName+".jpg";
                    FileOutputStream fileOutputStream = new FileOutputStream(productPhoto);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = stream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    stream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
            Product product=new Product();
            product.setProductPhoto(productPhoto);
            System.out.println(productPhoto);
            product.setProductName((String)values.get("productName"));
            product.setProductDescription((String)values.get("productDescription"));
            product.setProductPrice(Float.parseFloat((String)values.get("productPrice")));
            product.setCategoryCode(CategoryCodeUtils.getCode((String)values.get("categoryCode")));
            //初始库存就是商品上架数量
            product.setProductStock(Integer.parseInt((String)values.get("originStock")));
            product.setOriginStock(Integer.parseInt((String)values.get("originStock")));
            productService.create(product);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/product");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
