package com.mycompany.cafeexpresso;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<ItemPedido> itens;
    private StatusPedido status;

    public Pedido() {
        this.itens = new ArrayList<ItemPedido>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() { 
        double total = 0.0;
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.getQuantidade() * itemPedido.getProduto().getPrecoUnitario();
        }
        return total;
    }

    public void pagar() {
        if (status == StatusPedido.PENDENTE && !itens.isEmpty()) {
            status = StatusPedido.PAGO;
        }
    }
    public void enviarParaPreparo() {
        if (status == StatusPedido.PAGO && !itens.isEmpty()) {
            status = StatusPedido.EM_PREPARO;
        }
    }
 
    public void finalizarPedido() {
        if (status == StatusPedido.EM_PREPARO && !itens.isEmpty()) {
            status = StatusPedido.FINALIZADO;
        }
    }

    // Getters e Setters (Sem Testes)
    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }
}
