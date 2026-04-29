package com.mycompany.cafeexpresso;

public class Produto {
    String nome;
    double precoUnitario;
    
    
    // Construtor vazio
    public Produto() {
        
    }
        // Construtor

    public Produto(String nome, double precoUnitario) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    
}
