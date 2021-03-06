package com.fidofi.controller;

import com.fidofi.constant.DBConstant;
import com.fidofi.service.ProductService;
import com.fidofi.service.impl.ProductServiceImpl;
import com.fidofi.utils.CategoryCodeUtils;
import com.fidofi.utils.CharsetChangeUtils;
import com.fidofi.utils.PhotoNameUtils;
import com.fidofi.vo.ProductVO;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fido on 2017/10/5.
 * 商品更新处理
 */
public class UpdateSubmitServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //对应表单传过来的名称和值
        HashMap<String, Object> values = new HashMap<String, Object>();
        // request.setCharacterEncoding("UTF-8");
        // 检查是否是表单文件上传请求
        String productPhoto = null;
        FileOutputStream fileOutputStream = null;
        InputStream stream = null;

        try {
//            String location=DBConstant.location.substring(0,DBConstant.location.indexOf("WEB-INF"))+"imag/";
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            //  创建上传对象
            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iter = upload.getItemIterator(request); //得到所有的上传数据
            while (iter.hasNext()) { //循环上传表单的元素
                FileItemStream item = iter.next();
                String name = item.getFieldName(); //得到元素名
                stream = item.openStream();
                if (item.isFormField()) { //如果是普通元素
                    String value = Streams.asString(stream);
                    values.put(name, value);
                } else {//如果是文件型的元素
                    String photoName = PhotoNameUtils.getPhotoName();
                    productPhoto = DBConstant.location + photoName + ".jpg";
                    fileOutputStream = new FileOutputStream(productPhoto);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = stream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                }
            }
            stream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            String productBarCode = (String) request.getSession().getAttribute("productBarCode");
            ProductVO productVO = productService.selectByProductBarCode(productBarCode).get(0);
            if (productPhoto != null) {
                //删掉旧的图片
                File file = new File(productVO.getProductPhoto());
                if (file.exists()) {
                    file.delete();
                }
                //设置新的图片
                productVO.setProductPhoto(productPhoto);
            }
            productVO.setProductName((String) values.get("productName"));
            productVO.setProductDescription((String) values.get("productDescription"));
            productVO.setProductPrice(Float.parseFloat((String) values.get("productPrice")));
            productVO.setCategoryCode((String) values.get("categoryCode"));
            productVO.setProductBarCode(productBarCode);
            if(values.get("isNew")==null){
                productVO.setIsNew(false);
            }
            else {
                productVO.setIsNew(true);
            }
            if(values.get("discount")==null){
                productVO.setDiscount(false);
            }
            else{
                 productVO.setDiscount(true);
            }
            productVO.setProductStock(Integer.parseInt((String) values.get("productStock")));
            productVO.setOriginStock(Integer.parseInt((String) values.get("originStock")));
            productService.update(productVO);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/product");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
