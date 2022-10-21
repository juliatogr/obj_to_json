package obj_to_json_group.obj_to_json_artifact;

import java.util.ArrayList;

public class ToJson {
	private String client;
	private int numMachines;
	private ArrayList<Product> products;
	
	public ToJson(String client, int numMachines, ArrayList<Product> products) {
		super();
		this.client = client;
		this.numMachines = numMachines;
		this.products = products;
	}
}
