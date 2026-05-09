package com.mycompany.cafeexpresso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    private Pedido instance;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void setUp() {
        instance = new Pedido();
        produto1 = new Produto("Café com Leite", 5.50);
        produto2 = new Produto("Café Preto", 4.00);
    }

    // testar se o método calcularTotal() retorna o valor correto para um pedido com vários itens.
    @Test
    public void deveCalcularTotalCorretamente() {
        System.out.println("Teste Calcular Total do Pedido");

        ItemPedido item1 = new ItemPedido(2, produto1); // 2 unidades de Café com Leite
        ItemPedido item2 = new ItemPedido(3, produto2); // 3 unidades de Café Preto

        // Adicionar itens ao pedido
        instance.adicionarItem(item1);
        instance.adicionarItem(item2);

        // Calcular o total esperado
        double totalEsperado = (2 * 5.50) + (3 * 4.00); // Total esperado: 11.00 + 12.00 = 23.00

        // Verificar se o total calculado é igual ao total esperado
        assertEquals(totalEsperado, instance.calcularTotal(), "O total calculado deve ser igual ao total esperado");
    }

    @Test
    public void deveMudarStatusParaPagoAoPagarPedido() {
        System.out.println("Teste Pagar Pedido");

        // Configurar o status do pedido para PENDENTE
        instance.setStatus(StatusPedido.PENDENTE);

        // Adicionar um item ao pedido para garantir que ele não esteja vazio
        ItemPedido item = new ItemPedido(1, produto1);
        instance.adicionarItem(item);

        // Pagar o pedido
        instance.pagar();

        // Verificar se o status do pedido mudou para PAGO
        assertEquals(StatusPedido.PAGO, instance.getStatus(), "O status do pedido deve ser PAGO após pagar");
    }

    @Test
    void NaoDevePagarPedidoVazio() {
        // Configurar o status do pedido para PENDENTE
        instance.setStatus(StatusPedido.PENDENTE);

        // Tentar pagar o pedido vazio
        instance.pagar();

        // Verificar se o status do pedido permanece PENDENTE
        assertEquals(StatusPedido.PENDENTE, instance.getStatus(), "O status do pedido deve permanecer PENDENTE ao tentar pagar um pedido vazio");
    }
    void DeveMudarStatusParaEmPreparoAoEnviarParaPreparo() {
        // Configurar o status do pedido para PAGO
        instance.setStatus(StatusPedido.PAGO);

        // Adicionar um item ao pedido para garantir que ele não esteja vazio
        ItemPedido item = new ItemPedido(1, produto1);
        instance.adicionarItem(item);

        // Enviar para preparo
        instance.enviarParaPreparo();

        // Verificar se o status do pedido mudou para EM_PREPARO
        assertEquals(StatusPedido.EM_PREPARO, instance.getStatus(), "O status do pedido deve ser EM_PREPARO após enviar para preparo");
    }
    @Test
    void NaoDeveEnviarParaPreparoSemPagar() {
        // Configurar o status do pedido para PENDENTE
        instance.setStatus(StatusPedido.PENDENTE);

        // Adicionar um item ao pedido para garantir que ele não esteja vazio
        ItemPedido item = new ItemPedido(1, produto1);
        instance.adicionarItem(item);

        // Tentar enviar para preparo sem pagar
        instance.enviarParaPreparo();

        // Verificar se o status do pedido permanece PENDENTE
        assertEquals(StatusPedido.PENDENTE, instance.getStatus(), "O status do pedido deve permanecer PENDENTE ao tentar enviar para preparo sem pagar");
    }

    @Test
    void DeveFinalizarPedido() {
        // Configurar o status do pedido para EM_PREPARO
        instance.setStatus(StatusPedido.EM_PREPARO);

        // Adicionar um item ao pedido para garantir que ele não esteja vazio
        ItemPedido item = new ItemPedido(1, produto1);
        instance.adicionarItem(item);

        // Finalizar o pedido
        instance.finalizarPedido();

        // Verificar se o status do pedido mudou para FINALIZADO
        assertEquals(StatusPedido.FINALIZADO, instance.getStatus(), "O status do pedido deve ser FINALIZADO após finalizar o pedido");
    }
}
