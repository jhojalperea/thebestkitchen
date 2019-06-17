package com.thebestkitchen.restaurant.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thebestkitchen.restaurant.model.InvoiceSummary;
import com.thebestkitchen.restaurant.util.QueryUtil;

public class InvoiceRepositoryImpl implements InvoiceRepositoryCustom{
	
	private static final Logger logger = LoggerFactory.getLogger(InvoiceRepositoryImpl.class);
	
	@PersistenceContext(unitName = "default")
	protected EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public List<InvoiceSummary> findAllByOrderByInvoiceIdDesc(){
		
		logger.info("ENTRO"); 
		
		try {
			Map<String, Object> parametersMap = new HashMap<>();
			
			StringBuilder queryString = 
			new StringBuilder("SELECT F.IdFactura, DATE(F.FechaFactura) AS FechaFactura, TRIM(CONCAT(CL.Nombre,' ',CL.Apellido1,' ',IFNULL(CL.Apellido2,''))) AS Cliente, ") 
					.append("TRIM(CONCAT(C.Nombre,' ',C.Apellido1,' ',IFNULL(C.Apellido2,''))) AS Camarero, ")
					.append("M.IdMesa AS NroMesa, ")
					.append("COUNT(1) AS NroProductos, SUM(DF.Importe) AS TotalFactura ")
					.append("FROM Factura AS F ")
					.append("INNER JOIN DetalleFactura AS DF ")
					.append("ON F.IdFactura = DF.IdFactura ")
					.append("INNER JOIN Cliente AS CL ")
					.append("ON F.IdCliente = CL.IdCliente ")
					.append("INNER JOIN Camarero AS C ")
					.append("ON F.IdCamarero = C.IdCamarero ")
					.append("INNER JOIN Mesa AS M ")
					.append("ON M.IdMesa = F.IdMesa ")
					.append("GROUP BY F.IdFactura ")
					.append("ORDER BY F.IdFactura DESC");
			
			Query query = QueryUtil.replaceParameters(queryString, parametersMap, null, getEntityManager());
			
			List<InvoiceSummary> invoicesSummary = new ArrayList<InvoiceSummary>();
			
			@SuppressWarnings("unchecked")
			List<Object[]> objs = query.getResultList();			
			for( Object[] o : objs ) {
				InvoiceSummary invoice = new InvoiceSummary();
				invoice.setInvoiceId( Integer.parseInt(o[0].toString()) );
				invoice.setInvoiceDate( (Date)o[1] );
				invoice.setClient( o[2].toString() );
				invoice.setWaiter( o[3].toString() );
				invoice.setTableId( Integer.parseInt(o[4].toString()) );
				invoice.setNumberProducts( Integer.parseInt(o[5].toString()) );
				invoice.setTotalInvoice( Integer.parseInt(o[6].toString()) );
				
				invoicesSummary.add(invoice);
			}	
			return invoicesSummary;
		} catch (Exception e) {
			logger.error ("Exception: {}", e);
			return new ArrayList<InvoiceSummary>();
		}
	}
}
