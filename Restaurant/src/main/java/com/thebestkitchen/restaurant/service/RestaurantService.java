package com.thebestkitchen.restaurant.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.thebestkitchen.restaurant.entity.Chef;
import com.thebestkitchen.restaurant.entity.Client;
import com.thebestkitchen.restaurant.entity.Invoice;
import com.thebestkitchen.restaurant.entity.InvoiceDetail;
import com.thebestkitchen.restaurant.entity.InvoicedByPeriodByWaiter;
import com.thebestkitchen.restaurant.entity.PurchasesGreaterThan;
import com.thebestkitchen.restaurant.entity.RestaurantTable;
import com.thebestkitchen.restaurant.entity.Waiter;
import com.thebestkitchen.restaurant.model.InvoiceSummary;
import com.thebestkitchen.restaurant.persistence.ChefRepository;
import com.thebestkitchen.restaurant.persistence.ClientRepository;
import com.thebestkitchen.restaurant.persistence.InvoiceDetailRepository;
import com.thebestkitchen.restaurant.persistence.InvoiceRepository;
import com.thebestkitchen.restaurant.persistence.InvoicedByPeriodByWaiterRepository;
import com.thebestkitchen.restaurant.persistence.PurchasesGreaterThanRepository;
import com.thebestkitchen.restaurant.persistence.RestaurantTableRepository;
import com.thebestkitchen.restaurant.persistence.WaiterRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private PurchasesGreaterThanRepository purchasesGreaterThanRepository;
	
	@Autowired
	private InvoicedByPeriodByWaiterRepository invoicedByPeriodByWaiterRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private WaiterRepository waiterRepository;
	
	@Autowired
	private RestaurantTableRepository tableRepository;
	
	@Autowired
	private ChefRepository chefRepository;
	
		
	@Value("${application.restaurant-opening-date}")
	private String restaurantOpeningDate;
	
	
	public List<PurchasesGreaterThan> getPurchasesGreaterThan(){		
		return purchasesGreaterThanRepository.findAllByOrderByTotalDesc();
	}
	
	public List<InvoicedByPeriodByWaiter> getInvoicedByPeriodByWaiter(){
		String periodNow = LocalDate.now().format( DateTimeFormatter.ofPattern("yyyy-MM") );
		return invoicedByPeriodByWaiterRepository.findAllByPeriodBetweenOrderByPeriodAscWaiterAsc( restaurantOpeningDate, periodNow );
	}
	
	public List<InvoiceSummary> getInvoicesByOrderByInvoiceIdDesc(){
		return invoiceRepository.findAllByOrderByInvoiceIdDesc();
	}
	
	public List<Client> getAllClientsByOrderByNameAscSurNameAsc(){
		return clientRepository.findAllByOrderByNameAscSurnameAsc();
	}
	
	public List<Waiter> getAllWaitersByOrderByNameAscSurNameAsc(){
		return waiterRepository.findAllByOrderByNameAscSurnameAsc();
	}
	
	public List<RestaurantTable> getAllTablesByOrderByTableId(){
		return tableRepository.findAllByOrderByTableId();
	}
	
	public List<Chef> getAllChefsByOrderByTableId(){
		return chefRepository.findAllByOrderByNameAscSurnameAsc();
	}
	
	public void saveInvoice( 		
		Integer clientId,
		Integer waiterId,
		Integer tableId,
		Integer[] chefId,
		String[] plate,
		Integer[] amount ) {
		
		Invoice invoice = new Invoice();
		invoice.setClientId(clientId);
		invoice.setTableId(tableId);
		invoice.setWaiterId(waiterId);
		invoice.setInvoiceDate( new Date() );
		invoice = invoiceRepository.save(invoice);
		
		List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
		
		for (int i = 0; i < chefId.length; i++) {
			InvoiceDetail invoiceDetail = new InvoiceDetail();
			invoiceDetail.setInvoiceId( invoice.getInvoiceId() );
			invoiceDetail.setPlate(plate[i]);
			invoiceDetail.setChefId(chefId[i]);
			invoiceDetail.setAmount(amount[i]);
			invoiceDetails.add(invoiceDetail);
		}			
		invoiceDetailRepository.saveAll(invoiceDetails);
	}
}
