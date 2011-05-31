<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>

<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="org.gnenc.internet.mycourses.portlet.MyCoursePortlet" %>
<%@ page import="org.gnenc.internet.mycourses.model.Course" %>

<%@ page import="org.gnenc.internet.mycourses.service.EntityLocalServiceUtil" %>


<portlet:defineObjects />

<liferay-theme:defineObjects />