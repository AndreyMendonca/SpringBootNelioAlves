package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "tb_order")
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate moment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy="order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Double getTotal() {
		Double sum = 0.0;
		for(OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
	}
}
