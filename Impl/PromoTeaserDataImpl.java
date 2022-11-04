package com.ttnretail.core.models.impl;




import com.ttnretail.core.models.PromoTeaserData;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;



@Model(adaptables =  Resource.class, adapters = PromoTeaserData.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class PromoTeaserDataImpl implements PromoTeaserData {



    @Inject
    String pretitle;

    @Inject
    String title;

    @Inject
    String description;

    @Inject
    String categoryId;


    static String actionUrl;


    @Override
    public String getPreTitle() { return pretitle; }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDesc() { return description; }




    public static void setActionUrl(String actionPath){
        actionUrl = actionPath;
    }

    @Override
    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public String getActionUrl() {
        return actionUrl;
    }

}
