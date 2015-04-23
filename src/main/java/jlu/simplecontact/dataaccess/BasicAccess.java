package jlu.simplecontact.dataaccess;

import java.util.List;


public interface BasicAccess<T> {

	public long create(T t);
	public int update(T t);
	public List<T> find();
	public int delete(long id);
	public int delete(long... ids);
}
