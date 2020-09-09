package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface {

	@Override
	public void insertBlog(Blog blog) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO BLOG(BLOG_ID, BLOG_TITLE, BLOG_DESCRIPTION, CURRENT_DATE) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			preparedStatement.setInt(1, blog.getBlogId());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			preparedStatement.setString(2, blog.getBlogTitle());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			preparedStatement.setString(3, blog.getBlogDescription());
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			preparedStatement.setDate(4, blog.getPostedOn());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		int row = 0;
		try {
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List selectAllBlogs() {
		List<Blog> blogs = new ArrayList<Blog>();
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM BLOG";

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String desciption = resultSet.getString(3);
				Date date = resultSet.getDate(4);
				Blog blog = new Blog(id, title, desciption, date);
				blogs.add(blog);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return blogs;
	}

}