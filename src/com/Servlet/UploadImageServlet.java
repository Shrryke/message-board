package com.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Entity.User;
import com.Service.Impl.UserServiceImpl;


/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet("/UploadImageServlet")
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserServiceImpl service=new UserServiceImpl();
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			List<FileItem> items=null;
			try {
				items=upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator<FileItem> iter=items.iterator();
			while(iter.hasNext()) {
				FileItem item=iter.next();
				String itemName=item.getFieldName();
				int sno=-1;
				String sname=null;
				if(!item.isFormField()) {
					User user=(User)request.getSession().getAttribute("user");
					String fileName=item.getName();
					String suffix=fileName.substring(fileName.lastIndexOf("."));
					fileName=user.getUaccount()+suffix;
					String path=request.getRealPath("images");
					File file=new File(path,fileName);
					try {
						item.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					user.setImage("images/"+fileName);
					service.UpdateImage(user, "images/"+fileName);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("myInfo.jsp").forward(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
