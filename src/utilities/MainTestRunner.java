package utilities;
/**
 * Adding Testcase menthod names
 * 
 *by Harish Reddy
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.TestNG;

public class MainTestRunner {
	private static Set<String> methodSet = new HashSet<String>();
	public static Properties commonProperties = null;

	static {

		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	@SuppressWarnings("unchecked")
	public static void runTestCases() {

		try {

			Set<String> testMethodSet = null;	
			
/////////////////////////-----------add testcases methods------- //////////////////////////////
			methodSet.add("TC1_Invalidlogin");
			methodSet.add("TC2_validatelogin");
			methodSet.add("TC3_LoginandLogout");
//			methodSet.add("TC4_LoginandLogout");
//			methodSet.add("TC5_UploadDoc");
//			methodSet.add("TC6_Pay");
//			methodSet.add("TC7_TripleClick");
//			methodSet.add("TC8_MyPayees");
			Map<String, Set<String>> q2oTestCasesMap = new HashMap<String, Set<String>>();
			q2oTestCasesMap.put("com.testsuites.Vwallet", methodSet);
			System.out.println("0.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			TestNG testng = new TestNG();
			System.out.println("1.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			Class classObj[] = new Class[q2oTestCasesMap.keySet().size()];
			System.out.println("2.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			int i = 0;

			for (Iterator iterator = q2oTestCasesMap.keySet().iterator(); iterator
					.hasNext(); i++) {
				String className = (String) iterator.next();
				System.out.println("vv:" + className);
				classObj[i] = Class.forName(className.trim());

				 methodSet.addAll(q2oTestCasesMap.get(className));
			}

			testng.setTestClasses(classObj);
			testng.addListener(new com.reports.MainListener());

			System.out.println("MethodSet :" + methodSet.size());
			testng.setMethodInterceptor(new IMethodInterceptor() {

				@Override
				public List<IMethodInstance> intercept(
						List<IMethodInstance> inMethod, ITestContext arg1) {
					List<IMethodInstance> methodList = new ArrayList<IMethodInstance>();

					for (IMethodInstance m : inMethod) {
						String methodName = m.getMethod().getMethodName();
						System.out.println("x:" + methodName);
						if (methodSet.contains(methodName)) {
							methodList.add(m);
							System.out.println("If loop in Main Test Runner");
						}
						System.out.println("For loop in Main Test Runner");
					}
					System.out.println("intercept function in Main Test Runner");
					return methodList;
				}
			});
			System.out.println("Testng execution is about to Start"); 
			testng.run();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
