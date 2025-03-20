package btgpactual.orderms.listener.dto;


import btgpactual.orderms.entity.OrderItem;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedido,
                                Long codigoCliente,
                                List<OrderItemEvent> itens) {
}
