package camelinaction;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import camelinaction.jpa.entity.OrderJpa;

@Component
public class OrderRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // see the application.properties file for setup of the rest configuration

        // rest services under the orders context-path
        rest("/orders")
            // need to specify the POJO types the binding is using (otherwise json binding defaults to Map based)
            .get("{id}").outType(OrderJpa.class)
                .to("bean:orderService?method=getOrder(${header.id})")
             .get().outType(Orders.class)
             .to("bean:orderService?method=getOrders()")
                // need to specify the POJO types the binding is using (otherwise json binding defaults to Map based)
            .post().type(OrderJpa.class)
                .to("bean:orderService?method=createOrder")
                // need to specify the POJO types the binding is using (otherwise json binding defaults to Map based)
            .put().type(OrderJpa.class)
                .to("bean:orderService?method=updateOrder")
            .delete("{id}")
                .to("bean:orderService?method=cancelOrder(${header.id})");
    }
}
