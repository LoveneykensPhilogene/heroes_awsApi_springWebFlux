package br.heroes.api.data;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import  static br.heroes.api.constant.HeroesConstant.ENDPOINT_DYNAMO;
import  static br.heroes.api.constant.HeroesConstant.REGION_DYNAMO;


public class HeroesData {
	public static void main(String[]args) {
		AmazonDynamoDB client=AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
				.build();
		
		DynamoDB dynamoDB=new DynamoDB(client);
		
		Table table=dynamoDB.getTable("Heroes_Table");
		
		Item heroe1 =new Item()
		.withPrimaryKey("id","1")
		.withString("name", "Homem Aranha")
		.withString("univers", "de comics")
		.withNumber("films",4);
		
		Item heroe2=new Item()
				.withPrimaryKey("id","2")
				.withString("nome", "Mortal Combate")
				.withString("universe","Guerra")
				.withNumber("films",10);
		
		
		
		PutItemOutcome ducomeHeroe1=table.putItem(heroe1);
		PutItemOutcome ducomeHeroe2=table.putItem(heroe2);
		
	}

}
