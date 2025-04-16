package mff.betse.nswi145;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.net.URI;
import java.util.*;

@Path("/orders")
@Tag(name = "orders", description = "Operations on orders")
@Consumes({ MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class OrderResource {

	private static final Map<String, Order> orders = new HashMap<>();

	@Context
	private UriInfo uriInfo;

	static {
		orders.put("ORD12345", new Order("ORD12345", "John Doe", List.of(new FoodItem("Pizza", 2)), "Pending"));
	}

	@GET
	@Operation(summary = "List all orders", description = "Returns a list of all orders in the system", responses = {
			@ApiResponse(responseCode = "200", description = "A JSON or XML array of orders", content = @Content(mediaType = "application/json", array = @io.swagger.v3.oas.annotations.media.ArraySchema(schema = @Schema(implementation = Order.class)))) })
	public Collection<Order> list() {
		return orders.values();
	}

	@GET
	@Path("{id}")
	@Operation(summary = "Get one order", parameters = {
			@Parameter(name = "id", description = "ID of the order", required = true) }, responses = {
					@ApiResponse(responseCode = "200", description = "The order", content = @Content(schema = @Schema(implementation = Order.class))),
					@ApiResponse(responseCode = "404", description = "Order not found") })
	public Response get(@PathParam("id") String id) {
		Order o = orders.get(id);
		if (o == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Order not found: " + id).build();
		}
		return Response.ok(o).build();
	}

	@POST
	@Operation(summary = "Create a new order", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Order to create", required = true, content = @Content(schema = @Schema(implementation = Order.class))), responses = {
			@ApiResponse(responseCode = "201", description = "Order created"),
			@ApiResponse(responseCode = "400", description = "Invalid input"),
			@ApiResponse(responseCode = "409", description = "Order already exists") })
	public Response create(Order order) {
		if (order.getId() == null || order.getId().isBlank()) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Order ID must be provided").build();
		}
		if (orders.containsKey(order.getId())) {
			return Response.status(Response.Status.CONFLICT).entity("Order already exists: " + order.getId()).build();
		}
		orders.put(order.getId(), order);
		URI uri = uriInfo.getAbsolutePathBuilder().path(order.getId()).build();
		return Response.created(uri).entity(order).build();
	}

	@PUT
	@Path("{id}")
	@Operation(summary = "Update an existing order", parameters = {
			@Parameter(name = "id", description = "ID of the order to update", required = true) }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Updated order object", required = true, content = @Content(schema = @Schema(implementation = Order.class))), responses = {
					@ApiResponse(responseCode = "200", description = "Order updated"),
					@ApiResponse(responseCode = "404", description = "Order not found") })
	public Response update(@PathParam("id") String id, Order updated) {
		Order existing = orders.get(id);
		if (existing == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Order not found: " + id).build();
		}
		updated.setId(id);
		orders.put(id, updated);
		return Response.ok(updated).build();
	}

	@DELETE
	@Path("{id}")
	@Operation(summary = "Delete an order", parameters = {
			@Parameter(name = "id", description = "ID of the order to delete", required = true) }, responses = {
					@ApiResponse(responseCode = "204", description = "Order deleted"),
					@ApiResponse(responseCode = "404", description = "Order not found") })
	public Response delete(@PathParam("id") String id) {
		Order removed = orders.remove(id);
		if (removed == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Order not found: " + id).build();
		}
		return Response.noContent().build();
	}
}
