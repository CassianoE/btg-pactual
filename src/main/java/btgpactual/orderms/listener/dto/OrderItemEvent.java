package btgpactual.orderms.listener.dto;

import java.math.BigDecimal;

public record OrderItemEvent(String produto,
                             int quantidade,
                             BigDecimal preco) {
}
