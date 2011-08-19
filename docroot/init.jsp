<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> --%>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>

<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>

<%@ page import="org.gnenc.internet.mycourses.portlet.MyCoursesPortlet" %>
<%@ page import="org.gnenc.internet.mycourses.portlet.MyCoursesAdminPortlet" %>
<%@ page import="org.gnenc.internet.mycourses.model.Course" %>
<%@ page import="org.gnenc.internet.mycourses.model.Entity" %>
<%@ page import="org.gnenc.internet.mycourses.model.Host" %>

<%@ page import="org.gnenc.internet.mycourses.model.impl.EntityImpl" %>
<%@ page import="org.gnenc.internet.mycourses.service.EntityLocalServiceUtil" %>
<%@ page import="org.gnenc.internet.mycourses.service.HostLocalServiceUtil" %>


<portlet:defineObjects />

<liferay-theme:defineObjects />