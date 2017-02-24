package com.advancese.Philomath;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;


@Path("/searchCourses")
public class SearchCourses {

	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResults searchCourses(String message){
		
		String[] receivedMessage = message.split(",");
		
		if(receivedMessage.length==2){
			
		Search search =  new Search();
		List<Course> searchResults = new ArrayList<Course>();
		String searchBy=receivedMessage[0];
		String value = receivedMessage[1];
		if(searchBy.contains("professor")){
			search.searchByProfessor(value, searchResults);
		}
		else{
		search.search(searchBy, value, searchResults);
		}
		SearchResults result=  new SearchResults();
		result.setSearchResults(searchResults);
		return result;
		}
		else{
			Search search =  new Search();
			List<Course> searchResults1 = new ArrayList<Course>();
			List<Course> searchResults2 = new ArrayList<Course>();
			List<Course> searchResults3 = new ArrayList<Course>();
			if(receivedMessage.length==4){
				System.out.println("received length equals 4 "+receivedMessage.toString());
			String searchBy1 = receivedMessage[0];
			String value1 = receivedMessage[1];
			String searchBy2 = receivedMessage[2];
			String value2 = receivedMessage[3];;
			if(searchBy1.contains("professor")){
				search.searchByProfessor(value1, searchResults1);
			}
			else{
				search.search(searchBy1, value1, searchResults1);
			}
			if(searchBy2.contains("professor")){
				search.searchByProfessor(value2, searchResults2);
			}
			else{
				search.search(searchBy2, value2, searchResults2);
			}
			System.out.println("search results 1 "+searchResults1);
			System.out.println("search results 1 "+searchResults2);
			List<Course> finalList = new ArrayList<Course>();
					
			search.compare(searchResults1, searchResults2, finalList);
			searchResults1 = finalList;
			System.out.println("final search results "+searchResults1);
			}
			
			if(receivedMessage.length == 6){
				System.out.println("received length equals 6 "+receivedMessage.toString());
				String searchBy1 = receivedMessage[0];
				String value1 = receivedMessage[1];
				String searchBy2 = receivedMessage[2];
				String value2 = receivedMessage[3];
				String searchBy3 = receivedMessage[4];
				String value3 = receivedMessage[5];
				if(searchBy1.contains("professor")){
					search.searchByProfessor(value1, searchResults1);
				}
				else{
					search.search(searchBy1, value1, searchResults1);
				}
				if(searchBy2.contains("professor")){
					search.searchByProfessor(value2, searchResults2);
				}
				else{
					search.search(searchBy2, value2, searchResults2);
				}
				if(searchBy3.contains("professor")){
					search.searchByProfessor(value3, searchResults3);
				}
				else{
					search.search(searchBy3, value3, searchResults3);
				}
				List<Course> finalList =new ArrayList<Course>();
				List<Course> finalList2 =new ArrayList<Course>();
				search.compare(searchResults1, searchResults2, finalList);
				search.compare(finalList, searchResults3, finalList2);
				searchResults1=finalList2;
			}
			SearchResults result=  new SearchResults();
			result.setSearchResults(searchResults1);
			return result;
		}
		
		
		
	}
	
}
