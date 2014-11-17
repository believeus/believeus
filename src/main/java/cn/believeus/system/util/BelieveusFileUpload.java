package cn.believeus.system.util;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BelieveusFileUpload extends Action{
	@Override
 	public ActionForward execute(ActionMapping mapping, ActionForm form,
    			HttpServletRequest request, HttpServletResponse response)
    			throws Exception {
		// 判断该表单域是否是带有文件表单域的表单 <form action="" method="post" enctype="multipart/form-data">
				HashMap<String, Serializable> requestMap = new HashMap<String, Serializable>();
				boolean multipartContent = ServletFileUpload
						.isMultipartContent(request);
				if (multipartContent) {
					// 在内存中创建一个临时仓库
					DiskFileItemFactory tempCached = new DiskFileItemFactory();
					// 在内存中设置一个缓存
					tempCached.setSizeThreshold(10240 * 10); // 单位：字节
					String temDir = "/home/temp/date";
					File temDirFile = new File(temDir);
					if (!temDirFile.exists()) {
						temDirFile.mkdirs();
					}
					// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
					// 相当于swap分区,内存和硬盘数据交互的地方
					tempCached.setRepository(new File(temDir));
					// 创建上传类
					ServletFileUpload upload = new ServletFileUpload(tempCached);
					// 设置最大上传大小
					upload.setSizeMax(50 * 1024 * 1000);
					try {
						String fieldName = "";
						String fileValue = "";
						// 因为form类型是enctype="multipart/form-data" 必须要对request解析，
						@SuppressWarnings("rawtypes")
						List requestList = upload.parseRequest(request);
						@SuppressWarnings("rawtypes")
						Iterator iterator = requestList.iterator();
						while (iterator.hasNext()) {
							// 每个input都当作一个FileItem
							FileItem item = (FileItem) iterator.next();
							// 如果是正常的表单数据 例如<input type="text"/>
							if (item.isFormField()) {
								// 获得表单的字段名
								fieldName = item.getFieldName();
								// 获取表单的数据,tomcat会自动的将中文转换成iso8859-1
								//  tem.getString() 获取表单数据里面的值
								fileValue = BelieveusEncodeConver.ISOToUTF8(item
										.getString());
								requestMap.put(fieldName, fileValue);
							} else if (!item.isFormField()) { //  如果是<input name="" type="file"/>
								// 获取 文件的名字
								fieldName = item.getFieldName();
								// 一个item就代表一个文件
								requestMap.put(fieldName, item);
							}
						}
					} catch (FileUploadException e) {
						e.printStackTrace();
					}
				}
		return mapping.findForward("index");  
		
	}

}