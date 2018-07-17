package org.mybatis.generator.main;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * MyBatis Generator []
 * @author CHIANGFAI
 *
 */
public class MBG {
	
	public static void generator() throws Exception {
		
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(MBG.class.getResource("/generatorConfig.xml").getFile());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	public static void main(String[] args) {
		// classpath
		//System.out.println(MBG.class.getResource("/").toString());
		
		try {
			MBG.generator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
