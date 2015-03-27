package com.example.contactmgr.test.mock;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MockHttpSession implements HttpSession
{
	private Map<String, Object> attributes = new HashMap<String, Object>();

	@Override
	public Object getAttribute(String name)
	{
		return attributes.get(name);
	}

	@Override
	public void setAttribute(String name, Object value)
	{
		attributes.put(name, value);
	}
	
	@Override
	public Enumeration getAttributeNames()
	{
		return null;
	}

	@Override
	public long getCreationTime()
	{
		return 0;
	}

	@Override
	public String getId()
	{
		return null;
	}

	@Override
	public long getLastAccessedTime()
	{
		return 0;
	}

	@Override
	public int getMaxInactiveInterval()
	{
		return 0;
	}

	@Override
	public ServletContext getServletContext()
	{
		return null;
	}

	@Override
	public HttpSessionContext getSessionContext()
	{
		return null;
	}

	@Override
	public Object getValue(String name)
	{
		return null;
	}

	@Override
	public String[] getValueNames()
	{
		return null;
	}

	@Override
	public void invalidate()
	{

	}

	@Override
	public boolean isNew()
	{
		return false;
	}

	@Override
	public void putValue(String name, Object value)
	{

	}

	@Override
	public void removeAttribute(String name)
	{

	}

	@Override
	public void removeValue(String name)
	{

	}

	@Override
	public void setMaxInactiveInterval(int interval)
	{

	}

}
