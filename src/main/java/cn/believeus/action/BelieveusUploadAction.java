package cn.believeus.action;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.util.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**UEditor文件上传辅助类 */
public class BelieveusUploadAction extends DispatchAction {
	// 输出文件地址
	private String url = "";
	// 上传文件名
	private String fileName = "";
	// 状态
	private String state = "";
	// 文件类型
	private String type = "";
	// 原始文件名
	private String originalName = "";
	// 文件大小
	private String size = "";
	// 获取图标
	private String title = "";
	// 保存路径
	private String savePath = "upload";
	// 文件允许格式
	private String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",
			".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp",
			"odt" };
	// 文件大小限制，单位KB
	private int maxSize = 10000;

	private HashMap<String, String> errorInfo = new HashMap<String, String>();

	// 记住:spring 初始化这个类，必须要是一个无参的构造方法。
	public BelieveusUploadAction() {
		HashMap<String, String> tmp = this.errorInfo;
		tmp.put("SUCCESS", "SUCCESS"); // 默认成功
		tmp.put("NOFILE", "未包含文件上传域");
		tmp.put("TYPE", "不允许的文件格式");
		tmp.put("SIZE", "文件大小超出限制");
		tmp.put("ENTYPE", "请求类型ENTYPE错误");
		tmp.put("REQUEST", "上传请求异常");
		tmp.put("IO", "IO异常");
		tmp.put("DIR", "目录创建失败");
		tmp.put("UNKNOWN", "未知错误");
	}

	// 上传所使用到的常用类。
	public void upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			this.state = this.errorInfo.get("NOFILE");
			return;
		}
		DiskFileItemFactory dff = new DiskFileItemFactory();
		String savePath = this.getFolder(this.savePath, request);
		dff.setRepository(new File(savePath));
		try {
			ServletFileUpload sfu = new ServletFileUpload(dff);
			sfu.setSizeMax(this.maxSize * 1024);
			sfu.setHeaderEncoding("utf-8");
			FileItemIterator fii = sfu.getItemIterator(request);
			while (fii.hasNext()) {
				FileItemStream fis = fii.next();
				if (!fis.isFormField()) {
					// 获取文件名。
					this.originalName = fis.getName().substring(
							fis.getName().lastIndexOf(
									System.getProperty("file.separator")) + 1);
					// 检查文件类型。
					if (!this.checkFileType(this.originalName)) {
						this.state = this.errorInfo.get("TYPE");
						continue;
					}
					this.fileName = this.getName(this.originalName);
					this.type = this.getFileExt(this.fileName);
					this.url = savePath + "/" + this.fileName;

					// 将客户端的本地文件转变成一个流
					BufferedInputStream in = new BufferedInputStream(
							fis.openStream());
					FileOutputStream out = new FileOutputStream(new File(
							this.getPhysicalPath(this.url, request)));
					BufferedOutputStream output = new BufferedOutputStream(out);
					Streams.copy(in, output, true);
					this.state = this.errorInfo.get("SUCCESS");
					// UE中只会处理单张上传，完成后即退出
					// 返回文件的相关信息。
					response.getWriter().print(
							"{'title':'" + this.getTitle() + "','url':'"
									+ this.getUrl() + "','fileType':'"
									+ this.getType() + "','state':'"
									+ this.getState() + "','original':'"
									+ this.getOriginalName() + "'}");
					break;
				} else {
					String fname = fis.getFieldName();
					// 只处理title，其余表单请自行处理
					if (!fname.equals("pictitle")) {
						continue;
					}
					// 读取文本数据
					BufferedInputStream in = new BufferedInputStream(
							fis.openStream());
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(in));
					StringBuffer result = new StringBuffer();
					while (reader.ready()) {
						result.append((char) reader.read());
					}
					this.title = new String(result.toString().getBytes(),
							"utf-8");
					reader.close();
				}
			}
		} catch (SizeLimitExceededException e) {
			this.state = this.errorInfo.get("SIZE");
		} catch (InvalidContentTypeException e) {
			this.state = this.errorInfo.get("ENTYPE");
		} catch (FileUploadException e) {
			this.state = this.errorInfo.get("REQUEST");
		} catch (Exception e) {
			this.state = this.errorInfo.get("UNKNOWN");
		}
	}

	// 文件类型判断
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

	// 获取文件扩展名
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	// 依据原始文件名生成新文件名
	private String getName(String fileName) {
		Random random = new Random();
		return this.fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + this.getFileExt(fileName);
	}

	// 根据字符串创建本地目录 并按照日期建立子目录返回
	private String getFolder(String path, HttpServletRequest request) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		path += "/" + formater.format(new Date());
		File dir = new File(this.getPhysicalPath(path, request));
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				this.state = this.errorInfo.get("DIR");
				return "";
			}
		}
		return path;
	}

	// 根据传入的虚拟路径获取物理路径
	private String getPhysicalPath(String path, HttpServletRequest request) {
		String servletPath = request.getServletPath();
		String realPath = request.getSession().getServletContext()
				.getRealPath(servletPath);
		return new File(realPath).getParent() + "/" + path;
	}

	// 涂鸦图片的相关处理。
	public void scrawlUp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String param = request.getParameter("action");
		String[] fileType = { ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
		this.setAllowFiles(fileType);
		this.setMaxSize(10000); // 单位KB
		if (param != null && param.equals("tmpImg")) {
			this.upload(mapping, form, request, response);
			response.getWriter().print(
					"<script>parent.ue_callback('" + this.getUrl() + "','"
							+ this.getState() + "')</script>");
		}
	}

	// 获取视频数据.
	public void getMovie(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		StringBuffer readOneLineBuff = new StringBuffer();
		String content = "";
		String searchkey = request.getParameter("searchKey");
		String videotype = request.getParameter("videoType");
		try {
			searchkey = URLEncoder.encode(searchkey, "utf-8");
			URL url = new URL(
					"http://api.tudou.com/v3/gw?method=item.search&appKey=myKey&format=json&kw="
							+ searchkey + "&pageNo=1&pageSize=20&channelId="
							+ videotype + "&inDays=7&media=v&sort=s");
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String line = "";
			while ((line = reader.readLine()) != null) {
				readOneLineBuff.append(line);
			}
			content = readOneLineBuff.toString();
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		response.getWriter().print(content);
	}

	// 获取远程图片.
	public void getRemoteImage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = request.getParameter("upfile");
		String state = "远程图片抓取成功！";

		String filePath = "upload";
		String[] arr = url.split("ue_separate_ue");
		String[] outSrc = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {

			// 保存文件路径
			String str = request.getServletPath();
			// String str = application.getRealPath(request.getServletPath());
			File f = new File(str);
			String savePath = f.getParent() + "/" + filePath;
			// 格式验证
			String type = getFileType(arr[i]);
			if (type.equals("")) {
				state = "图片类型不正确！";
				continue;
			}
			String saveName = Long.toString(new Date().getTime()) + type;
			// 大小验证
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection conn = (HttpURLConnection) new URL(arr[i])
					.openConnection();
			if (conn.getContentType().indexOf("image") == -1) {
				state = "请求地址头不正确";
				continue;
			}
			if (conn.getResponseCode() != 200) {
				state = "请求地址不存在！";
				continue;
			}
			File dir = new File(savePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File savetoFile = new File(savePath + "/" + saveName);
			outSrc[i] = filePath + "/" + saveName;
			try {
				InputStream is = conn.getInputStream();
				OutputStream os = new FileOutputStream(savetoFile);
				int b;
				while ((b = is.read()) != -1) {
					os.write(b);
				}
				os.close();
				is.close();
				// 这里处理 inputStream
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("页面无法访问");
			}
		}
		String outstr = "";
		for (int i = 0; i < outSrc.length; i++) {
			outstr += outSrc[i] + "ue_separate_ue";
		}
		outstr = outstr.substring(0, outstr.lastIndexOf("ue_separate_ue"));
		response.getWriter().print(
				"{'url':'" + outstr + "','tip':'" + state + "','srcUrl':'"
						+ url + "'}");
	}

	// 获取图片的类型。
	public String getFileType(String fileName) {
		String[] fileType = { ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
		Iterator<String> type = Arrays.asList(fileType).iterator();
		while (type.hasNext()) {
			String t = type.next();
			if (fileName.endsWith(t)) {
				return t;
			}
		}
		return "";
	}

	// 图片在线管理的相关处理。
	public void imageManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String imgStr = "";
		String realpath = getRealPath(request, savePath) + "/" + savePath;
		List<File> files = getFiles(realpath, new ArrayList<File>());
		for (File file : files) {
			imgStr += file.getPath().replace(getRealPath(request, savePath), "")
					+ "ue_separate_ue";
		}
		if (imgStr != "") {
			imgStr = imgStr.substring(0, imgStr.lastIndexOf("ue_separate_ue"))
					.replace(File.separator, "/").trim();
		}
		response.getWriter().print(imgStr);

	}
	//图片在线管理的相关方法处理。
	public List<File> getFiles(String realpath, List<File> files) {
		File realFile = new File(realpath);
		if (realFile.isDirectory()) {
			File[] subfiles = realFile.listFiles();
			for (File file : subfiles) {
				if (file.isDirectory()) {
					getFiles(file.getAbsolutePath(), files);
				} else {
					if (!getFileType(file.getName()).equals("")) {
						files.add(file);
					}
				}
			}
		}
		return files;
	}
	//图片在线管理的相关方法处理。获得真实的路径。
	public String getRealPath(HttpServletRequest request, String path) {
		ServletContext application = request.getSession().getServletContext();
		String str = application.getRealPath(request.getServletPath());
		return new File(str).getParent();
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setAllowFiles(String[] allowFiles) {
		this.allowFiles = allowFiles;
	}

	public void setMaxSize(int size) {
		this.maxSize = size;
	}

	public String getSize() {
		return this.size;
	}

	public String getUrl() {
		return this.url;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getState() {
		return this.state;
	}

	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String getOriginalName() {
		return this.originalName;
	}
}