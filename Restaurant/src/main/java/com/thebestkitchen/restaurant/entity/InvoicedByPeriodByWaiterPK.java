package com.thebestkitchen.restaurant.entity;

import java.io.Serializable;
import java.util.Objects;

public class InvoicedByPeriodByWaiterPK  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer waiterId;
	
	private String period;	
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.waiterId);
        hash = 59 * hash + Objects.hashCode(this.period);
        return hash;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InvoicedByPeriodByWaiterPK other = (InvoicedByPeriodByWaiterPK) obj;
        if (!Objects.equals(this.waiterId, other.waiterId)) {
            return false;
        }
        if (!Objects.equals(this.period, other.period)) {
            return false;
        }
        return true;
    }
}
