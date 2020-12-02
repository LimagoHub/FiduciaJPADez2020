package de.limago.jpademo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblbars")
@NamedQuery(name = "Bar.findByName", query = "SELECT b FROM Bar b where b.name like :name")
public class Bar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30, unique =  true)
	private String name;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH, CascadeType.REMOVE}, mappedBy = "bar")
	
	@Builder.Default
	@ToString.Exclude
	private List<Barkeeper> keepers = new ArrayList<>();
	
	public void addBarkeeper(Barkeeper keeper) {
		keeper.setBar(this);
		keepers.add(keeper);
	}
}
