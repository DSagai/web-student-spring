package my.training.site;

import java.util.zip.ZipException;


public class Test {

	public static void main(String[] args) {
		ZipException zip = new ZipException("hi");
		zip.printStackTrace();
		
	}

}
