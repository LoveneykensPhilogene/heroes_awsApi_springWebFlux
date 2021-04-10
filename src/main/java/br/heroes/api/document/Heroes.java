package br.heroes.api.document;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName="Heroes_Table")
public class Heroes {
	
	@Id
	@DynamoDBHashKey(attributeName="id")
	private String id;
	
	@DynamoDBAttribute(attributeName="nome")
	private String nome;
	
	@DynamoDBAttribute(attributeName="universe")
	private String universe;
	
	@DynamoDBAttribute(attributeName="films")
	private int films;
	
	public Heroes(String id,String nome,String universe,int films) {
		this.id=id;
		this.nome=nome;
		this.universe=universe;
		this.films=films;
	}
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getUniverse() {
		return universe;
	}
	public int getFilms() {
		return films;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUniverse(String universe) {
		this.universe = universe;
	}
	public void setFilms(int films) {
		this.films = films;
	}

}
