package jlu.simplecontact.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import jlu.simplecontact.models.Contact;
import jlu.simplecontact.models.ContactBuilder;

public class JdbcAccess extends AbstractJdbcAccess<Contact> implements
		BasicAccess<Contact> {

	public JdbcAccess(ConnectionManager connectionManager) {
		super(connectionManager);
	}

	@Override
	public List<Contact> find() {
		try (Connection conn = getConnection()) {
			PreparedStatement psmt = conn.prepareStatement("select");
			ResultSet rs = psmt.executeQuery();

			List<Contact> results = new ArrayList<>();
			while (rs.next()) {

				results.add(ContactBuilder.newInstance()
						.email(rs.getString("email")).id(rs.getLong("id"))
						.name(rs.getString("name"))
						.phone(rs.getString("phone")).build());

			}

			return Collections.unmodifiableList(results);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public long create(Contact t) {
		String insertStatement = "insert";
		try (Connection conn = getConnection()) {
			PreparedStatement psmt = conn.prepareStatement(insertStatement,
					Statement.RETURN_GENERATED_KEYS);

			psmt.executeQuery();
			ResultSet rs = psmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getLong(1);
			} else {
				return -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(long id) {

		String deleteStatement = "delete where id=?";
		try (Connection conn = getConnection()) {

			PreparedStatement psmt = conn.prepareStatement(deleteStatement);
			psmt.setLong(1, id);

			return psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int delete(long... ids) {

		if (ids.length == 1) {
			return delete(ids);
		} else if (ids.length > 1) {
			String deleteStatement = "delete where id in ";
			String[] questionMarks = new String[ids.length];
			Arrays.fill(questionMarks, "?");
			String streamedQuestionMarks = Arrays.stream(questionMarks)
					.collect(Collectors.joining(","));

			StringBuilder builder = new StringBuilder(deleteStatement);
			builder.append("(").append(streamedQuestionMarks).append(")");
			try (Connection conn = getConnection()) {

				PreparedStatement psmt = conn.prepareStatement(builder
						.toString());

				for (int i = 0, j = 1; i < ids.length; i++, j++) {
					psmt.setLong(j, ids[i]);
				}

				return psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		else {
			return 0;
		}
		return 0;
	}

	@Override
	public int update(Contact t) {
		return 0;
	}

}
