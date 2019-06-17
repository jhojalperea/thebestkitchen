package com.thebestkitchen.restaurant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thebestkitchen.restaurant.entity.InvoicedByPeriodByWaiter;
import com.thebestkitchen.restaurant.entity.PurchasesGreaterThan;
import com.thebestkitchen.restaurant.persistence.InvoiceDetailRepository;
import com.thebestkitchen.restaurant.persistence.InvoiceRepository;
import com.thebestkitchen.restaurant.persistence.InvoicedByPeriodByWaiterRepository;
import com.thebestkitchen.restaurant.persistence.PurchasesGreaterThanRepository;

@SpringBootApplication
public class RestaurantApplication{ // implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(RestaurantApplication.class);
	
	@Autowired
	PurchasesGreaterThanRepository purchasesGreaterThanRepository;
	
	@Autowired
	InvoicedByPeriodByWaiterRepository invoicedByPeriodByWaiterRepository;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	InvoiceDetailRepository invoiceDetailRepository;
	
	@Value("${application.restaurant-opening-date}")
	private String restaurantOpeningDate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		
		String periodNow = LocalDate.now().format( DateTimeFormatter.ofPattern("yyyy-MM") );
		
		logger.info("[Now={}]", periodNow);
		
		List<PurchasesGreaterThan> lP = purchasesGreaterThanRepository.findAllByOrderByTotalDesc();
		logger.info("[PurchasesGreaterThan Size={}]", lP.size());
		for( PurchasesGreaterThan p : lP ) {
			logger.info("[PurchasesGreaterThan Data={}]", p.toString());
		}
		
		List<InvoicedByPeriodByWaiter> lI = invoicedByPeriodByWaiterRepository.findAllByPeriodBetweenOrderByPeriodAscWaiterAsc("2019-03", periodNow);
		logger.info("[InvoicedByPeriodByWaiter Size={}]", lP.size());
		for( InvoicedByPeriodByWaiter i : lI ) {
			logger.info("[InvoicedByPeriodByWaiter Data={}]", i.toString());
		}
	}

}
