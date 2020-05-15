package com.nem.docms.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
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
			Project pro = new Project(e.get("id").toString(),e.getString("name"),e.getString("description"));
			response.add(pro);
		}
		return response;
	}

	public String save(Project pro) {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("doc-ms");
		MongoCollection<Document> collection = database.getCollection("Projects");
		
		//Create Object
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
		return response;
	}

	//Update an Object
	public String update(Project pro) {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("doc-ms");
		MongoCollection<Document> collection = database.getCollection("Projects");
		
		//Create Object
		Document pro1 = new Document();
		pro1.append("id", pro.getId());
		pro1.append("name", pro.getName());
		pro1.append("description", pro.getDescription());
		
		String response;
		try {
			//Used project ID is the primary key not MongoDB default ID
			BasicDBObject filter = new BasicDBObject("id",pro.getId());
			//Can update one object not many
			collection.updateOne(filter, new BasicDBObject("$set",pro1));
			response = "Successfully Updated.!";
		} catch (Exception e) {
			response = "Insertion Failed. Please try again.";
		}
		return response;
	}

	public String delete(String id) {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("doc-ms");
		MongoCollection<Document> collection = database.getCollection("Projects");
		
		String response;
		try {
			//Used project ID is the primary key not MongoDB default ID
			BasicDBObject filter = new BasicDBObject("id",id);
			//Can delete one object not many
			collection.deleteOne(filter);
			response = "Successfully Deleted.!";
		} catch (Exception e) {
			response = "Deletion Failed. Please try again.";
		}
		return response;
	}

}
