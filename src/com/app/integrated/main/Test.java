package com.app.integrated.main;

import java.util.*;
import java.util.Map.Entry;

import com.app.abacus.panel.exception.AbacusException;
import com.app.instructions.beans.Action;    
class Book {    
int id;    
String name,author,publisher;    
int quantity;    
public Book(int id, String name, String author, String publisher, int quantity) {    
    this.id = id;    
    this.name = name;    
    this.author = author;    
    this.publisher = publisher;    
    this.quantity = quantity;    
} 
/** list of actions into an HashMap */

/*public void start_beforInstructing() throws AbacusException {
	Set<Entry<String, HashMap<String, List<Action>>>> entrySet = data.entrySet();
	int i = 0;
	HashMap<String, String> actionMap = new HashMap<String, String>();
	for (Entry<String, HashMap<String, List<Action>>> entry : entrySet) {
		HashMap<String, List<Action>> map = entry.getValue();
		Set<Entry<String, List<Action>>> sEntry = map.entrySet();
		
		for (Entry<String, List<Action>> entry2 : sEntry) {
			i++;
			String instructionKey = entry2.getKey();
			List<Action> instruction = entry2.getValue(); 
			
			*//** add some files from start_instructing method*//*
			
			for (Action  actionlist: instruction) {
				
				if(actionlist.getActionName().equals("Font"))
				{
					actionlist.getFont();
					actionMap.put("	Font Name", actionlist.getFont().getName());
					actionMap.put("Font Size", actionlist.getFont().getSize());
				}
				
				if(actionlist.getActionName().equals("Layout")) 
				{
					actionlist.getLayout();
					actionMap.put("NumOfRows", String.valueOf(actionlist.getLayout().getNumOfRow()));
					actionMap.put("NumOfCols", String.valueOf(actionlist.getLayout().getNumOfCols()));
					
					actionlist.getLayout().getRows();
					for (int j = 0; j < actionlist.getLayout().getRows().size(); j++)
					{
					actionMap.put("row"+j+"Height", actionlist.getLayout().getRows().get(j).getHeight());	
					actionMap.put("row"+j+"Weight", actionlist.getLayout().getRows().get(j).getWidth());
					}				
				}

				if(actionlist.getActionName().equals("Component")) 
				{
					actionlist.getComponent();
					actionMap.put("RodNumber", actionlist.getComponent().getNumOfRods());
					actionMap.put("Component Name",actionlist.getComponent().getName());
					
					actionMap.put("Component Name",actionlist.getComponent().getName());
					actionMap.put("Teacher Align", actionlist.getComponent().getTeacherAlign());
					actionMap.put("Student Align", actionlist.getComponent().getStudentAlign());
					
					actionMap.put("Component Name", actionlist.getComponent().getName());
					actionMap.put("Align", actionlist.getComponent().getAlign());
					
					actionMap.put("Component Name", actionlist.getComponent().getImage());
				}
			}		
		}
	}
}
*/
}    
public class Test {    
public static void main(String[] args) {    
    //Creating map of Books    
    Map<Integer,Book> map=new HashMap<Integer,Book>();    
    //Creating Books    
    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);    
    //Adding Books to map   
    map.put(1,b1);  
    map.put(2,b2);  
    map.put(3,b3);  
      
    //Traversing map  
    for(Map.Entry<Integer, Book> entry:map.entrySet()){    
        int key=entry.getKey();  
        Book b=entry.getValue();  
        System.out.println(key+" Details:");  
        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
    }    
}    
}    