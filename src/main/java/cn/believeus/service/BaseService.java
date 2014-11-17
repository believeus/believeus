package cn.believeus.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import cn.believeus.dao.BaseDao;
import cn.believeus.form.StudentCommonForm;
import cn.believeus.model.Tuser;

@Service
public class BaseService extends BaseDao{
	private static final Log log = LogFactory.getLog(BaseService.class);
	@Resource
	private BaseDao baseDao;

	
	

	
	
}
