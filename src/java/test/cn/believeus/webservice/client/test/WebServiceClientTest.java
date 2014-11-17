package cn.believeus.webservice.client.test;

import org.junit.Test;

import cn.believeus.webservice.client.DoctorWebService;
import cn.believeus.webservice.client.DoctorWebServiceService;
import cn.believeus.webservice.client.TDoctor;


public class WebServiceClientTest {

	@Test
	public void webserviceClientTest(){
		DoctorWebServiceService doctorWebServiceService=new DoctorWebServiceService();
		DoctorWebService doctorWebService = doctorWebServiceService.getDoctorWebServicePort();
		TDoctor doctor = doctorWebService.findDoctorById(23);
		System.out.println(doctor+"");
	}
}
