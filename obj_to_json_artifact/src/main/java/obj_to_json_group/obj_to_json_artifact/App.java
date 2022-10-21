package obj_to_json_group.obj_to_json_artifact;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 

public class App 
{
    public static void main( String[] args )
    {
    	ArrayList<Product> prods = new ArrayList<Product>();
    	prods.add(new Product("Ordinador", 400));
    	prods.add(new Product("Televisió", 800));
    	prods.add(new Product("Projector", 300));
    	
    	ToJson toJson = new ToJson("IT Academy", 30, prods);
    	ObjectMapper om = new ObjectMapper();
    	om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    	ObjectWriter ow = om.writer().withDefaultPrettyPrinter();

    	try {
    		String json = ow.writeValueAsString(toJson);
    		FileOutputStream files = new FileOutputStream("tojson.json");
    		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(files));
    		bw.write(json);
    		bw.close();
    	} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
