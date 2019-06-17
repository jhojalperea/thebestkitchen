package com.thebestkitchen.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thebestkitchen.restaurant.service.RestaurantService;

@Controller
public class RestaurantController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping(value = {"", "/", "/index", "/home"}, method = RequestMethod.GET)
	public String home(Model model) {
        model.addAttribute("invoices", restaurantService.getInvoicesByOrderByInvoiceIdDesc());
        return "index";
    }
	
	@RequestMapping(value = "/invoiced", method = RequestMethod.GET)
	public String invoicedByPeriod(Model model) {
        model.addAttribute("invoices", restaurantService.getInvoicedByPeriodByWaiter());
        return "invoiced";
    }
	
	@RequestMapping(value = "/purchasesGreater", method = RequestMethod.GET)
	public String purchasesGreater(Model model) {
        model.addAttribute("purchases", restaurantService.getPurchasesGreaterThan());
        return "purchases";
    }
	
	@RequestMapping(value = "/createInvoice", method = RequestMethod.GET)
	public String create(Model model) {
        model.addAttribute("clients", restaurantService.getAllClientsByOrderByNameAscSurNameAsc());
        model.addAttribute("waiters", restaurantService.getAllWaitersByOrderByNameAscSurNameAsc());
        model.addAttribute("tables", restaurantService.getAllTablesByOrderByTableId());
        model.addAttribute("chefs", restaurantService.getAllChefsByOrderByTableId());        
        return "createInvoice";
    }
	
	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
	public String create(Model model, 
			@RequestParam(name = "clientId", required = true) Integer clientId,
			@RequestParam(name = "waiterId", required = true) Integer waiterId,
			@RequestParam(name = "tableId", required = true) Integer tableId,
			@RequestParam(name = "chefId[]", required = false) Integer[] chefId,
			@RequestParam(name = "plate[]", required = false) String[] plate,
			@RequestParam(name = "amount[]", required = false) Integer[] amount) {
		
		if( chefId == null || chefId.length == 0) {
			return "redirect:/index";
		}
		restaurantService.saveInvoice( clientId, waiterId, tableId, chefId, plate, amount );
		return "redirect:/index";
	}
}
