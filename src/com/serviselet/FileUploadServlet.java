package com.serviselet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long fileSize = 1024 * 1024;
		// 判断文件是否上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error", "数据有误");
			request.getRequestDispatcher("upload.jsp").forward(request, response);
			return;
		}

		// 创建对象
		// 1.文件上传参数的配置 对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2.创建文件上传的对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 3.设置缓存的临时目录
		File fileTemp = new File(System.getProperty("java.io.tmpdir"));
		// 4.设置上传的路径
		String uploadDRI = this.getServletContext().getRealPath("/upload");
		File file = new File(uploadDRI);
		// 5.判断文件夹是否存在
		if (!file.exists()) {
			// 创建文件夹
			file.mkdirs();
		}

		// 配置上传的参数
		// 1.配置缓存目录
		factory.setRepository(fileTemp);
		// 2..上传的时候 数据到内存的最大值
		factory.setSizeThreshold(1024 * 1024 * 3);// 3M
		// 3..设置文件上传的大小
		upload.setFileSizeMax(fileSize * 200); // 200M
		// 4.处理中文
		upload.setHeaderEncoding("UTF-8");

		// 获得文件
		// 1.创建文件上传集合对象
		List<FileItem> list;
		try {
			// 2.获得上传的文件
			list = upload.parseRequest(request);
			// 3.文件你上传的名称
			String fileName = null;
			// 4.取文件
			for (FileItem fileItem : list) {
				fileName = new File(fileItem.getName()).getName();
				System.out.println(fileName);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//上传
	
	}

}
