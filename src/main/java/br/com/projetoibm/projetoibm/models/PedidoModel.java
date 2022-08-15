package br.com.projetoibm.projetoibm.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pedido")
public class PedidoModel implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idClient")
    private ClientModel cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

    public PedidoModel() {
    }

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public ClientModel getCliente() {
		return cliente;
	}

	public void setCliente(ClientModel cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

    
    
    
}