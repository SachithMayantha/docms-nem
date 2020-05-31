package com.nem.docms.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.nem.docms.entities.User;

@Repository
public interface UserRepository {
		
		/*MongoClient client;
		
		default MongoClient getClient() {
			if(client==null) {
				client=new MongoClient("localhost",27017);
			}
			return client;
		}
	
		public default List<User> getAll() {
			//MongoClient mongoClient = getClient();
			MongoDatabase database = mongoClient.getDatabase("doc-ms");
			MongoCollection<Document> collection = database.getCollection("Users");
			
			List<User> response = new ArrayList<User>();
			
			for (Document e : collection.find()) {
				User user = new User(e.get("id").toString(),e.getString("name"),e.getString("password"));
				response.add(user);
			}
			return response;
		}
	
		public default String save(User user) {
			MongoClient mongoClient = getClient();
			MongoDatabase database = mongoClient.getDatabase("doc-ms");
			MongoCollection<Document> collection = database.getCollection("Users");
			
			//Create Object
			Document user1 = new Document();
			user1.append("id", user.getId());
			user1.append("name", user.getName());
			user1.append("password", user.getPassword());
			
			String response;
			try {
				collection.insertOne(user1);
				response = "Successfully Added.!";
			} catch (Exception e) {
				response = "Insertion Failed. Please try again.";
			}
			return response;
		}
	
		//Update an Object
		public default String update(User user) {
			MongoClient mongoClient = getClient();
			MongoDatabase database = mongoClient.getDatabase("doc-ms");
			MongoCollection<Document> collection = database.getCollection("Users");
			
			//Create Object
			Document user1 = new Document();
			user1.append("id", user.getId());
			user1.append("name", user.getName());
			user1.append("password", user.getPassword());
			
			String response;
			try {
				//Used user ID is the primary key not MongoDB default ID
				BasicDBObject filter = new BasicDBObject("id",user.getId());
				//Can update one object not many
				collection.updateOne(filter, new BasicDBObject("$set",user1));
				response = "Successfully Updated.!";
			} catch (Exception e) {
				response = "Insertion Failed. Please try again.";
			}
			return response;
		}
	
		public String delete(String id) {
			MongoClient mongoClient = getClient();
			MongoDatabase database = mongoClient.getDatabase("doc-ms");
			MongoCollection<Document> collection = database.getCollection("Users");
			
			String response;
			try {
				//Used user ID is the primary key not MongoDB default ID
				BasicDBObject filter = new BasicDBObject("id",id);
				//Can delete one object not many
				collection.deleteOne(filter);
				response = "Successfully Deleted.!";
			} catch (Exception e) {
				response = "Deletion Failed. Please try again.";
			}
			return response;
		}*/
}
