package dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Supplier;


public class SupplierDOM {
	
	private String pathFile = "F:\\workspace\\ALVR_Unidad22\\src\\data\\suppliers.xml";
	public void add(Supplier data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element suppliers = document.getDocumentElement();
				
				//CREATE player TAG
				
				Element supplier = document.createElement("supplier");
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				supplier.appendChild(id);
				// create name tag
				
				Element company = document.createElement("company");
				company.appendChild(document.createTextNode(data.getCompany()));
				supplier.appendChild(company);
				
					// create team tag
				
				Element name = document.createElement("name");
				name.appendChild(document.createTextNode(data.getName()));
				supplier.appendChild(name);
				
				//create age tag
				
				Element title = document.createElement("title");
				title.appendChild(document.createTextNode(data.getTitle()));
				supplier.appendChild(title);
				
				Element address = document.createElement("address");
				address.appendChild(document.createTextNode(data.getAddress()));
				supplier.appendChild(address);
				
				suppliers.appendChild(supplier);
				DOMHelper.saveXMLContent(document, pathFile);

				
				
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		
	}
}

public void delete (String id ) {
	
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("supplier");
		for (int i =0; i< nodelist.getLength(); i++) {
			
			Element supplier= (Element)nodelist.item(i);
			if (supplier.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
				supplier.getParentNode().removeChild(supplier);
			}
		}
		DOMHelper.saveXMLContent(document, pathFile);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public void update (Supplier data) {
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("supplier");
		for (int i =0; i< nodelist.getLength(); i++) {
			Element supplier = (Element)nodelist.item(i);
			if (supplier.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
				supplier.getElementsByTagName("company").item(0).setTextContent(data.getCompany());
				supplier.getElementsByTagName("name").item(0).setTextContent(data.getName());
				supplier.getElementsByTagName("title").item(0).setTextContent(data.getTitle());
				supplier.getElementsByTagName("address").item(0).setTextContent(data.getAddress());
				}
		}
		DOMHelper.saveXMLContent(document, pathFile);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

public Supplier findById(String id) {
	Supplier supplier = null;
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("supplier");
		for(int i=0; i<nodelist.getLength(); i++) {
			Element s = (Element)nodelist.item(i);
			if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
				supplier = new Supplier();
				supplier.setId(id);
				supplier.setCompany(s.getElementsByTagName("company").item(0).getTextContent());
				supplier.setName(s.getElementsByTagName("name").item(0).getTextContent());
				supplier.setTitle(s.getElementsByTagName("title").item(0).getTextContent());
				supplier.setAddress(s.getElementsByTagName("address").item(0).getTextContent());
				
			}
			
			
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return supplier;
}

public  List<Supplier> getSuppliers(){
	
	List<Supplier> suppliers = new ArrayList<Supplier>();
	Document document = DOMHelper.getDocument(pathFile);
	NodeList nodelist = document.getElementsByTagName("supplier");
	for (int i =0; i<nodelist.getLength(); i++) {
		
		Element s = (Element)nodelist.item(i);
		Supplier supplier = new Supplier();
		supplier.setId(s.getElementsByTagName("id").item(0).getTextContent());
		supplier.setCompany(s.getElementsByTagName("company").item(0).getTextContent());
		supplier.setName(s.getElementsByTagName("name").item(0).getTextContent());
		supplier.setTitle(s.getElementsByTagName("title").item(0).getTextContent());
		supplier.setAddress(s.getElementsByTagName("address").item(0).getTextContent());
		
		suppliers.add(supplier);
		
	}
	return suppliers;
}
	
	

}
