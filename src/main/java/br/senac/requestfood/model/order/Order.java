package br.senac.requestfood.model.order;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_establishment")
    private Establishment establishment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "issue_date_order", nullable = false)
    private LocalDateTime IssueDate;

    @Column(name = "closing_date_order")
    private LocalDateTime closingDate;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    @Transient
    private Double amount;

	public Order(Long id, Establishment establishment, Client client, LocalDateTime issueDate,LocalDateTime closingDate, List<Item> itens, Double amount) {
		this.id = id;
		this.establishment = establishment;
		this.client = client;
		this.IssueDate = issueDate;
		this.closingDate = closingDate;
		this.items = items;
		this.amount = amount;
	}
    
    public boolean equals(Object object) {
        
    	if (object == null)
            return false;
        if (this == object)
            return true;
        if (this.getClass() != object.getClass())
            return false;
        
        Order order = ((Order) object);
        return this.getId() == order.getId()
                && this.getEstablishment().equals(order.getEstablishment())
                && this.getClient().equals(order.getClient())
                && this.getIssueDate().equals(order.getIssueDate())
                && this.getClosingDate().equals(order.getClosingDate())
                && this.getItems().equals(order.getItems())
                && this.getAmount() == order.getAmount();
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LocalDateTime getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(LocalDateTime issueDate) {
		IssueDate = issueDate;
	}
	public LocalDateTime getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDateTime closingDate) {
		this.closingDate = closingDate;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}