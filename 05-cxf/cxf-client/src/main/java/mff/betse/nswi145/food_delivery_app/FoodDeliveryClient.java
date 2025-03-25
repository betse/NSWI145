package mff.betse.nswi145.food_delivery_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class FoodDeliveryClient {

	public static void main(String[] args) {
		RestaurantOrderServiceImplService service = new RestaurantOrderServiceImplService();
        IRestaurantOrderService port = service.getRestaurantOrderServiceImplPort();
        
        org.apache.cxf.endpoint.Client client = ClientProxy.getClient(port);

        // Add WS-Security UsernameToken
        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        outProps.put(WSHandlerConstants.USER, "betse");
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, "mff.betse.nswi145.food_delivery_app.ClientPasswordCallback");

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        client.getOutInterceptors().add(wssOut);


        // Test sendOrderRequest
        OrderRequest order = new OrderRequest();
        order.setOrderId("ORD123");
        order.setCustomerName("John Doe");
        List<FoodItem> items = new ArrayList<>();
        FoodItem item1 = new FoodItem();
        FoodItem item2 = new FoodItem();
        item1.setName("Pizza");
        item1.setQuantity(2);
        item2.setName("Cola");
        item2.setQuantity(1);
        items.add(item1);
        items.add(item2);
        //order.setFoodItems(items);

        String orderResponse = port.sendOrderRequest(order);
        System.out.println("Send Order Response: " + orderResponse);

        // Test checkOrderStatus
        String statusResponse = port.checkOrderStatus("ORD123");
        System.out.println("Status Response: " + statusResponse);

	}

}
