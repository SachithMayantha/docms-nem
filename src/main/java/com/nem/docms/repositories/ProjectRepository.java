package com.nem.docms.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.nem.docms.entities.Project;

@Repository
public class ProjectRepository {
	
	MongoClient client;
	
	MongoClient getClient() {
		if(client==null) {
			client=new MongoClient("localhost",27017);
		}
		return client;
	}

	public List<Project> getAll() {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("doc-ms");
		MongoCollection<Document> collection = database.getCollection("Projects");
		
		List<Project> response = new ArrayList<Project>();
		
		for (Document e : collection.find()) {
			Project pro = new Project(e.get("_id").toString(),e.getString("name"),e.getString("description"));
			response.add(pro);
		}
		return response;
	}

	public List<Project> add() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Project> update() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Project> delete() {
		// TODO Auto-generated method stub
		return null;
	} 

	public String save(Project pro) {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("doc-ms");
		MongoCollection<Document> collection = database.getCollection("Projects");
		
		Document pro1 = new Document();
		pro1.append("id", pro.getId());
		pro1.append("name", pro.getName());
		pro1.append("description", pro.getDescription());
		
		String response;
		try {
			collection.insertOne(pro1);
			response = "Successfully Added.!";
		} catch (Exception e) {
			response = "Insertion Failed. Please try again.";
		}
		
	}

}
