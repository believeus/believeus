package cn.believeus.webservice.service;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.springframework.stereotype.Service;
import cn.believeus.dao.BaseDao;
import cn.believeus.model.TDoctor;

@Service
@WebService
public class DoctorWebService{
	@Resource
	private BaseDao baseDao;
	@Resource
	private WebServiceContext wsctx;
	@WebMethod
	public TDoctor findDoctorById(@WebParam(name = "id") Integer id) {
		TDoctor doctor = (TDoctor) baseDao.findObject(TDoctor.class, id);
		return doctor;
	}
}
