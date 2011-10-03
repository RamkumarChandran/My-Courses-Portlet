/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.gnenc.internet.mycourses.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import org.gnenc.internet.mycourses.model.CourseClp;
import org.gnenc.internet.mycourses.model.HostClp;
import org.gnenc.internet.mycourses.model.SiteClp;
import org.gnenc.internet.mycourses.model.UserEnrollmentClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "My-Courses-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CourseClp.class.getName())) {
			CourseClp oldCplModel = (CourseClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("org.gnenc.internet.mycourses.model.impl.CourseImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCourseId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCourseId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setSiteId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getSiteId());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(SiteClp.class.getName())) {
			SiteClp oldCplModel = (SiteClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("org.gnenc.internet.mycourses.model.impl.SiteImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSiteId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getSiteId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSiteName",
							new Class[] { String.class });

					String value1 = oldCplModel.getSiteName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUrl",
							new Class[] { String.class });

					String value2 = oldCplModel.getUrl();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setEmailDomain",
							new Class[] { String.class });

					String value3 = oldCplModel.getEmailDomain();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDbServer",
							new Class[] { String.class });

					String value4 = oldCplModel.getDbServer();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setDbName",
							new Class[] { String.class });

					String value5 = oldCplModel.getDbName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setDbUser",
							new Class[] { String.class });

					String value6 = oldCplModel.getDbUser();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setDbPass",
							new Class[] { String.class });

					String value7 = oldCplModel.getDbPass();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value8 = new Long(oldCplModel.getCompanyId());

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(UserEnrollmentClp.class.getName())) {
			UserEnrollmentClp oldCplModel = (UserEnrollmentClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCourseId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getCourseId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setLastRefresh",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getLastRefresh();

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(HostClp.class.getName())) {
			HostClp oldCplModel = (HostClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("org.gnenc.internet.mycourses.model.impl.HostImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setHostId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getHostId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSiteId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getSiteId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRemoteSiteId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getRemoteSiteId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPeerId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getPeerId());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"org.gnenc.internet.mycourses.model.impl.CourseImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CourseClp newModel = new CourseClp();

					Method method0 = oldModelClass.getMethod("getId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getCourseId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCourseId(value1);

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getSiteId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setSiteId(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"org.gnenc.internet.mycourses.model.impl.SiteImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SiteClp newModel = new SiteClp();

					Method method0 = oldModelClass.getMethod("getSiteId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setSiteId(value0);

					Method method1 = oldModelClass.getMethod("getSiteName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setSiteName(value1);

					Method method2 = oldModelClass.getMethod("getUrl");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUrl(value2);

					Method method3 = oldModelClass.getMethod("getEmailDomain");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setEmailDomain(value3);

					Method method4 = oldModelClass.getMethod("getDbServer");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDbServer(value4);

					Method method5 = oldModelClass.getMethod("getDbName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setDbName(value5);

					Method method6 = oldModelClass.getMethod("getDbUser");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setDbUser(value6);

					Method method7 = oldModelClass.getMethod("getDbPass");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setDbPass(value7);

					Method method8 = oldModelClass.getMethod("getCompanyId");

					Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					UserEnrollmentClp newModel = new UserEnrollmentClp();

					Method method0 = oldModelClass.getMethod("getId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getUserId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setUserId(value1);

					Method method2 = oldModelClass.getMethod("getCourseId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setCourseId(value2);

					Method method3 = oldModelClass.getMethod("getLastRefresh");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setLastRefresh(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"org.gnenc.internet.mycourses.model.impl.HostImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					HostClp newModel = new HostClp();

					Method method0 = oldModelClass.getMethod("getHostId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setHostId(value0);

					Method method1 = oldModelClass.getMethod("getSiteId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setSiteId(value1);

					Method method2 = oldModelClass.getMethod("getRemoteSiteId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setRemoteSiteId(value2);

					Method method3 = oldModelClass.getMethod("getPeerId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setPeerId(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}