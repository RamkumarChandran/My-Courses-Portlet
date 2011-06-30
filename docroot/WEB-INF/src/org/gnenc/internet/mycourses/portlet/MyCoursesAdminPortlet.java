package org.gnenc.internet.mycourses.portlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.impl.EntityImpl;
import org.gnenc.internet.mycourses.service.EntityLocalServiceUtil;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class MyCoursesAdminPortlet extends MVCPortlet {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addEntity(ActionRequest request, ActionResponse response)
    	throws Exception {
	    Entity entity = new EntityImpl();
	    
	    entity.setEntityId(CounterLocalServiceUtil.increment(Entity.class.getName()));
	    entity.setEntityName(ParamUtil.getString(request, "entityName"));
	    entity.setUrl(ParamUtil.getString(request, "entityUrl"));
	    entity.setDbServer(ParamUtil.getString(request, "entityDbServer"));
	    entity.setDbName(ParamUtil.getString(request, "entityDbName"));
	    entity.setDbUser(ParamUtil.getString(request, "entityDbUser"));
	    entity.setDbPass(ParamUtil.getString(request, "entityDbPass"));
	    		
	    ArrayList<String> errors = new ArrayList();
	
	    if (validateEntity(entity, errors)) {
	        EntityLocalServiceUtil.addEntity(entity);
	        SessionMessages.add(request, "entitySaved");
	
	    } else {
	    	
	    	for (String error : errors) {
	    		SessionErrors.add(request, error);
	    	
	    	}
	    	
	    }
	
	}
	
	@SuppressWarnings("unchecked")
	public static List<Entity> getEntities (RenderRequest request) {
		
		List<Entity> tempResults;
		
		try {
            tempResults = EntityLocalServiceUtil.getEntities(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
        }

        catch (SystemException ex) {
            tempResults  = Collections.EMPTY_LIST;

        }

        return tempResults;
        
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean validateEntity(Entity entity, List errors) {
        boolean valid = true;

        if (Validator.isNull(entity.getEntityName())) {
            errors.add("entity-name-required");
            valid = false;
        }
        
        if (Validator.isNull(entity.getUrl())) {
            errors.add("entity-url-required");
            valid = false;
        } else {
        	//Validate URL
        }
        
        if (Validator.isNull(entity.getDbServer())) {
            errors.add("entity-db-server-required");
            valid = false;
        } else {
        	//Validate URL
        }
        
        if (Validator.isNull(entity.getDbName())) {
            errors.add("entity-db-name-required");
            valid = false;
        }
        
        if (Validator.isNull(entity.getDbUser())) {
            errors.add("entity-db-user-required");
            valid = false;
        }
        
        if (Validator.isNull(entity.getDbPass())) {
            errors.add("entity-db-pass-required");
            valid = false;
        }

        return valid;

    }
	
}