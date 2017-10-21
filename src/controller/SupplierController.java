package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.SupplierDOM;
import model.Supplier;

/**
 * Servlet implementation class SupplierController
 */
@WebServlet("/SupplierController")
public class SupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Supplier supplier;
	private List<Supplier> suppliers;
	private SupplierDOM supplierDOM;
	private List<String> ids = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierController() {
        super();
        // TODO Auto-generated constructor stub
        supplier = new Supplier(); 
        suppliers= new ArrayList<Supplier>();
        supplierDOM = new SupplierDOM();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_save")!= null) {
			
			supplier.setCompany(request.getParameter("company"));
			supplier.setName(request.getParameter("name"));
			supplier.setTitle(request.getParameter("title"));
			supplier.setAddress(request.getParameter("address"));
			
			if(supplier.getId()=="") {
				String newId= "SUP"+String.format("%05d", 1);
				supplier.setId(newId);;
				
				if (suppliers.size()>0) {
					ids.clear();
					for (Supplier p: suppliers) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "SUP"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
							supplier.setId(newId);
						break;
						}
					}
				}
				System.out.println(supplier);
				supplierDOM.add(supplier);
			}else {
				supplierDOM.update(supplier);
			}
			suppliers = supplierDOM.getSuppliers();
			request.setAttribute("suppliers", suppliers);
			request.getRequestDispatcher("supplier_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			supplier = new Supplier();
			request.getRequestDispatcher("supplier_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				supplier = supplierDOM.findById(id);
				
			}catch (Exception e) {
				
				supplier = new Supplier();
			}
			request.setAttribute("supplier", supplier );
			
			request.getRequestDispatcher("supplier_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			supplierDOM.delete(id);
			suppliers = supplierDOM.getSuppliers();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("suppliers", suppliers);
			request.getRequestDispatcher("supplier_list.jsp").forward(request, response);
		}else {
			suppliers = supplierDOM.getSuppliers();
			request.setAttribute("suppliers", suppliers);
			request.getRequestDispatcher("supplier_list.jsp").forward(request, response);
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
