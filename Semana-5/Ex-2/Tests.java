

@Test
void shouldReturnOrderWhenIdExists() {

    Order order = new Order();
    order.setId(1L);

    when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

    Order result = orderService.getOrderById(1L);

    assertNotNull(result);
    assertEquals(1L, result.getId());
}

@Test
void shouldThrowExceptionWhenOrderNotFound() {

    when(orderRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> {
        orderService.getOrderById(1L);
    });
}

