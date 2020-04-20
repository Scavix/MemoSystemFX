package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyPost {
	ArrayList<Post> arr;
	public MyPost() {
		this.arr = new ArrayList<Post>();
	}
	public void leggi(int id,String string, Tags tag) {
		Post post = new Post(string,id,tag);
		this.arr.add(post);
	}
	public void aggiungi(String string, Tags tag) {
		Post post = new Post(string,this.arr.size(),tag);
		this.arr.add(post);
	}
	public void pre() throws FileNotFoundException{
		Scanner in = new Scanner(new FileReader("E:\\test.txt"));
		while(in.hasNext()) {
			int tmpid = Integer.valueOf(in.next());
			Tags tmptag = Tags.stringa(in.next());
			String outString = in.nextLine();
			this.leggi(tmpid,outString, tmptag);
		}
		in.close();
		
	}
	public void salva() throws IOException 
	{
		FileWriter fw = new FileWriter("E:\\test.txt");
		fw.write(this.toString());
		fw.close();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<this.arr.size();i++) {
			sb.append(arr.get(i).toString());
			sb.append('\n');
		}
		return sb.toString();
	}
	
}
