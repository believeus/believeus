package cn.believeus.system.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BelieveusFileDowbload extends Action{
	@Override
 	public ActionForward execute(ActionMapping mapping, ActionForm form,
    			HttpServletRequest request, HttpServletResponse response)
    			throws Exception {
		    String filePath="/home/xihuan/Readme.txt";   //指定读取某个文件。
		    String saveFilePath="Readme.txt";  // 文件的默认保存名。
			File file = new File(filePath);
			if (!file.exists()) {
			response.sendError(404, "File not found!");
			return mapping.findForward("error"); 
			}
			response.reset(); // 非常重要
			response.setContentType("application/octet-stream");
            response.setContentType("application/OCTET-STREAM;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + saveFilePath);
            response.getOutputStream();
            BufferedOutputStream buffOut=new BufferedOutputStream( response.getOutputStream());
            BufferedInputStream buffin=new BufferedInputStream(new FileInputStream(filePath));
            byte[] buffer = new byte[1024];
            int i = -1;
            while ((i = buffin.read(buffer)) != -1) {
             buffOut.write(buffer, 0, i);
            }
            buffOut.flush();
            buffOut.close();
            buffin.close();
            
			return mapping.findForward("index");
			}
	}