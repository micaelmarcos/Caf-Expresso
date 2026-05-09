package com.mycompany.cafeexpresso;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<ItemPedido> itens;
    

    public Pedido() {
        this.itens = new ArrayList<ItemPedido>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() { // Parei nesse método, falta implementar o cálculo do total
        double total = 0.0;
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.getQuantidade() * itemPedido.getProduto().getPrecoUnitario();
        }
        return total;
    }
 
}
