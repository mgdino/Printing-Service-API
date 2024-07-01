package app.components;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entity.OrderItem;
import app.entity.OrderStatement;
import app.entity.Product;
import app.repositories.OrderItemRepo;
import app.repositories.OrderStatementRepo;
import app.repositories.ProductRepo;

@Component
public class OrderItemComponent {

	String UPLOAD_PATH = "temp/";

	@Autowired
	OrderItemRepo repo;
	
	@Autowired
	OrderStatementRepo osrepo;
	
	@Autowired
	ProductRepo prepo;
	
	
	public String saveOrderItem(InputStream uploadedInputStream, String filename, Long order_id, Long product_id, Long quantity)
	{
	    try
	    {
	    	File dir = new File(UPLOAD_PATH);
	    	dir.mkdirs();
	    	
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        File file = new File(dir, filename);
	        
			OutputStream out = new FileOutputStream(file);
	        while ((read = uploadedInputStream.read(bytes)) != -1)
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	        
	        
	        OrderItem u = new OrderItem();
	        u.setFilename(filename);
	        u.setOrder_id(order_id);
	        u.setProduct_id(product_id);
	        u.setQuantity(quantity);
	        
	        u = repo.save(u);
	        
	        Product p = prepo.findByProductId(product_id);
	        OrderStatement os = osrepo.findByOrderId(order_id);

		    os.setTotal_amount(os.getTotal_amount()+(p.getPrice()*quantity));
		    osrepo.save(os);


	        
	        
	        
	        return "OK - save to imageID "+u.getOrder_item_id();
	    } catch (IOException e)
	    {
	    	e.printStackTrace();
	    	return "BAD";
	    }
	}
	
	
	// for some reason, Lazy initialization errors occur without @Transactional
	
	@Transactional
	public byte[] getImageFile(Long id) throws Exception
	{
		OrderItem file = repo.getOne(id);
		String filename = file.getFilename();
		
    	File dir = new File(UPLOAD_PATH);
        File imagefile = new File(dir, filename);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
		InputStream is = new FileInputStream(imagefile);
		byte[] bytes = new byte[1024];
		int read = -1;
        while ((read = is.read(bytes)) != -1)
        {
            baos.write(bytes, 0, read);
        }
        baos.flush();
        is.close();
        
        return baos.toByteArray();

		
	}
}
